package fierce.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by zw on 2016/5/5
 * Email: yaoyaolingma@126.com
 */
@Document(collection = "TestCustomer")
public class CustomerMongodb {
    @Id
    private String id;

    private String firstName;
    private String lastName;

    public CustomerMongodb() {
    }

    public CustomerMongodb(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "CustomerMongodb [id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}
