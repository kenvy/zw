package fierce.conf;

import fierce.dao.impl.WeatherClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * Created by Fierce on 2016/5/7
 * Email: yaoyaolingma@126.com
 */
@Configuration
public class WeatherServiceConfiguration {

    @Bean
    public static Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("fierce.wsdl");
        return marshaller;
    }

    @Bean
    public static WeatherClient weatherClient(Jaxb2Marshaller marshaller) {
        WeatherClient client = new WeatherClient();
        client.setDefaultUri("http://ws.cdyne.com/WeatherWS");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
