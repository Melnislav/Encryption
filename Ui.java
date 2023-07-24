import java.util.Scanner;

public class Ui {
    public static void beginning() {
        System.out.println("Chose what you want:");
        System.out.println("1 - Cesar method");
        System.out.println("2 - Brute force method");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("1")) {
            Cesar.cesar();
        } else if (scanner.nextLine().equals("2")) {
            BruteForce.brutForce();
        } else {
            System.out.println("Wrong command");
            beginning();
        }
    }

    public static String path() {
        System.out.println("Enter file address, please");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void wrongEnter() {
        System.out.println("Entered incorrect address");
    }

    public static int getShift() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter shift, please");
        while (!scanner.hasNextInt()) System.out.println("Enter shift, please");
        return scanner.nextInt();
    }
}