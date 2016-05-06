package fierce.service;

import fierce.entity.User;

import java.util.concurrent.Future;

/**
 * Created by zw on 2016/5/6
 * Email: yaoyaolingma@126.com
 */
public interface IGitHubLookupService {

    Future<User> findUser(String user) throws InterruptedException;
}
