package fierce.dao;

import fierce.entity.PersonGemfire;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Fierce on 2016/5/10
 * Email: yaoyaolingma@126.com
 */
public interface PersonGemfireRepository extends CrudRepository<PersonGemfire, String> {

    PersonGemfire findByName(String name);

    Iterable<PersonGemfire> findByAgeGreaterThan(int age);

    Iterable<PersonGemfire> findByAgeLessThan(int age);

    Iterable<PersonGemfire> findByAgeGreaterThanAndAgeLessThan(int age1, int age2);

}
