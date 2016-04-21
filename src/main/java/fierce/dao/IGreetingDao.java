package fierce.dao;

import fierce.entity.Customer;

import java.util.List;

/**
 * Created by zw on 2016/4/21
 * Email: yaoyaolingma@126.com
 */
public interface IGreetingDao {

    void initTable();

    void updateWithBatch();

    List<Customer> selectCustomersByName();
}
