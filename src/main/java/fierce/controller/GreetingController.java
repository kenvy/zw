package fierce.controller;

import fierce.business.IGreetingBusiness;
import fierce.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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

    @RequestMapping("/testHypermedia")
    public ResponseEntity<GreetingHypermedia> greetingHypermedia(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {

        GreetingHypermedia greetingHypermedia = new GreetingHypermedia(String.format(template, name));
        greetingHypermedia.add(linkTo(methodOn(GreetingController.class).greetingHypermedia(name)).withSelfRel());

        return new ResponseEntity<>(greetingHypermedia, HttpStatus.OK);
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

    @RequestMapping("/testJms")
    public String testJms() {
        greetingBusiness.testJms();
        return "ok!";
    }

    @RequestMapping("testGemfire")
    public QuoteGemfire testGemfire(@RequestParam(value = "id", required = true, defaultValue = "1") Long id) {
        return greetingBusiness.testGemfire(id);
    }
}
