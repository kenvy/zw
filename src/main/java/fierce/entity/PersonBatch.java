package fierce.entity;

/**
 * Created by zw on 2016/5/10
 * Email: yaoyaolingma@126.com
 */
public class PersonBatch {

    private String lastName;
    private String firstName;

    public PersonBatch() {

    }

    public PersonBatch(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "firstName: " + firstName + ", lastName: " + lastName;
    }
}
