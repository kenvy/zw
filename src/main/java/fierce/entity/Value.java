package fierce.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by zw on 2016/4/21
 * Email: yaoyaolingma@126.com
 */
@JsonIgnoreProperties
public class Value {
    private Long id;
    private String quote;

    public Value() {
    }

    public Long getId() {
        return this.id;
    }

    public String getQuote() {
        return this.quote;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "Value{" +
                "id=" + id +
                ", quote='" + quote + '\'' +
                '}';
    }
}
