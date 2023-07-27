import java.io.InputStreamReader;

class BruteForce extends AbstractCryption {
    private final int MIN_SYMBOL_CODE = -10;
    private final int MAX_SYMBOL_CODE = 10;
    private final String SOME_PATTERN = "KPI";


    // Is it possible to use default constructor maybe, because no difference?
    public BruteForce(String fileAddress, InputStreamReader inputStreamReader) {
        super(fileAddress, inputStreamReader);
    }

    @Override
    void crypt() {
        for (int i = MIN_SYMBOL_CODE; i < MAX_SYMBOL_CODE; i++) {
            super.crypt();
            if (
                    SOME_PATTERN.equals(SOME_PATTERN) //REWRITE!!!!!!!!!!!!!!!!!!!!!!!!
            ) break;
            else ++shift;
        }
    }
}