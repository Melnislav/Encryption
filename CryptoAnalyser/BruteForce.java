import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;

class BruteForce extends Encryption {
    protected static void encryption() {
        boolean fileNotFound = true;
        while (fileNotFound) {
            String fileAddress = ChoseFile.choseFile();
            String fileName = "processed_" + Path.of(fileAddress).getFileName();
            int symbol;
            boolean pattern = false;
            int shift = 1;
            try (FileInputStream input = new FileInputStream(fileAddress);
                 InputStreamReader reader = new InputStreamReader(input);
                 FileOutputStream output = new FileOutputStream(Path.of(fileAddress).resolveSibling(fileName).toFile())) {
                while ((symbol = reader.read()) != -1) {
                    System.out.print((char) (symbol + shift));
                    output.write((char) (symbol + shift));
                }
                fileNotFound = false;
            } catch (Exception e) {
                Ui.wrongEnter();
                System.out.println("Choose another file");
            }
        }
        Ui.beginning();
    }
}