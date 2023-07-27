import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

class Ui implements EncrypterCall {
    private static Ui instance; //single UI instance
    private Scanner scanner;    //single scanner for whole UI instance
    private int shiftCesar;
    private String fileAddress;
    private FileInputStream fileInputStream;
    private InputStreamReader inputStreamReader;

    public static Ui getInstance() {
        if (instance == null) {
            instance = new Ui();
        }
        return instance;
    }

    public void callMainMenu() {
        int input;
        scanner = new Scanner(System.in);
        do {
            System.out.println("Chose what you want (digital input required):");
            System.out.println("0 - " + CryptionMethod.CESAR_ENCRYPTION_METHOD.getDisplayMethodName());
            System.out.println("1 - Decrypt");
            System.out.println("2 - For exit");
            while (!scanner.hasNextInt()) {
                wrongEnter();
                scanner.next();
            }
            input = scanner.nextInt();
            if (input < 0 || input > 2) {
                wrongEnter();
            }
        } while (input < 0 || input > 2);
        if (input == 0) {
            setShiftCesar();
            setConnection();
            cesar();
        } else if (input == 1) {
            choseDecryptionMethod();
        } else if (input == 2) {
            System.exit(0);
        }
    }

    private void choseDecryptionMethod() {
        int input;
        do {
            System.out.println("Chose decryption method (digital input required):");
            System.out.println("1 - by " + CryptionMethod.CESAR_DECRYPTION_METHOD.getDisplayMethodName());
            System.out.println("2 - by " + CryptionMethod.BRUTE_FORCE_DECRYPTION_METHOD.getDisplayMethodName());
            System.out.println("3 - ror exit");
            while (!scanner.hasNextInt()) {
                wrongEnter();
                scanner.next();
            }
            input = scanner.nextInt();
            if (input < 1 || input > 3) {
                wrongEnter();
            }
        } while (input < 1 || input > 3);
        if (input == CryptionMethod.CESAR_DECRYPTION_METHOD.getId()) {
            setShiftCesar();
            shiftCesar = shiftCesar * (-1);
            setConnection();
            cesar();
        } else if (input == CryptionMethod.BRUTE_FORCE_DECRYPTION_METHOD.getId()) {
            setConnection();
            bruteForce();
        } else if (input == 3) {
            System.exit(0);
        }
    }

    private void setConnection() {
        setFileAddress();
        setInputStreamReader();
    }

    private void setFileAddress() {
        System.out.println("Enter file address, please");
        scanner.nextLine();
        boolean fileInputStreamOpen = false;
        while (!fileInputStreamOpen) {
            fileAddress = scanner.nextLine();
            try {
                fileInputStream = new FileInputStream(fileAddress);
                fileInputStreamOpen = true;
            } catch (Exception e) {
                Ui.getInstance().wrongEnter();
                System.out.println("Choose another file");
            }
        }
    }

    private void setInputStreamReader() {
        try {
            inputStreamReader = new InputStreamReader(fileInputStream);
        } catch (Exception e) {
            setFileAddress();
        }
    }

    private void setShiftCesar() {
        System.out.println("Enter shift, please");
        while (!scanner.hasNextInt()) {
            wrongEnter();
            scanner.next();
        }
        shiftCesar = scanner.nextInt();
    }

    public void wrongEnter() {
        System.out.println("Entered incorrect data, try again, please");
    }

    public void cryptSuccessfulMessage() {
        System.out.println("Encryption/Decryption process has been finished.");
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public int getShiftCesar() {
        return shiftCesar;
    }

    public InputStreamReader getInputStreamReader() {
        return inputStreamReader;
    }
}