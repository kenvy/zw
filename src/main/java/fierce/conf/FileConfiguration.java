package fierce.conf;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;

/**
 * Created by Fierce on 2016/5/8
 * Email: yaoyaolingma@126.com
 */
@Configuration
public class FileConfiguration {

    public static final String ROOT = "/data/file";

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @PostConstruct
    public void mkDir() {
        File file = new File(ROOT);
        if (!file.exists()) {
            file.mkdir();
        }
    }
}
