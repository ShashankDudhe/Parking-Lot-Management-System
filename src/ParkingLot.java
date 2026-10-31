
import java.util.ArrayList;

public class ParkingLot {

    private ArrayList<ParkingSlot> slots;

    public ParkingLot(int totalSlots) {

        slots = new ArrayList<>();

        for (int i = 1; i <= totalSlots; i++) {
            ParkingSlot slot = new ParkingSlot(i);
            slots.add(slot);
        }
    }

    // Display all parking slots
    public void displaySlots() {

        for (ParkingSlot slot : slots) {

            System.out.println(
                    "Slot " + slot.getSlotNumber()
                            + " - "
                            + (slot.isAvailable() ? "Available" : "Occupied")
            );
        }
    }

    // Check whether a vehicle is already parked
    public boolean isVehicleAlreadyParked(String registrationNumber) {

        for (ParkingSlot slot : slots) {

            Vehicle vehicle = slot.getVehicle();

            if (vehicle != null &&
                    vehicle.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {

                return true;
            }
        }

        return false;
    }

    // Park a vehicle
    public void parkVehicle(Vehicle vehicle) {

        if (isVehicleAlreadyParked(vehicle.getRegistrationNumber())) {
            System.out.println("Vehicle is already parked!");
            return;
        }

        for (ParkingSlot slot : slots) {

            if (slot.isAvailable()) {

                slot.parkVehicle(vehicle);

                System.out.println(
                        "Vehicle parked successfully in Slot "
                                + slot.getSlotNumber()
                );

                return;
            }
        }

        System.out.println("Parking lot is full!");
    }

    // Remove a vehicle
    public void removeVehicle(String registrationNumber) {

        for (ParkingSlot slot : slots) {

            Vehicle vehicle = slot.getVehicle();

            if (vehicle != null &&
                    vehicle.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {

                slot.removeVehicle();

                System.out.println(
                        "Vehicle " + registrationNumber +
                                " exited from Slot " + slot.getSlotNumber()
                );

                return;
            }
        }

        System.out.println("Vehicle not found!");
    }

    // Search for a vehicle
    public void searchVehicle(String registrationNumber) {

        for (ParkingSlot slot : slots) {

            Vehicle vehicle = slot.getVehicle();

            if (vehicle != null &&
                    vehicle.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {

                System.out.println("Vehicle Found!");
                System.out.println("Registration: " + vehicle.getRegistrationNumber());
                System.out.println("Vehicle Type: " + vehicle.getVehicleType());
                System.out.println("Slot Number: " + slot.getSlotNumber());

                return;
            }
        }

        System.out.println("Vehicle not found!");
    }

    // Display parking statistics
    public void displayStatistics() {

        int totalSlots = slots.size();
        int occupiedSlots = 0;

        for (ParkingSlot slot : slots) {

            if (!slot.isAvailable()) {
                occupiedSlots++;
            }
        }

        int availableSlots = totalSlots - occupiedSlots;

        System.out.println("\n--- Parking Statistics ---");
        System.out.println("Total Slots: " + totalSlots);
        System.out.println("Occupied Slots: " + occupiedSlots);
        System.out.println("Available Slots: " + availableSlots);
    }
}
