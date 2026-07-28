// Team task: Isamatov Damir - stores water intake entries and calculates totals.
import java.util.ArrayList;

public class WaterIntakeManager {
    ArrayList<Double> waterHistory = new ArrayList<>();

    void addWater(double amount) {
        waterHistory.add(amount);
    }

    double getTotal() {
        double total = 0;
        for (double amount : waterHistory) {
            total += amount;
        }
        return total;
    }

    boolean isEmpty() {
        return waterHistory.isEmpty();
    }

    void clearHistory() {
        waterHistory.clear();
    }

    void printHistory() {
        for (int i = 0; i < waterHistory.size(); i++) {
            System.out.println((i + 1) + ". " + waterHistory.get(i) + " ml");
        }
    }
}
