import java.util.Scanner;

public class Ui {
    public static void beginning() {
        System.out.println("Chose what you want:");
        System.out.println("1 - Cesar method");
        System.out.println("2 - Brute force method");
        System.out.println("3 - For exit");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (scanner.hasNext()) {
            if (input.equals("1")) {
                Encryption.cesar();
            }
            if (input.equals("2")) {
                Encryption.cesar();
            }
            if (input.equals("3")) {
                System.exit(0);
            } else {
                wrongEnter();
                input = scanner.next();
            }
        }
    }

    public static String path() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file address, please");
        return scanner.nextLine();
    }

    public static void wrongEnter() {
        System.out.println("Entered incorrect data, try again");
    }

    public static int getShift() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter shift, please");
        while (!scanner.hasNextInt()) {
            wrongEnter();
            scanner.next();
        }
        return scanner.nextInt();
    }
}