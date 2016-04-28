package fierce.entity;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zw on 2016/4/28
 * Email: yaoyaolingma@126.com
 */
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
