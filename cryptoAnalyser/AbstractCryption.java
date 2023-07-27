import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;

abstract class AbstractCryption {
    int shift = 0;
    String fileAddress;
    String newFileAddress;
    InputStreamReader inputStreamReader;

    AbstractCryption(String fileAddress, InputStreamReader inputStreamReader) {
        this.fileAddress = fileAddress;
        this.inputStreamReader = inputStreamReader;
        setNewFileName();
    }

    private void setNewFileName() {
        newFileAddress = "processed_" + Path.of(fileAddress).getFileName();
    }

    void crypt() {
        int symbol;
        try (FileOutputStream output = new FileOutputStream(Path.of(fileAddress).resolveSibling(newFileAddress).toFile())) {
            while ((symbol = inputStreamReader.read()) !=-1){
                output.write((char) (symbol + shift));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}