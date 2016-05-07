package fierce.service.impl;

import fierce.conf.WeatherServiceConfiguration;
import fierce.dao.impl.WeatherClient;
import fierce.service.IWeatherService;
import fierce.wsdl.GetCityForecastByZIPResponse;
import org.springframework.stereotype.Service;

/**
 * Created by Fierce on 2016/5/7
 * Email: yaoyaolingma@126.com
 */
@Service
public class WeatherService implements IWeatherService {

    @Override
    public void testWs() {
        WeatherClient client = WeatherServiceConfiguration.weatherClient(WeatherServiceConfiguration.marshaller());
        GetCityForecastByZIPResponse response = client.getCityForecastByZip("94304");
        client.printResponse(response);
    }
}
