package fierce.business.impl;

import fierce.business.IGreetingBusiness;
import fierce.entity.Customer;
import fierce.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zw on 2016/4/21
 * Email: yaoyaolingma@126.com
 */
@Service
public class GreetingBusiness implements IGreetingBusiness {

    @Autowired
    IGreetingService greetingService;

    public List<Customer> accessMysqlWithJdbc() {
        return greetingService.accessMysqlWithJdbc();
    }
}
