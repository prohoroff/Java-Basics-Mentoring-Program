package by.prohor.binary_search.integrationSort;

import by.prohor.binary_search.BinarySearch;
import by.prohor.binary_search.Iteratively;
import by.prohor.binary_search.Recursively;
import by.prohor.binary_search.expresion.WriteFile;
import by.prohor.binary_search.sort.InsertionSort;
import by.prohor.binary_search.sort.Sort;
import by.prohor.binary_search.sort.SortedMerge;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.stream.Stream;

import static java.lang.String.format;

@ExtendWith(WriteFile.class)
class IntegrateTest {

    private BufferedWriter writer;
    BinarySearch binarySearch;
    Random random = new Random();
    Sort sort;

    @BeforeEach
    void writeClass() throws IOException {
        writer = Files.newBufferedWriter(Paths.get("/home/prohor/IdeaProjects/Java Basics Mentoring/README.md"), StandardCharsets.UTF_8,
                StandardOpenOption.APPEND);
    }

    @ParameterizedTest()
    @MethodSource("test")
    @DisplayName("whenDifferenceImplementations")
    void runBinarySearch_whenDifferenceImplementations(Class<Sort> sortImpl, Class<BinarySearch> searchImpl) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        int key = arr[random.nextInt(20_000)];

        this.sort = sortImpl.getDeclaredConstructor().newInstance();
        this.binarySearch = searchImpl.getDeclaredConstructor().newInstance();

        Instant start = Instant.now();
        sort.sort(arr);
        // выполнение какой-то логики
        int index = binarySearch.search(arr, key, 0, arr.length - 1);
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();

        writer.write(format("Test => runBinarySearch_whenDifferenceImplementations => Used sort (%s) and search (%s) index = %d => time spent searching (ms) _%d_\n", sortImpl.getSimpleName(), searchImpl.getSimpleName(),index, elapsed));
    }

    private static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(InsertionSort.class, Iteratively.class),
                Arguments.of(SortedMerge.class, Iteratively.class),
                Arguments.of(InsertionSort.class, Recursively.class),
                Arguments.of(SortedMerge.class, Recursively.class));
    }

    @AfterEach
    void cleanUp() throws IOException {
        writer.close();
    }
}