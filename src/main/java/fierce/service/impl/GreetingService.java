package fierce.service.impl;

import fierce.dao.CustomerMongodbRepository;
import fierce.dao.IGreetingDao;
import fierce.dao.PersonRepository;
import fierce.entity.Customer;
import fierce.entity.CustomerMongodb;
import fierce.entity.Person;
import fierce.service.IGreetingService;
import org.neo4j.graphdb.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

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

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    CustomerMongodbRepository customerMongodbRepository;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    CountDownLatch countDownLatch;

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

    @Override
    public void testJms() {
        // Clean out any ActiveMQ data from a previous run
        FileSystemUtils.deleteRecursively(new File("activemq-data"));
        // Send a message
        MessageCreator messageCreator = session -> session.createTextMessage("ping!");
        System.out.println("Sending a new message.");
        jmsTemplate.send("mailbox-destination", messageCreator);
    }

    @Override
    public void testMongodb() {
        customerMongodbRepository.deleteAll();

        // save a couple of customers
        customerMongodbRepository.save(new CustomerMongodb("Alice", "Smith"));
        customerMongodbRepository.save(new CustomerMongodb("Bob", "Smith"));

        // fetch all customers
        System.out.println("Customers found with findAll() order by firstName desc:");
        System.out.println("-------------------------------");
        customerMongodbRepository.findAll(new Sort(Sort.Direction.DESC, "firstName")).forEach(System.out::println);
        System.out.println();

        // fetch an individual customer
        System.out.println("CustomerMongodb found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(customerMongodbRepository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        customerMongodbRepository.findByLastName("Smith").forEach(System.out::println);
    }

    @Override
    public void testRedisMsg() {
        log.info("Sending message...");

        stringRedisTemplate.convertAndSend("chat", "Hello from Redis!");

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
