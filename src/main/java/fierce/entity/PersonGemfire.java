package fierce.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.Region;

/**
 * Created by Fierce on 2016/5/10
 * Email: yaoyaolingma@126.com
 */
@Region("Quotes")
public class PersonGemfire {

    @Id
    public String name;
    public int age;

    @PersistenceConstructor
    public PersonGemfire(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " is " + age + " years old.";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
