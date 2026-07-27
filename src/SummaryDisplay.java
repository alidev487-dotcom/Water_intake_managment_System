// Team task: Hassan Mahmoud Suliman Ahmed - final summary output and report formatting.
public class SummaryDisplay {

    private SummaryDisplay() {
    }

    static void show(User user, WaterIntakeManager waterIntakeManager) {
        double total = waterIntakeManager.calculateTotalWater();
        double remaining = user.getDailyWaterGoal() - total;

        if (remaining < 0) {
            remaining = 0;
        }

        StringBuilder summary = new StringBuilder();
        summary.append("\n===== Daily Summary =====\n");
        summary.append("Name: ").append(user.getName()).append('\n');
        summary.append("Age: ").append(user.getAge()).append('\n');
        summary.append("Gender: ").append(user.getGender()).append('\n');
        summary.append("Recommended Water: ").append(user.getDailyWaterGoal()).append(" ml\n");
        summary.append("Total Consumed: ").append(total).append(" ml\n");
        summary.append("Remaining Water: ").append(remaining).append(" ml\n");
        summary.append("Status: ").append(HydrationEvaluator.evaluate(total, user.getDailyWaterGoal())).append('\n');

        if (waterIntakeManager.isEmpty()) {
            summary.append("History: No Records Found.\n");
        } else {
            summary.append("\n===== Water Intake History =====\n");
            summary.append(waterIntakeManager.buildHistoryReport());
        }

        System.out.print(summary);
    }
}