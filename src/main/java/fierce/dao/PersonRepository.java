package fierce.dao;

import fierce.entity.Person;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Fierce on 2016/4/29.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByLastName(@Param("name") String name);

    List<Person> findByTeammatesName(String name);

}
