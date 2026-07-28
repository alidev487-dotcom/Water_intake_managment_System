// Team task: Hadi Abdul - hydration status rules and evaluation output.
public class HydrationEvaluator {

    private HydrationEvaluator() {
    }

    static String evaluate(double total, double goal) {
        if (goal <= 0) {
            return "No Goal Set";
        }

        if (total >= goal) {
            return "Well Hydrated";
        }

        if (total >= goal * 0.8) {
            return "Almost Achieved";
        }

        if (total >= goal * 0.5) {
            return "Need More Water";
        }

        return "Dehydrated";
    }
}