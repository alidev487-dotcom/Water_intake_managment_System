// Team task: Towfiq Abu Hayat MD
public class GoalCalculator {
    static double calculateDailyGoal(double weight) {
        if (weight <= 0) {
            return 0;
        }
        return weight * 35;
    }
}
