import java.util.Scanner;

class Ui {
    protected static String method;

    protected static void beginning() {
        System.out.println("Chose what you want:");
        System.out.println("1 - Encrypt");
        System.out.println("2 - Decrypt");
        System.out.println("3 - For exit");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.equals("1")) {
                method = "Cesar";
                Encryption.encryption();
            }
            if (input.equals("2")) {
                choseMethod();
            }
            if (input.equals("3")) {
                System.exit(0);
            } else {
                wrongEnter();
            }
        }
    }

    protected static void choseMethod() {
        System.out.println("Chose decryption method:");
        System.out.println("1 - Cesar");
        System.out.println("2 - Brute Force");
        System.out.println("3 - For exit");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.equals("1")) {
                method = "Cesar";
                Encryption.encryption();
            }
            if (input.equals("2")) {
                method = "Brute";
                BruteForce.encryption();
            }
            if (input.equals("3")) {
                System.exit(0);
            } else {
                wrongEnter();
            }
        }
    }

    protected static String path() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file address, please");
        return scanner.nextLine();
    }

    protected static void wrongEnter() {
        System.out.println("Entered incorrect data, try again");
    }

    protected static int getShift() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter shift, please");
        while (!scanner.hasNextInt()) {
            wrongEnter();
            scanner.next();
        }
        return scanner.nextInt();
    }
}