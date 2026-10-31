
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ParkingLot parkingLot = new ParkingLot(5);

        while (true) {

            System.out.println("\n===== PARKING LOT MANAGEMENT SYSTEM =====");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Search Vehicle");
            System.out.println("4. Display Parking Slots");
            System.out.println("5. Display Parking Statistics");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");

            String input = sc.nextLine().trim();

            int choice;

            try {
                choice = Integer.parseInt(input);
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {

                case 1: {

                    String registrationNumber =
                            readNonEmptyInput(sc, "Enter registration number: ");

                    String vehicleType = readVehicleType(sc);

                    Vehicle vehicle = new Vehicle(registrationNumber, vehicleType);

                    parkingLot.parkVehicle(vehicle);

                    break;
                }

                case 2: {

                    String registrationNumber =
                            readNonEmptyInput(sc, "Enter registration number: ");

                    parkingLot.removeVehicle(registrationNumber);

                    break;
                }

                case 3: {

                    String registrationNumber =
                            readNonEmptyInput(sc, "Enter registration number: ");

                    parkingLot.searchVehicle(registrationNumber);

                    break;
                }

                case 4: {

                    parkingLot.displaySlots();

                    break;
                }

                case 5: {

                    parkingLot.displayStatistics();

                    break;
                }

                case 6: {

                    System.out.println("Exiting application...");
                    sc.close();
                    return;
                }

                default:

                    System.out.println("Invalid choice! Please select 1-6.");
            }
        }
    }

    // Read non-empty input
    private static String readNonEmptyInput(Scanner sc, String message) {

        while (true) {

            System.out.print(message);

            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Input cannot be empty! Please try again.");
            }
            else {
                return input;
            }
        }
    }

    // Validate vehicle type
    private static String readVehicleType(Scanner sc) {

        while (true) {

            System.out.print("Enter vehicle type (Car/Bike): ");

            String vehicleType = sc.nextLine().trim();

            if (vehicleType.equalsIgnoreCase("Car")) {
                return "Car";
            }
            else if (vehicleType.equalsIgnoreCase("Bike")) {
                return "Bike";
            }
            else {
                System.out.println("Invalid vehicle type! Enter Car or Bike.");
            }
        }
    }
}
