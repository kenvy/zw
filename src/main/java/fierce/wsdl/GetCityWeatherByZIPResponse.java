
package fierce.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetCityWeatherByZIPResult" type="{http://ws.cdyne.com/WeatherWS/}WeatherReturn"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getCityWeatherByZIPResult"
})
@XmlRootElement(name = "GetCityWeatherByZIPResponse")
public class GetCityWeatherByZIPResponse {

    @XmlElement(name = "GetCityWeatherByZIPResult", required = true)
    protected WeatherReturn getCityWeatherByZIPResult;

    /**
     * 获取getCityWeatherByZIPResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link WeatherReturn }
     *     
     */
    public WeatherReturn getGetCityWeatherByZIPResult() {
        return getCityWeatherByZIPResult;
    }

    /**
     * 设置getCityWeatherByZIPResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link WeatherReturn }
     *     
     */
    public void setGetCityWeatherByZIPResult(WeatherReturn value) {
        this.getCityWeatherByZIPResult = value;
    }

}
