package by.prohor.binary_search.sort;

import by.prohor.binary_search.expresion.WriteFile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

import static java.lang.String.format;

@ExtendWith(WriteFile.class)
class SortedMergeTest {

    BufferedWriter writer;
    SortedMerge sortedMerge = new SortedMerge();
    Random random = new Random();

    @BeforeEach
    void writeClass() throws IOException {
        writer = Files.newBufferedWriter(Paths.get("/home/prohor/IdeaProjects/Java Basics Mentoring/README.md"), StandardCharsets.UTF_8,
                StandardOpenOption.APPEND);
    }

    @ParameterizedTest()
    @ValueSource(ints = {1_000,10_000,100_000})
    void testMergeSort_whenArrayContainsElements(int size) throws IOException {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        Instant start = Instant.now();
        // выполнение какой-то логики
        sortedMerge.sort(arr);
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();

        writer.write(format("Test => MergeSort_whenArrayContains(%d) => time spent searching (ms) _%d_\n", size, elapsed));
    }

    @AfterEach
    void cleanUp() throws IOException {
        writer.close();
    }
}