import java.util.ArrayList;
import java.util.Scanner;

public class DailyWaterIntakeSystem {

    Scanner input = new Scanner(System.in);

    // User information
    String name;
    String gender;
    int age;
    double weight;

    // Water information
    double dailyWaterGoal;
    ArrayList<Double> waterHistory = new ArrayList<>();

    boolean isRegistered = false;


    public static void main(String[] args) {

        DailyWaterIntakeSystem system = new DailyWaterIntakeSystem();

        system.startMenu();
    }


    
    void startMenu() {

        int choice;

        do {

            System.out.println("\n===== Daily Water Intake System =====");
            System.out.println("1. Register User");
            System.out.println("2. View Water Goal");
            System.out.println("3. Add Water Intake");
            System.out.println("4. View Water History");
            System.out.println("5. Check Hydration Status");
            System.out.println("6. View Daily Summary");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            choice = Integer.parseInt(input.nextLine());


            switch(choice) {

                case 1:
                    registerUser();
                    break;

                case 2:
                    showWaterGoal();
                    break;

                case 3:
                    addWaterIntake();
                    break;

                case 4:
                    showHistory();
                    break;

                case 5:
                    checkHydration();
                    break;

                case 6:
                    showSummary();
                    break;

                case 7:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while(choice != 7);
    }



    // Register new user
    void registerUser() {

        System.out.println("\n===== Register User =====");


        System.out.print("Enter Name: ");
        name = input.nextLine();


        System.out.print("Enter Age: ");
        age = Integer.parseInt(input.nextLine());


        System.out.print("Enter Gender: ");
        gender = input.nextLine();


        System.out.print("Enter Weight (kg): ");
        weight = Double.parseDouble(input.nextLine());


        
        dailyWaterGoal = weight * 35;
        //The weight × 35 formula is a quick method used to estimate 
        // your daily baseline water intake in milliliters (mL) based
        //  on your body weight in kilograms (kg)


        isRegistered = true;
        waterHistory.clear();


        System.out.println("User Registered Successfully!");
    }



    // Display recommended water
    void showWaterGoal() {

        if (!isRegistered) {

            System.out.println("Please register first.");
            return;
        }


        System.out.println("Recommended Water Intake: "
                + dailyWaterGoal + " ml");
    }



    // Add water intake
    void addWaterIntake() {

        if (!isRegistered) {

            System.out.println("Please register first.");
            return;
        }


        System.out.print("Enter Water Intake (ml): ");
        double amount = Double.parseDouble(input.nextLine());


        waterHistory.add(amount);


        System.out.println("Water Intake Added Successfully!");
    }



    // View previous water records
    void showHistory() {

        if (!isRegistered) {

            System.out.println("Please register first.");
            return;
        }


        if (waterHistory.isEmpty()) {

            System.out.println("No Records Found.");
            return;
        }


        System.out.println("\n===== Water Intake History =====");


        for (int i = 0; i < waterHistory.size(); i++) {

            System.out.println((i + 1) + ". "
                    + waterHistory.get(i) + " ml");
        }
    }



    // Calculate total water consumed
    double calculateTotalWater() {

        double total = 0;


        for (double water : waterHistory) {

            total += water;
        }


        return total;
    }



    // Check hydration status
    void checkHydration() {

        if (!isRegistered) {

            System.out.println("Please register first.");
            return;
        }


        double total = calculateTotalWater();


        if (total >= dailyWaterGoal) {

            System.out.println("Status: Well Hydrated");

        } else if (total >= dailyWaterGoal * 0.8) {

            System.out.println("Status: Almost Achieved");

        } else if (total >= dailyWaterGoal * 0.5) {

            System.out.println("Status: Need More Water");

        } else {

            System.out.println("Status: Dehydrated");
        }
    }



    // Show daily report
    void showSummary() {

        if (!isRegistered) {

            System.out.println("Please register first.");
            return;
        }


        double total = calculateTotalWater();

        double remaining = dailyWaterGoal - total;


        if (remaining < 0) {

            remaining = 0;
        }


        System.out.println("\n===== Daily Summary =====");

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);

        System.out.println("Recommended Water: "
                + dailyWaterGoal + " ml");

        System.out.println("Total Consumed: "
                + total + " ml");

        System.out.println("Remaining Water: "
                + remaining + " ml");


        checkHydration();
    }
}