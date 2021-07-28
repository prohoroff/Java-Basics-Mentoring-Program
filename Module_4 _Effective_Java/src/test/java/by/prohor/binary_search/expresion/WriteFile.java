package by.prohor.binary_search.expresion;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.lang.String.format;

/**
 * Created by Artsiom Prokharau 19.06.2021
 */

public class WriteFile implements BeforeAllCallback, AfterAllCallback{

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        String name = extensionContext.getRequiredTestClass().getName();
        String replace = name.replace("by.prohor.binary_search.", "");

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("/home/prohor/IdeaProjects/Java Basics Mentoring/README.md"), StandardCharsets.UTF_8,
                StandardOpenOption.APPEND);) {
            writer.write(format("\n# Start Test Class\t=>\t%s\n ``` \n", replace));
        }
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("/home/prohor/IdeaProjects/Java Basics Mentoring/README.md"), StandardCharsets.UTF_8,
                StandardOpenOption.APPEND);) {
            writer.write("```");
        }
    }
}

