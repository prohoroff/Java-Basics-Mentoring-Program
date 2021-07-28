package by.prohor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Created by Artsiom Prokharau 26.07.2021
 */


@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
public class Task3Application {
    public static void main(String[] args) {
        SpringApplication.run(Task3Application.class, args);
    }
}
