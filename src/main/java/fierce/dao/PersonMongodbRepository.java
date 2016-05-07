package fierce.dao;

import fierce.entity.PersonMongodb;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Fierce on 2016/5/8
 * Email: yaoyaolingma@126.com
 */
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonMongodbRepository extends MongoRepository<PersonMongodb, String> {

    List<PersonMongodb> findByLastName(@Param("name") String name);

}
