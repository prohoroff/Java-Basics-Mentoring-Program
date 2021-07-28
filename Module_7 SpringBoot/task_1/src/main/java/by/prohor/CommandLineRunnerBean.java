package by.prohor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Artsiom Prokharau 26.07.2021
 */

@Component
public class CommandLineRunnerBean implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World");
    }
}
