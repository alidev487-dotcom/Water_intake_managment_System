public class SummaryDisplay {

    static void show(User user, WaterIntakeManager waterIntakeManager) {
        double total = waterIntakeManager.calculateTotalWater();
        double remaining = user.getDailyWaterGoal() - total;
        if (remaining < 0) {
            remaining = 0;
        }

        System.out.println("\n===== Daily Summary =====");
        System.out.println("Name: " + user.getName());
        System.out.println("Age: " + user.getAge());
        System.out.println("Gender: " + user.getGender());
        System.out.println("Recommended Water: " + (int) user.getDailyWaterGoal() + " ml");
        System.out.println("Total Consumed: " + (int) total + " ml");
        System.out.println("Remaining Water: " + (int) remaining + " ml");
        System.out.println("Status: " + HydrationEvaluator.hydrationStatus(total, user.getDailyWaterGoal()));

        if (waterIntakeManager.isEmpty()) {
            System.out.println("History: No Records Found.");
        } else {
            System.out.println("\n===== Water Intake History =====");
            System.out.print(waterIntakeManager.buildHistoryReport());
        }
    }
}
