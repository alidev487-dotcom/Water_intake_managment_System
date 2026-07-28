// Team task: Salem Abdalla - reads and validates user input from the console.
import java.util.Scanner;

public class InputHandler {
    Scanner input = new Scanner(System.in);

    String readText() {
        String value = input.nextLine();
        while (value.length() == 0) {
            System.out.println("Please enter a value.");
            value = input.nextLine();
        }
        return value;
    }

    int readInt() {
        while (true) {
            try {
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    double readDouble() {
        while (true) {
            try {
                double value = Double.parseDouble(input.nextLine().trim());
                if (value <= 0) {
                    System.out.println("Please enter a number greater than zero.");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
