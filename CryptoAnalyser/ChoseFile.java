import java.nio.file.Files;
import java.nio.file.Path;

interface ChoseFile {
    static String choseFile() {
        String path = Ui.path();
        try {
            while (!Files.isRegularFile(Path.of(path))) {
                Ui.wrongEnter();
                path = Ui.path();
            }
        } catch (Exception e) {
            Ui.wrongEnter();
        }
        return path;
    }
}
