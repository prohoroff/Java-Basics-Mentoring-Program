import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.String.format;

/**
 * Created by Artsiom Prokharau 31.05.2021
 */

public class Generate {
    public static void main(String[] args) {

        sortedFile(createFile());
    }

    private static void sortedFile(File file) {
        System.out.println("Sorted file ...");
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            Collections.sort(list);
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file.getAbsolutePath()))) {
                for (String s : list) {
                    writer.write(format("%s%n", s));
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File createFile() {
        File file = new File("resources/random_java.txt");
        Random random = new Random();
        System.out.println("Created file ...");
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file.getAbsolutePath()))) {
            for (int i = 0; i < 5000000 ; i++) {
                writer.write(format("%d%n", random.nextInt(100000)));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return file;
    }
}
