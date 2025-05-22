
import java.util.Scanner;

public class InputHelper {
    private static Scanner scanner = new Scanner(System.in);


    //Accepts only valid integers
    public static int readInt (String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input! Please Enter a Valid Number(NO SYMBOLS, NO LETTERS, MUST NOT BE EMPTY): ");
            }
        }
    }

    // For patron names - only alphabetic characters allowed
    public static String readName (String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty!");
            } else if (!input.matches("[a-zA-Z ]+")) {
                System.out.println("Invalid Input! Numbers & Symbols are not allowed.");
            } else {
                return input;
            }
        }
    }


    // Modified to allow alphanumeric input and basic punctuation for book titles
    public static String readString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty!");
            } else {
                return input; // Accept any non-empty string
            }
        }
    }

    //accepts numeric for menu choices only within a specific
    public static int readMenuChoice (int min, int max) {
        while (true) {
            System.out.print("Choose a number: ");
            String input = scanner.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (choice >=min && choice <= max) {
                    return choice;
                } else {
                    System.out.println("Invalid Choice! Please enter number between " + min + " and " + max+ ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please Enter a number between 1 - 8.");
            }
        }
    }


    //accepts 13digits for ISBN
    public static String readISBN(String prompt) {
        while(true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim();
            if (!input.matches("\\d{13}")) {
                System.out.println("Invalid ISBN! It must be exactly 13 digits.(MUST NOT BE EMPTY, NO LETTERS & NO SYMBOLS)");
            } else {
                return input;
            }
        }
    }
}
