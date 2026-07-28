public class User {

    private String name = "";
    private String gender = "";
    private int age;
    private double weight;
    private double dailyWaterGoal;

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getGender() {
        return gender;
    }

    void setGender(String gender) {
        this.gender = gender;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    double getWeight() {
        return weight;
    }

    void setWeight(double weight) {
        this.weight = weight;
    }

    double getDailyWaterGoal() {
        return dailyWaterGoal;
    }

    void setDailyWaterGoal(double dailyWaterGoal) {
        this.dailyWaterGoal = dailyWaterGoal;
    }

    boolean isRegistered() {
        return name != null && !name.isBlank();
    }
}
