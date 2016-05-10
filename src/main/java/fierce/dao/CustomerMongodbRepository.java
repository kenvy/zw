package fierce.dao;

import fierce.entity.CustomerMongodb;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by zw on 2016/5/5
 * Email: yaoyaolingma@126.com
 */
public interface CustomerMongodbRepository extends MongoRepository<CustomerMongodb, String> {

    public CustomerMongodb findByFirstName(String firstName);

    public List<CustomerMongodb> findByLastName(String lastName);
}
