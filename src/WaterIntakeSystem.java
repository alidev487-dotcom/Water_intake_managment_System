import java.util.ArrayList;
import java.util.Scanner;
       // Abdalla part
public class WaterIntakeSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<WaterIntakeRecord> records = new ArrayList<>();

        System.out.println("Daily Water Intake Management System");
        System.out.print("How many intake records do you want to enter? ");
        int totalRecords = scanner.nextInt();

        for (int i = 1; i <= totalRecords; i++) {
            System.out.print("Enter water intake amount for record " + i + " (mL): ");
            double amount = scanner.nextDouble();

            WaterIntakeRecord record = new WaterIntakeRecord();
            record.amount = amount;
            records.add(record);
        }
 // abdalla part
        System.out.println();
        System.out.println("Water Intake Records:");

        for (int i = 0; i < records.size(); i++) {
            WaterIntakeRecord record = records.get(i);
            System.out.println("Record " + (i + 1) + ": " + record.amount + " mL");
        }

        scanner.close();
    }
}

class WaterIntakeRecord {
    double amount;
}
