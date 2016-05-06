package fierce.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by zw on 2016/5/6
 * Email: yaoyaolingma@126.com
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private String name;
    private String blog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", blog=" + blog + "]";
    }
}
