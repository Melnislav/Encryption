import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

class Encryption {
    protected static void encryption() {
        boolean fileNotFound = true;
        while (fileNotFound) {
            String fileAddress = choseFile();
            String fileName = "processed_" + Path.of(fileAddress).getFileName();
            int symbol;
            int shift = Ui.getShift();
            if (Ui.method.equals("Cesar")) shift = shift * (-1); //means decryption by Cesar was chosen
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

    protected static String choseFile() {
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