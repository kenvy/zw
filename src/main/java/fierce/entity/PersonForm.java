package fierce.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by zw on 2016/5/10
 * Email: yaoyaolingma@126.com
 */
public class PersonForm {

    @Size(min = 2, max = 30, message = "should ..1")
    private String name;

    @NotNull(message = "should  ..3")
    @Min(value = 18, message = "should ..2")
    private Integer age;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return "Person(Name: " + this.name + ", Age: " + this.age + ")";
    }

}
