package by.prohor.app;

import by.prohor.app.config.ConfigJMS;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Created by Artsiom Prokharau 05.08.2021
 */

@SpringBootApplication
@Import(ConfigJMS.class)
public class Application_1 {
    public static void main(String[] args) {
        SpringApplication.run(Application_1.class, args);
    }
}
