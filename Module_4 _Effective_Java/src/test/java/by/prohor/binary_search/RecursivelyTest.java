package by.prohor.binary_search;

import by.prohor.binary_search.expresion.WriteFile;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.Stream;

import static java.lang.String.format;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(WriteFile.class)
class RecursivelyTest {

    BufferedWriter writer;
    Recursively recursively = new Recursively();

    @BeforeEach
    void writeClass() throws IOException {
        writer = Files.newBufferedWriter(Paths.get("/home/prohor/IdeaProjects/Java Basics Mentoring/README.md"), StandardCharsets.UTF_8,
                StandardOpenOption.APPEND);
    }

    @ParameterizedTest
    @MethodSource("testKey")
    @DisplayName("whenArraySortedAndContainsTenElements")
    @Order(1)
    void runBinarySearchIteratively_whenArraySortedAndContainsTenElements(int key) throws IOException {
        int[] tenElementsSorted = new int[]{3, 4, 6, 8, 12, 23, 43, 111, 132, 656};
        Instant start = Instant.now();
        // выполнение какой-то логики
        int index = recursively.search(tenElementsSorted, key, 0, tenElementsSorted.length - 1);
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toNanos();

        writer.write(format("Test => whenArraySortedAndContainsTenElements => Found item (%d) and his index = %d => time spent searching (nano s) _%d_\n", key, index, elapsed));
    }

    @ParameterizedTest
    @MethodSource("testKey")
    @DisplayName("whenArraySortedAndContainsTwentyElements")
    @Order(2)
    void runBinarySearchIteratively_whenArraySortedAndContainsTwentyElements(int key) throws IOException {
        int[] twentyElementsSorted = new int[]{1, 2, 3, 4, 6, 8, 9, 12, 13, 21, 23, 41, 43, 65, 78, 89, 98, 111, 132, 656};

        Instant start = Instant.now();
        // выполнение какой-то логики
        int index = recursively.search(twentyElementsSorted, key, 0, twentyElementsSorted.length - 1);
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toNanos();

        writer.write(format("Test => whenArraySortedAndContainsTwentyElements => Found item (%d) and his index = %d => time spent searching (nano s) _%d_\n", key, index, elapsed));
    }

    @AfterEach
    void cleanUp() throws IOException {
        writer.close();
    }


    private static Stream<Arguments> testKey() {
        return Stream.of(
                Arguments.of(132));
    }
}
