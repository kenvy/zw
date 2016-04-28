package fierce.business.impl;

import fierce.business.IGreetingBusiness;
import fierce.conf.RabbitmqConfiguration;
import fierce.entity.Customer;
import fierce.service.IGreetingService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    RabbitTemplate rabbitTemplate;
    /**
     * Simple Rabbitmq
     */
    @Override
    public void testRabbitmq() {
        System.out.println("Waiting five seconds...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(RabbitmqConfiguration.queueName, "Hello from RabbitMQ!");
        try {
            RabbitmqConfiguration.receiver().getLatch().await(10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
