package fierce.entity;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

import java.io.File;

/**
 * Created by Fierce on 2016/5/2
 * Email: yaoyaolingma@126.com
 */
@Component
public class JmsReceiver {

    @JmsListener(destination = "mailbox-destination", containerFactory = "myJmsContainerFactory")
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        FileSystemUtils.deleteRecursively(new File("activemq-data"));
    }
}
