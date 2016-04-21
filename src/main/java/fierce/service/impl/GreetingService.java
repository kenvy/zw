package fierce.service.impl;

import fierce.dao.IGreetingDao;
import fierce.entity.Customer;
import fierce.service.IGreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Currency;
import java.util.List;

/**
 * Created by zw on 2016/4/21
 * Email: yaoyaolingma@126.com
 */
@Service
public class GreetingService implements IGreetingService {

    @Autowired
    IGreetingDao greetingDao;

    private static final Logger log = LoggerFactory.getLogger("GreetingService");

    @Override
    public List<Customer> accessMysqlWithJdbc() {
        log.info("Creating tables");
        //greetingDao.initTable();

        //greetingDao.updateWithBatch();

        log.info("Querying for customer records where first_name = 'Josh':");
        return greetingDao.selectCustomersByName();
    }

}
