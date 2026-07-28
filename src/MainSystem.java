// Team task: AFFAN UMER - overall program flow, menu handling, and feature coordination.
public class MainSystem {
    static final double MAX_WATER_INTAKE = 5000;

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        User user = new User();
        WaterIntakeManager waterIntakeManager = new WaterIntakeManager();
        int choice = 0;

        while (choice != 7) {
            System.out.println("\n===== Daily Water Intake System =====");
            System.out.println("1. Register User");
            System.out.println("2. View Water Goal");
            System.out.println("3. Add Water Intake");
            System.out.println("4. View Water History");
            System.out.println("5. Check Hydration Status");
            System.out.println("6. View Daily Summary");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");
            choice = inputHandler.readInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("\n===== Register User =====");
                    System.out.print("Enter Name: ");
                    user.userName = inputHandler.readText();
                    System.out.print("Enter Age: ");
                    user.userAge = inputHandler.readInt();
                    System.out.print("Enter Gender: ");
                    user.userGender = inputHandler.readText();
                    System.out.print("Enter Weight (kg): ");
                    user.userWeight = inputHandler.readDouble();
                    user.dailyWaterGoal = GoalCalculator.calculateDailyGoal(user.userWeight);
                    waterIntakeManager.clearHistory();
                    System.out.println("User Registered Successfully!");
                }
                case 2 -> {
                    if (!user.isRegistered()) {
                        System.out.println("Please register first.");
                    } else {
                        System.out.println("Recommended Water Intake: " + (int) user.dailyWaterGoal + " ml");
                    }
                }
                case 3 -> {
                    if (!user.isRegistered()) {
                        System.out.println("Please register first.");
                    } else {
                        System.out.print("Enter Water Intake (ml): ");
                        double waterIntake = inputHandler.readDouble();
                        while (waterIntake > MAX_WATER_INTAKE) {
                            System.out.println("Please enter a value up to " + (int) MAX_WATER_INTAKE + " ml at a time.");
                            System.out.print("Enter Water Intake (ml): ");
                            waterIntake = inputHandler.readDouble();
                        }
                        waterIntakeManager.addWater(waterIntake);
                        System.out.println("Water Intake Added Successfully!");
                    }
                }
                case 4 -> {
                    if (!user.isRegistered()) {
                        System.out.println("Please register first.");
                    } else if (waterIntakeManager.isEmpty()) {
                        System.out.println("No Records Found.");
                    } else {
                        System.out.println("\n===== Water Intake History =====");
                        waterIntakeManager.printHistory();
                    }
                }
                case 5 -> {
                    if (!user.isRegistered()) {
                        System.out.println("Please register first.");
                    } else {
                        double totalWaterIntake = waterIntakeManager.getTotal();
                        System.out.println("Status: " + HydrationEvaluator.hydrationStatus(totalWaterIntake, user.dailyWaterGoal));
                    }
                }
                case 6 -> {
                    if (!user.isRegistered()) {
                        System.out.println("Please register first.");
                    } else {
                        SummaryDisplay.show(user, waterIntakeManager);
                    }
                }
                case 7 ->
                    System.out.println("Thank you!");
                default ->
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
