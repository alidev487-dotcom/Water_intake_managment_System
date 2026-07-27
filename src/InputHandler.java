import java.util.Scanner;

// Team task: Salem Abdalla - console input handling and input parsing.

public class InputHandler {

    private final Scanner input = new Scanner(System.in);

    String readText(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }

    int readInt(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(input.nextLine());
    }

    double readDouble(String prompt) {
        System.out.print(prompt);
        return Double.parseDouble(input.nextLine());
    }
}