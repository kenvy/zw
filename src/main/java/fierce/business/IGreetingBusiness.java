package fierce.business;

import fierce.entity.Customer;

import java.util.List;

/**
 * Created by zw on 2016/4/21
 * Email: yaoyaolingma@126.com
 */
public interface IGreetingBusiness {
    List<Customer> accessMysqlWithJdbc();
}
