
package fierce.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡgetWeatherInformationResult���Ե�ֵ��
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
     * ����getWeatherInformationResult���Ե�ֵ��
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
