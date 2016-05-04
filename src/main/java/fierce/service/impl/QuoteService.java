package fierce.service.impl;

import fierce.entity.QuoteGemfire;
import fierce.entity.QuoteResponse;
import fierce.service.IQuoteService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

/**
 * Created by zw on 2016/5/4
 * Email: yaoyaolingma@126.com
 */
@SuppressWarnings("unused")
@Service
public class QuoteService implements IQuoteService {

    protected static final String ID_BASED_QUOTE_SERVICE_URL = "http://gturnquist-quoters.cfapps.io/api/{id}";
    protected static final String RANDOM_QUOTE_SERVICE_URL = "http://gturnquist-quoters.cfapps.io/api/random";

    private volatile boolean cacheMiss = false;

    private RestTemplate quoteServiceTemplate = new RestTemplate();

    /**
     * Determines whether the previous service method invocation resulted in a cache miss.
     *
     * @return a boolean value indicating whether the previous service method invocation resulted in a cache miss.
     */
    public boolean isCacheMiss() {
        boolean cacheMiss = this.cacheMiss;
        this.cacheMiss = false;
        return cacheMiss;
    }

    protected void setCacheMiss() {
        this.cacheMiss = true;
    }

    /**
     * Requests a quote with the given identifier.
     *
     * @param id the identifier of the {@link QuoteGemfire} to request.
     * @return a {@link QuoteGemfire} with the given ID.
     */
    @Cacheable("Quotes")
    public QuoteGemfire requestQuote(Long id) {
        setCacheMiss();
        return requestQuote(ID_BASED_QUOTE_SERVICE_URL, Collections.singletonMap("id", id));
    }

    /**
     * Requests a random quote.
     *
     * @return a random {@link QuoteGemfire}.
     */
    @CachePut(cacheNames = "Quotes", key = "#result.id")
    public QuoteGemfire requestRandomQuote() {
        setCacheMiss();
        return requestQuote(RANDOM_QUOTE_SERVICE_URL);
    }

    protected QuoteGemfire requestQuote(String URL) {
        return requestQuote(URL, Collections.emptyMap());
    }

    protected QuoteGemfire requestQuote(String URL, Map<String, Object> urlVariables) {
        QuoteResponse quoteResponse = quoteServiceTemplate.getForObject(URL, QuoteResponse.class, urlVariables);
        return quoteResponse.getQuote();
    }

    @Override
    public QuoteGemfire testGemfire(Long id) {
        QuoteGemfire quote = _testGemfire(12l);
        _testGemfire(quote.getId());
        _testGemfire(10l);
        return quote;
    }

    private QuoteGemfire _testGemfire(Long id) {
        long startTime = System.currentTimeMillis();
        QuoteGemfire quote = (id != null ? this.requestQuote(id) : this.requestRandomQuote());
        long elapsedTime = System.currentTimeMillis();
        System.out.printf("\"%1$s\"%nCache Miss [%2$s] - Elapsed Time [%3$s ms]%n", quote,
                this.isCacheMiss(), (elapsedTime - startTime));
        return quote;
    }
}
