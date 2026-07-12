import java.util.Scanner;

// Team task division:
// Member 3: Isamatov Damir (202409010365) -> Build the menu-driven console interface and coordinate the system flow.
public class DailyWaterIntakeSystem {
    private final Scanner scanner;
    private User user;
    private WaterRecord record;

    public DailyWaterIntakeSystem() {
        this.scanner = new Scanner(System.in);
        this.user = new User();
        this.record = new WaterRecord();
    }

    public void displayMenu() {
        System.out.println("===============================");
        System.out.println("Daily Water Intake Monitoring System");
        System.out.println("===============================");
        System.out.println("1. User Registration");
        System.out.println("2. Calculate Recommended Water Intake");
        System.out.println("3. Add Water Consumption Record");
        System.out.println("4. View Daily Consumption History");
        System.out.println("5. Check Hydration Status");
        System.out.println("6. Display Daily Summary");
        System.out.println("7. Exit");
        System.out.println("===============================");
    }

    public void processMenuChoice(int choice) {
        switch (choice) {
            case 1:
                registerUser();
                break;
            case 2:
                calculateRecommendedWaterIntake();
                break;
            case 3:
                addWaterConsumptionRecord();
                break;
            case 4:
                viewDailyConsumptionHistory();
                break;
            case 5:
                checkHydrationStatus();
                break;
            case 6:
                displayDailySummary();
                break;
            case 7:
                System.out.println("Thank you for using the system.");
                break;
            default:
                System.out.println("Invalid menu choice. Please try again.");
        }
    }

    public void runSystem() {
        int choice;
        do {
            displayMenu();
            choice = readInt("Enter your choice: ", 1, 7);
            if (choice == 7) {
                System.out.println("Exiting system. Goodbye!");
                break;
            }
            processMenuChoice(choice);
            System.out.println();
        } while (choice != 7);
    }

    private void registerUser() {
        System.out.println("\n--- User Registration ---");
        String name = readNonEmptyString("Enter user name: ");
        int age = readInt("Enter user age: ", 1, 120);
        String gender = readNonEmptyString("Enter user gender: ");
        double weight = readPositiveDouble("Enter body weight (kg): ");

        user = new User();
        user.setName(name);
        user.setAge(age);
        user.setGender(gender);
        user.setWeight(weight);
        user.calculateRecommendedWater();
        System.out.println("User registered successfully.");
        user.displayUserInfo();
    }

    private void calculateRecommendedWaterIntake() {
        if (!user.isRegistered()) {
            System.out.println("Please register a user first.");
            return;
        }

        double recommendedWater = user.calculateRecommendedWater();
        System.out.println("Recommended daily water intake: " + recommendedWater + " ml");
    }

    private void addWaterConsumptionRecord() {
        if (!user.isRegistered()) {
            System.out.println("Please register a user first.");
            return;
        }

        double amount = readPositiveDouble("Enter water intake amount (ml): ");
        record.addWaterIntake(amount);
        System.out.println("Water intake record added successfully.");
    }

    private void viewDailyConsumptionHistory() {
        record.displayHistory();
    }

    private void checkHydrationStatus() {
        if (!user.isRegistered()) {
            System.out.println("Please register a user first.");
            return;
        }

        double recommendedWater = user.getRecommendedWater();
        if (recommendedWater <= 0) {
            recommendedWater = user.calculateRecommendedWater();
        }

        double totalConsumed = record.calculateTotalConsumption();
        double remainingWater = record.getRemainingWater(recommendedWater);
        String status = record.checkHydrationStatus(recommendedWater);

        System.out.println("\nHydration Status");
        System.out.println("Total Consumed: " + totalConsumed + " ml");
        System.out.println("Remaining Water Needed: " + remainingWater + " ml");
        System.out.println("Hydration Status: " + status);
    }

    private void displayDailySummary() {
        if (!user.isRegistered()) {
            System.out.println("Please register a user first.");
            return;
        }

        double recommendedWater = user.getRecommendedWater();
        if (recommendedWater <= 0) {
            recommendedWater = user.calculateRecommendedWater();
        }

        double totalConsumed = record.calculateTotalConsumption();
        double remainingWater = record.getRemainingWater(recommendedWater);
        String status = record.checkHydrationStatus(recommendedWater);

        System.out.println("\nDaily Summary");
        System.out.println("Recommended Water Intake: " + recommendedWater + " ml");
        System.out.println("Total Consumed: " + totalConsumed + " ml");
        System.out.println("Remaining Water Needed: " + remainingWater + " ml");
        System.out.println("Hydration Status: " + status);
    }

    private int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Please enter a value between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private double readPositiveDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value > 0) {
                    return value;
                }
                System.out.println("Please enter a value greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("This field cannot be empty.");
        }
    }

    public static void main(String[] args) {
        DailyWaterIntakeSystem system = new DailyWaterIntakeSystem();
        system.runSystem();
    }
}
