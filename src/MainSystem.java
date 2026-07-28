public class MainSystem {

    private static final String REGISTRATION_REQUIRED = "Please register first.";
    private InputHandler inputHandler = new InputHandler();
    private User user = new User();
    private WaterIntakeManager waterIntakeManager = new WaterIntakeManager();

    public static void main(String[] args) {
        new MainSystem().startMenu();
    }

    void startMenu() {
        int choice = 0;

        while (choice != 7) {
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
        }
    }

    private void printMenu() {
        System.out.println("\n===== Daily Water Intake System =====");
        System.out.println("1. Register User");
        System.out.println("2. View Water Goal");
        System.out.println("3. Add Water Intake");
        System.out.println("4. View Water History");
        System.out.println("5. Check Hydration Status");
        System.out.println("6. View Daily Summary");
        System.out.println("7. Exit");
    }

    private void registerUser() {
        System.out.println("\n===== Register User =====");

        user.setName(inputHandler.readText("Enter Name: "));
        user.setAge(inputHandler.readPositiveInt("Enter Age: "));
        user.setGender(inputHandler.readText("Enter Gender: "));
        user.setWeight(inputHandler.readPositiveDouble("Enter Weight (kg): "));
        user.setDailyWaterGoal(GoalCalculator.calculateDailyGoal(user.getWeight()));
        waterIntakeManager.clearHistory();

        System.out.println("User Registered Successfully!");
    }

    private void showWaterGoal() {
        if (!requireRegistration()) {
            return;
        }

        System.out.println("Recommended Water Intake: " + (int) user.getDailyWaterGoal() + " ml");
    }

    private void addWaterIntake() {
        if (!requireRegistration()) {
            return;
        }

        double amount = inputHandler.readPositiveDouble("Enter Water Intake (ml): ");
        waterIntakeManager.addWaterIntake(amount);
        System.out.println("Water Intake Added Successfully!");
    }

    private void showHistory() {
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

    private void checkHydration() {
        if (!requireRegistration()) {
            return;
        }

        double total = waterIntakeManager.calculateTotalWater();
        System.out.println("Status: " + HydrationEvaluator.hydrationStatus(total, user.getDailyWaterGoal()));
    }

    private void showSummary() {
        if (!requireRegistration()) {
            return;
        }

        SummaryDisplay.show(user, waterIntakeManager);
    }

    private boolean requireRegistration() {
        if (!user.isRegistered()) {
            System.out.println(REGISTRATION_REQUIRED);
            return false;
        }
        return true;
    }
}
