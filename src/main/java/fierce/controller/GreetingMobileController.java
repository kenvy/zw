package fierce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zw on 2016/5/12
 * Email: yaoyaolingma@126.com
 */
@Controller
@RequestMapping(value = "/mobile")
public class GreetingMobileController {

    @RequestMapping("/greeting")
    public String greeting() {
        return "greeting";
    }
}
