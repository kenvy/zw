package fierce;

import org.neo4j.io.fs.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

/**
 * Created by zw on 2016/4/21
 * Email: yaoyaolingma@126.com
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        //Demo for nero4j.[start]
        try {
            FileUtils.deleteRecursively(new File("target/hello.db"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Demo for nero4j.[end]

        SpringApplication.run(Application.class, args);
    }
}
