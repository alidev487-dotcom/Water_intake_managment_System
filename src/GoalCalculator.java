// Team task: Towfiq Abu Hayat MD - daily water goal calculation logic.
public class GoalCalculator {

    private GoalCalculator() {
    }

    static double calculateDailyGoal(double weight) {
        if (weight <= 0) {
            return 0;
        }

        return weight * 35;
    }
}