// Team task: AFFAN UMER - overall program flow, menu handling, and feature coordination.
public class MainSystem {

    private static final String REGISTRATION_REQUIRED = "Please register first.";

    private final InputHandler inputHandler = new InputHandler();
    private final User user = new User();
    private final WaterIntakeManager waterIntakeManager = new WaterIntakeManager();

    public static void main(String[] args) {
        new MainSystem().startMenu();
    }

    void startMenu() {
        int choice;

        do {
            printMenu();

            choice = inputHandler.readInt("Enter Choice: ");

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    showWaterGoal();
                    break;
                case 3:
                    addWaterIntake();
                    break;
                case 4:
                    showHistory();
                    break;
                case 5:
                    checkHydration();
                    break;
                case 6:
                    showSummary();
                    break;
                case 7:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 7);
    }

    private void printMenu() {
        System.out.println("""

                ===== Daily Water Intake System =====
                1. Register User
                2. View Water Goal
                3. Add Water Intake
                4. View Water History
                5. Check Hydration Status
                6. View Daily Summary
                7. Exit
                """);
    }

    private boolean requireRegistration() {
        if (!user.isRegistered()) {
            System.out.println(REGISTRATION_REQUIRED);
            return false;
        }

        return true;
    }

    void registerUser() {
        System.out.println("\n===== Register User =====");

        user.setName(inputHandler.readText("Enter Name: "));
        user.setAge(inputHandler.readPositiveInt("Enter Age: "));
        user.setGender(inputHandler.readText("Enter Gender: "));
        user.setWeight(inputHandler.readPositiveDouble("Enter Weight (kg): "));
        user.setDailyWaterGoal(GoalCalculator.calculateDailyGoal(user.getWeight()));

        waterIntakeManager.clearHistory();

        System.out.println("User Registered Successfully!");
    }

    void showWaterGoal() {
        if (!requireRegistration()) {
            return;
        }

        System.out.printf("Recommended Water Intake: %.0f ml%n", user.getDailyWaterGoal());
    }

    void addWaterIntake() {
        if (!requireRegistration()) {
            return;
        }

        double amount = inputHandler.readPositiveDouble("Enter Water Intake (ml): ");
        waterIntakeManager.addWaterIntake(amount);

        System.out.println("Water Intake Added Successfully!");
    }

    void showHistory() {
        if (!requireRegistration()) {
            return;
        }

        if (waterIntakeManager.isEmpty()) {
            System.out.println("No Records Found.");
            return;
        }

        System.out.println("\n===== Water Intake History =====");
        System.out.print(waterIntakeManager.buildHistoryReport());
    }

    void checkHydration() {
        if (!requireRegistration()) {
            return;
        }

        double total = waterIntakeManager.calculateTotalWater();
        System.out.println("Status: " + HydrationEvaluator.evaluate(total, user.getDailyWaterGoal()));
    }

    void showSummary() {
        if (!requireRegistration()) {
            return;
        }

        SummaryDisplay.show(user, waterIntakeManager);
    }
}