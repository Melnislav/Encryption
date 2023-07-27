import java.io.IOException;
import java.io.InputStreamReader;

class Cesar extends AbstractCryption {
    public Cesar(int shift, String fileAddress, InputStreamReader inputStreamReader) {
        super(fileAddress, inputStreamReader);
        this.shift = shift;
    }

    @Override
    void crypt() {
        super.crypt();
        try {
            inputStreamReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}