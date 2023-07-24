import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Cesar {
    public static void cesar() {
        String fileAddress = choseFile();
        try (FileInputStream input = new FileInputStream(fileAddress);
             InputStreamReader reader = new InputStreamReader(input, StandardCharsets.UTF_8);
             FileOutputStream output = new FileOutputStream(fileAddress.resolveSibling())) {
            int symbol;
            int shift = Ui.getShift();
            while ((symbol = reader.read()) != -1) {
                System.out.print((char) (symbol+shift));
            }

        } catch (IOException e) {
            System.out.println("Something wrong with file, try to choose another one");
            cesar();
        }
    }

    private static String choseFile() {
        String path = Ui.path();
        while (!Files.isRegularFile(Path.of(path))) {
            Ui.wrongEnter();
            path = Ui.path();
        }
        return path;
    }
}