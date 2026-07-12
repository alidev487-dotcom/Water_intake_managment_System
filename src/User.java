// Team task division:
// Member 1: Affan Umer (202601010507) -> Manage user registration, profile data, and recommended water calculation.
public class User {
    private String name;
    private int age;
    private String gender;
    private double weight;
    private double recommendedWater;

    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double calculateRecommendedWater() {
        if (weight > 0) {
            this.recommendedWater = weight * 35;
        } else {
            this.recommendedWater = 0;
        }
        return this.recommendedWater;
    }

    public void displayUserInfo() {
        System.out.println("\nUser Profile");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Recommended Water Intake: " + recommendedWater + " ml");
    }

    public boolean isRegistered() {
        return name != null && !name.trim().isEmpty();
    }

    public double getRecommendedWater() {
        return recommendedWater;
    }

    public String getName() {
        return name;
    }
}
