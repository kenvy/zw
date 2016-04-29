package fierce.controller;

import fierce.business.IGreetingBusiness;
import fierce.entity.Customer;
import fierce.entity.Greeting;
import fierce.entity.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by zw on 2016/4/21
 * Email: yaoyaolingma@126.com
 */
@RestController
public class GreetingController {

    @Autowired
    IGreetingBusiness greetingBusiness;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private static final Logger log = LoggerFactory.getLogger("GreetingController");

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/consuming-msg")
    public Quote consumingMsg() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
    }

    @RequestMapping("/accessMysqlWithJdbc")
    public List<Customer> accessMysqlWithJdbc() {
        return greetingBusiness.accessMysqlWithJdbc();
    }

    @RequestMapping("/testRabbitmq")
    public String testRabbitmq() {
        greetingBusiness.testRabbitmq();
        return "ok!";
    }

    @RequestMapping("/testNeo4j")
    public String testNeo4j_NoSql_db() {
        greetingBusiness.testNeo4j_NoSql_db();
        return "ok!";
    }
}
