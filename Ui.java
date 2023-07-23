import java.util.Scanner;

public class Ui {
    public static void beginning() {
        System.out.println("Chose what you want:");
        System.out.println("1 - Encrypt file by Cesar method");
        System.out.println("2 - Decrypt file by Cesar method");
        System.out.println("3 - Decrypt file by brute force method");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("1")) {
            Encrypter.cesar();
        } else if (scanner.nextLine().equals("2")) {
            Decrypter.cesarDecrypter();
        } else if (scanner.nextLine().equals("3")) {
            BruteForce.brutForce();
        } else {
            System.out.println("Wrong command");
            beginning();
        }
    }

    public static void path() {
        System.out.println("Enter file address, please");
    }

    public static void wrongPath() {
        System.out.println("Entered incorrect address");
        path();
    }
}