package fierce.service;

import fierce.entity.Customer;

import java.util.List;

/**
 * Created by zw on 2016/4/21
 * Email: yaoyaolingma@126.com
 */
public interface IGreetingService {

    List<Customer> accessMysqlWithJdbc();

    void testRabbitmq();

    void testNeo4j_NoSql_db();

    void testJms();

    void testMongodb();

    void testRedisMsg();

    void testGemfireCrud();
}
