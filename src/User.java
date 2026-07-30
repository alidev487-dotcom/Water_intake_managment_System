// Team task: Parmis Hajianfard - stores the user's profile details.
public class User {
    String userName = "";
    String userGender = "";
    int userAge;
    double userWeight;
    double dailyWaterGoal;

    boolean isRegistered() {

        return userName.length() > 0;
    }
}
