package fierce.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by zw on 2016/5/3
 * Email: yaoyaolingma@126.com
 */
public class GreetingHypermedia extends ResourceSupport {

    private final String content;

    @JsonCreator
    public GreetingHypermedia(@JsonProperty("content") String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}