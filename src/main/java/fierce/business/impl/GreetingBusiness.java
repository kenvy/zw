package fierce.business.impl;

import fierce.business.IGreetingBusiness;
import fierce.entity.Customer;
import fierce.service.IGreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zw on 2016/4/21
 * Email: yaoyaolingma@126.com
 */
@Service
public class GreetingBusiness implements IGreetingBusiness {

    private final static Logger log = LoggerFactory.getLogger(GreetingBusiness.class);

    @Autowired
    IGreetingService greetingService;

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
}
