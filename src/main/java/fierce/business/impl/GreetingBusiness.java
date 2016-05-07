package fierce.business.impl;

import fierce.business.IGreetingBusiness;
import fierce.entity.Customer;
import fierce.entity.QuoteGemfire;
import fierce.entity.User;
import fierce.service.IGitHubLookupService;
import fierce.service.IGreetingService;
import fierce.service.IQuoteService;
import fierce.service.IWeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by zw on 2016/4/21
 * Email: yaoyaolingma@126.com
 */
@Service
public class GreetingBusiness implements IGreetingBusiness {

    private final static Logger log = LoggerFactory.getLogger(GreetingBusiness.class);

    @Autowired
    IGreetingService greetingService;

    @Autowired
    IQuoteService quoteService;

    @Autowired
    IGitHubLookupService gitHubLookupService;

    @Autowired
    IWeatherService weatherService;

    public List<Customer> accessMysqlWithJdbc() {
        return greetingService.accessMysqlWithJdbc();
    }

    /**
     * Simple Rabbitmq
     */
    @Override
    public void testRabbitmq() {
        greetingService.testRabbitmq();
    }

    /**
     * test neo4j [crud]
     */
    @Override
    public void testNeo4j_NoSql_db() {
        greetingService.testNeo4j_NoSql_db();
    }

    /**
     * test jms
     */
    @Override
    public void testJms() {
        greetingService.testJms();
    }

    /**
     * test gemfire
     */
    @Override
    public QuoteGemfire testGemfire(Long id) {
        return quoteService.testGemfire(id);
    }

    /**
     * test mongodb
     */
    @Override
    public void testMongodb() {
        greetingService.testMongodb();
    }

    @Override
    public void testAsy() {
        // Start the clock
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        Future<User> page1;
        try {
            page1 = gitHubLookupService.findUser("PivotalSoftware");
            Future<User> page2 = gitHubLookupService.findUser("CloudFoundry");
            Future<User> page3 = gitHubLookupService.findUser("Spring-Projects");

            // Wait until they are all done
            while (!(page1.isDone() && page2.isDone() && page3.isDone()
            )) {
                Thread.sleep(10); //10-millisecond pause between each check
            }

            // Print results, including elapsed time
            System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
            System.out.println(page1.get());
            System.out.println(page2.get());
            System.out.println(page3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testWs() {
        /*weatherService.testWs();*/
    }
}
