import java.util.Scanner;

// Team task: Salem Abdalla - console input handling and input parsing.

public class InputHandler {

    private final Scanner input = new Scanner(System.in);

    String readText(String textMessage) {
        String value;

        do {
            System.out.print(textMessage);
            value = input.nextLine().trim();

            if (value.isEmpty()) {
                System.out.println("Please enter a value.");
            }
        } while (value.isEmpty());

        return value;
    }

    int readInt(String numberMessage) {
        while (true) {
            try {
                System.out.print(numberMessage);
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    double readDouble(String decimalMessage) {
        while (true) {
            try {
                System.out.print(decimalMessage);
                return Double.parseDouble(input.nextLine().trim());
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    int readPositiveInt(String numberMessage) {
        while (true) {
            int value = readInt(numberMessage);

            if (value > 0) {
                return value;
            }

            System.out.println("Please enter a number greater than zero.");
        }
    }

    double readPositiveDouble(String decimalMessage) {
        while (true) {
            double value = readDouble(decimalMessage);

            if (value > 0) {
                return value;
            }

            System.out.println("Please enter a number greater than zero.");
        }
    }
}