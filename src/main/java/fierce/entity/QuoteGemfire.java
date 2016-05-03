package fierce.entity;

/**
 * Created by zw on 2016/5/3
 * Email: yaoyaolingma@126.com
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.util.ObjectUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("unused")
public class QuoteGemfire {

    private Long id;

    private String quote;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(final String quote) {
        this.quote = quote;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Quote)) {
            return false;
        }

        QuoteGemfire that = (QuoteGemfire) obj;

        return ObjectUtils.nullSafeEquals(this.getId(), that.getId());
    }

    @Override
    public int hashCode() {
        int hashValue = 17;
        hashValue = 37 * hashValue + ObjectUtils.nullSafeHashCode(getId());
        return hashValue;
    }

    @Override
    public String toString() {
        return getQuote();
    }

}
