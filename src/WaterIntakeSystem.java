import java.util.ArrayList;
import java.util.Scanner;

public class WaterIntakeSystem {
    static Scanner scanner = new Scanner(System.in);
    static String userName = "";
    static double weightKg = 0;

    // ArrayList to store intake records
    static ArrayList<WaterIntakeRecord> records = new ArrayList<>();

    public static void main(String[] args) {

        // -- WEEK 1: Display welcome banner --
        System.out.println("==========================================");
        System.out.println("   Daily Water Intake Management System   ");
        System.out.println("==========================================");

        // -- WEEK 2: Menu loop using while and switch --
        int choice = -1;

        while (choice != 0) {
            displayMenu();

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    setupProfile();
                    break;
                case 2:
                    calculateGoal();
                    break;
                case 3:               // Added in Week 3
                    logIntake();
                    break;
                case 4:               // Added in Week 3
                    viewHistory();
                    break;
                case 0:
                    System.out.println();
                    System.out.println("Goodbye! Stay hydrated!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // displayMenu() - Added in Week 3
    static void displayMenu() {
        System.out.println();
        System.out.println("--- Main Menu ---");
        System.out.println("1. Set Up User Profile");
        System.out.println("2. Calculate Daily Goal");
        System.out.println("3. Log Water Intake");     // Week 3
        System.out.println("4. View Intake History");  // Week 3
        System.out.println("0. Exit");
        System.out.println();
    }

    // setupProfile() - added in Week 3
    static void setupProfile() {
        scanner.nextLine(); // consume leftover newline

        // from Week 1 - Accept user name
        System.out.print("Enter your name: ");
        userName = scanner.nextLine();

        // from WEEK 1: Accept user weight
        System.out.print("Enter your weight (kg): ");
        weightKg = scanner.nextDouble();

        // from WEEK 2: Validate weight input
        while (weightKg <= 0) {
            System.out.println("Weight must be greater than 0. Please try again.");
            System.out.print("Enter your weight (kg): ");
            weightKg = scanner.nextDouble();
        }

        // from WEEK 1: Display entered information
        System.out.println();
        System.out.println("--- Your Information ---");
        System.out.println("Name   : " + userName);
        System.out.println("Weight : " + weightKg + " kg");
        System.out.println("Profile saved! Welcome, " + userName + "!");
    }


    // calculateGoal() — added in Week 2
    // Formula: weight (kg) * 30 = daily goal in mL
    static void calculateGoal() {
        if (userName.isEmpty() || weightKg <= 0) {
            System.out.println("Please set up your profile first (Option 1).");
            return;
        }

        double dailyGoal = weightKg * 30;

        System.out.println();
        System.out.println("--- Daily Water Goal ---");
        System.out.println("Name       : " + userName);
        System.out.println("Weight     : " + weightKg + " kg");
        System.out.println("Daily Goal : " + dailyGoal + " mL  (" + (dailyGoal / 1000) + " L)");
    }


    // logIntake() — added in Week 3
    // Creates a WaterIntakeRecord object and adds it to the ArrayList
    static void logIntake() {
        if (userName.isEmpty()) {
            System.out.println("Please set up your profile first (Option 1).");
            return;
        }

        System.out.print("Enter water intake amount (mL): ");
        double amount = scanner.nextDouble();

        // Validate intake amount
        while (amount <= 0) {
            System.out.println("Amount must be greater than 0. Please try again.");
            System.out.print("Enter water intake amount (mL): ");
            amount = scanner.nextDouble();
        }

        // Create a new WaterIntakeRecord object and store it in the ArrayList
        int entryNumber = records.size() + 1;
        WaterIntakeRecord record = new WaterIntakeRecord(amount, entryNumber);
        records.add(record);

        System.out.println("Logged: " + record);
    }

    // viewHistory() — added in Week 3
    // Uses a for-each loop to display all records
    // from the ArrayList and shows goal progress

    static void viewHistory() {
        if (records.isEmpty()) {
            System.out.println("No records found. Start logging your water intake!");
            return;
        }

        double total = 0;
        System.out.println();
        System.out.println("--- Intake History for " + userName + " ---");

        // for-each loop to iterate through the ArrayList
        for (WaterIntakeRecord record : records) {
            System.out.println(record);
            total += record.getAmount();
        }

        double dailyGoal = weightKg * 30;
        System.out.println("------------------------------------------");
        System.out.println("Total Intake : " + total + " mL");
        System.out.println("Daily Goal   : " + dailyGoal + " mL");

        // Show progress feedback
        if (total >= dailyGoal) {
            System.out.println("Great job, " + userName + "! You've reached your daily goal!");
        } else {
            double remaining = dailyGoal - total;
            System.out.println("Keep going! You need " + remaining + " mL more to reach your goal.");
        }
    }
}


// WaterIntakeRecord — added in Week 3
// Stores a single water intake log entry
// Demonstrates: encapsulation, constructor, getter
// methods, and toString()
class WaterIntakeRecord {

    // Private fields — only accessible through getters (encapsulation)
    private double amount;
    private int entryNumber;

    // Constructor — called when creating a new WaterIntakeRecord object
    public WaterIntakeRecord(double amount, int entryNumber) {
        this.amount = amount;
        this.entryNumber = entryNumber;
    }

    // Returns the amount of water logged (in mL)
    public double getAmount() {
        return amount;
    }

    // Returns the entry number of this record
    public int getEntryNumber() {
        return entryNumber;
    }

    // Returns a readable string when the object is printed
    @Override
    public String toString() {
        return "Entry #" + entryNumber + "  -  " + amount + " mL";
    }
}
