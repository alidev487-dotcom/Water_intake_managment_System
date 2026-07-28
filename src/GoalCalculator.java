// Team task: Towfiq Abu Hayat MD - calculates the recommended daily water goal.
public class GoalCalculator {
    static double calculateDailyGoal(double weight) {
        if (weight <= 0) {
            return 0;
        }
        return weight * 35;
    }
}
