package fierce.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by zw on 2016/5/20
 * Email: yaoyaolingma@126.com
 */
@Configuration
@ImportResource(locations = {"/blog/integration.xml"})
public class IntegrationConfiguration {

    {
        System.out.println("load integration configuration..");
    }
}
