// Team task: Hassan Mahmoud Suliman Ahmed - prints the final daily summary report.
public class SummaryDisplay {
    static void show(User user, WaterIntakeManager manager) {
        double totalWaterIntake = manager.getTotal();
        double remainingWater = user.dailyWaterGoal - totalWaterIntake;
        if (remainingWater < 0) {
            remainingWater = 0;
        }

        System.out.println("\n===== Daily Summary =====");
        System.out.println("Name: " + user.userName);
        System.out.println("Age: " + user.userAge);
        System.out.println("Gender: " + user.userGender);
        System.out.println("Recommended Water: " + (int) user.dailyWaterGoal + " ml");
        System.out.println("Total Consumed: " + (int) totalWaterIntake + " ml");
        System.out.println("Remaining Water: " + (int) remainingWater + " ml");
        System.out.println("Status: " + HydrationEvaluator.hydrationStatus(totalWaterIntake, user.dailyWaterGoal));

        if (manager.isEmpty()) {
            System.out.println("History: No Records Found.");
        } else {
            System.out.println("\n===== Water Intake History =====");
            manager.printHistory();
        }
    }
}
