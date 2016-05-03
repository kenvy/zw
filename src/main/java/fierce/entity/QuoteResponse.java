package fierce.entity;

/**
 * Created by zw on 2016/5/3
 * Email: yaoyaolingma@126.com
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("unused")
public class QuoteResponse {

    @JsonProperty("value")
    private QuoteGemfire quote;

    @JsonProperty("type")
    private String status;

    public QuoteGemfire getQuote() {
        return quote;
    }

    public void setQuote(final QuoteGemfire quote) {
        this.quote = quote;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("{ @type = %1$s, quote = '%2$s', status = %3$s }",
                getClass().getName(), getQuote(), getStatus());
    }

}
