
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
 *         &lt;element name="GetWeatherInformationResult" type="{http://ws.cdyne.com/WeatherWS/}ArrayOfWeatherDescription" minOccurs="0"/>
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
    "getWeatherInformationResult"
})
@XmlRootElement(name = "GetWeatherInformationResponse")
public class GetWeatherInformationResponse {

    @XmlElement(name = "GetWeatherInformationResult")
    protected ArrayOfWeatherDescription getWeatherInformationResult;

    /**
     * 获取getWeatherInformationResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWeatherDescription }
     *     
     */
    public ArrayOfWeatherDescription getGetWeatherInformationResult() {
        return getWeatherInformationResult;
    }

    /**
     * 设置getWeatherInformationResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWeatherDescription }
     *     
     */
    public void setGetWeatherInformationResult(ArrayOfWeatherDescription value) {
        this.getWeatherInformationResult = value;
    }

}
