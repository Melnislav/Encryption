import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Cesar {
    public static void cesar() {
        try (InputStream input = Files.newInputStream(Path.of(choseFile()))) {
            System.out.println(input.readAllBytes());
        } catch (IOException e) {
            System.out.println("Something wrong with file, try to chose an other one");
            cesar();
        }
    }

    private static String choseFile() {
        String path = Ui.path();
        while (!Files.isRegularFile(Path.of(path))) {
            Ui.wrongPath();
            path = Ui.path();
        }
        return path;
    }
}