import java.util.Scanner;

// Team task: Salem Abdalla - console input handling and input parsing.

public class InputHandler {

    private final Scanner input = new Scanner(System.in);

    String readText(String textMessage) {
        System.out.print(textMessage);
        return input.nextLine();
    }

    int readInt(String numberMessage) {
        System.out.print(numberMessage);
        return Integer.parseInt(input.nextLine());
    }

    double readDouble(String decimalMessage) {
        System.out.print(decimalMessage);
        return Double.parseDouble(input.nextLine());
    }
}