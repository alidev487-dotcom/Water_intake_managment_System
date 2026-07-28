import java.util.ArrayList;
import java.util.List;

// Team task: Isamatov Damir - water intake storage, history tracking, and total calculation.

public class WaterIntakeManager {

    private final List<Double> waterHistory = new ArrayList<>();

    void addWaterIntake(double amount) {
        if (amount <= 0) {
            return;
        }

        waterHistory.add(amount);
    }

    double calculateTotalWater() {
        double total = 0;

        for (double water : waterHistory) {
            total += water;
        }

        return total;
    }

    boolean isEmpty() {
        return waterHistory.isEmpty();
    }

    String buildHistoryReport() {
        StringBuilder report = new StringBuilder();

        for (int i = 0; i < waterHistory.size(); i++) {
            report.append(i + 1)
                    .append(". ")
                    .append(waterHistory.get(i))
                    .append(" ml\n");
        }

        return report.toString();
    }

    void clearHistory() {
        waterHistory.clear();
    }
}