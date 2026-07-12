import java.util.ArrayList;

// Team task division:
// Member 2: Salem Abdalla (202504010054) -> Manage water intake records, history, totals, remaining water, and hydration status.
public class WaterRecord {
    private final ArrayList<Double> waterIntakes;

    public WaterRecord() {
        this.waterIntakes = new ArrayList<>();
    }

    public void addWaterIntake(double amount) {
        waterIntakes.add(amount);
    }

    public double calculateTotalConsumption() {
        double total = 0;
        for (double intake : waterIntakes) {
            total += intake;
        }
        return total;
    }

    public double getRemainingWater(double recommendedWater) {
        return Math.max(recommendedWater - calculateTotalConsumption(), 0);
    }

    public String checkHydrationStatus(double recommendedWater) {
        if (recommendedWater <= 0) {
            return "Not Available";
        }

        double percentage = (calculateTotalConsumption() / recommendedWater) * 100;
        if (percentage < 50) {
            return "Dehydrated";
        } else if (percentage < 80) {
            return "Need More Water";
        } else if (percentage < 100) {
            return "Almost Achieved";
        } else {
            return "Well Hydrated";
        }
    }

    public void displayHistory() {
        System.out.println("\nWater Consumption History");
        if (waterIntakes.isEmpty()) {
            System.out.println("No intake records recorded yet.");
            return;
        }

        for (int i = 0; i < waterIntakes.size(); i++) {
            System.out.println((i + 1) + ". " + waterIntakes.get(i) + " ml");
        }
    }

    public boolean isEmpty() {
        return waterIntakes.isEmpty();
    }
}
