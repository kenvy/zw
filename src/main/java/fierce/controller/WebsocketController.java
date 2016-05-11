package fierce.controller;

import fierce.entity.Greeting;
import fierce.entity.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by zw on 2016/5/11
 * Email: yaoyaolingma@126.com
 */
@Controller
public class WebsocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        if (null == message) message = new HelloMessage("zhangwei_back");
            Thread.sleep(3000); // simulated delay
        return new Greeting(3, "Hello, " + message.getName() + "!");
    }
}
