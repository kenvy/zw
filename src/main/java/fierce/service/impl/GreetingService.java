package fierce.service.impl;

import fierce.dao.IGreetingDao;
import fierce.dao.PersonRepository;
import fierce.entity.Customer;
import fierce.entity.Person;
import fierce.service.IGreetingService;
import org.neo4j.graphdb.Transaction;
import org.neo4j.io.fs.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zw on 2016/4/21
 * Email: yaoyaolingma@126.com
 */
@Service
public class GreetingService implements IGreetingService {

    @Autowired
    IGreetingDao greetingDao;

    @Autowired
    PersonRepository personRepository;
    @Autowired
    GraphDatabase graphDatabase;


    private static final Logger log = LoggerFactory.getLogger("GreetingService");

    @Override
    public List<Customer> accessMysqlWithJdbc() {
        log.info("Creating tables");
        //greetingDao.initTable();

        //greetingDao.updateWithBatch();

        log.info("Querying for customer records where first_name = 'Josh':");
        return greetingDao.selectCustomersByName();
    }

    @Override
    public void testRabbitmq() {
        greetingDao.testRabbitmq();
    }

    @Override
    public void testNeo4j_NoSql_db() {

        Person greg = new Person("Greg");
        Person roy = new Person("Roy");
        Person craig = new Person("Craig");

        List<Person> team = Arrays.asList(greg, roy, craig);

        log.info("Before linking up with Neo4j...");

        team.stream()
                .forEach(person -> log.info("\t" + person.toString()));

        Transaction tx = graphDatabase.beginTx();
        try {
            personRepository.save(greg);
            personRepository.save(roy);
            personRepository.save(craig);

            greg = personRepository.findByName(greg.getName());
            greg.worksWith(roy);
            greg.worksWith(craig);
            personRepository.save(greg);

            roy = personRepository.findByName(roy.getName());
            roy.worksWith(craig);
            // We already know that roy works with greg
            personRepository.save(roy);

            // We already know craig works with roy and greg


            log.info("Lookup each person by name...");
            team.stream()
                    .forEach(person ->
                            log.info("\t" + personRepository
                                    .findByName(person.getName()).toString()));


            log.info("Lookup each person by teammate...");
            for (Person person : team) {
                log.info(person.getName() + " is a teammate of...");
                personRepository.findByTeammatesName(person.getName()).stream()
                        .forEach(teammate -> log.info("\t" + teammate.getName()));
            }

            tx.success();
        } finally {
            tx.close();
        }

    }

}
