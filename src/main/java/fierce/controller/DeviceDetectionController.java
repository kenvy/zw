package fierce.controller;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zw on 2016/5/18
 * Email: yaoyaolingma@126.com
 */
@Controller
public class DeviceDetectionController {

    @RequestMapping("/detect-device")
    public
    @ResponseBody
    String detectDevice(Device device) {
        String deviceType = "unknown";
        if (device.isNormal()) {
            deviceType = "normal";
        } else if (device.isMobile()) {
            deviceType = "mobile";
        } else if (device.isTablet()) {
            deviceType = "tablet";
        }
        return "Hello " + deviceType + " browser!";
    }

}
