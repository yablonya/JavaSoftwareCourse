/**
 * Main class for demonstrating the functionality of the AirlineCompany.
 * This class initializes various types of aircraft, calculates total capacities,
 * sorts the fleet by flight range, and filters aircraft based on fuel consumption.
 */
public class Main {
    /**
     * The entry point of the program where operations on the AirlineCompany are demonstrated.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Initializing the fleet with a mix of aircraft types
        Aircraft[] fleet = {
                new PassengerPlane("Boeing 747", 400, 20.0, 14000, 5.0, 350, 50),
                new PassengerPlane("Airbus A380", 500, 30.0, 15000, 6.0, 450, 50),
                new CargoPlane("Boeing 777F", 2, 100.0, 9000, 8.0, 600),
                new MilitaryPlane("F-22 Raptor", 1, 5.0, 3000, 15.0, "Missiles")
        };

        // Creating an instance of AirlineCompany with the fleet
        AirlineCompany airlineCompany = new AirlineCompany(fleet);

        // Calculating and displaying the total passenger capacity
        int totalCapacity = airlineCompany.getTotalCapacity();
        System.out.println("Total passenger capacity: " + totalCapacity);

        // Calculating and displaying the total cargo capacity
        double totalCargoCapacity = airlineCompany.getTotalCargoCapacity();
        System.out.println("Total cargo capacity (tons): " + totalCargoCapacity);

        // Sorting the fleet by flight range and displaying the sorted result
        airlineCompany.sortFleetByFlightRange();
        System.out.println("\nFleet sorted by flight range:");
        for (Aircraft aircraft : fleet) {
            System.out.println(aircraft);
        }

        // Filtering and displaying aircraft within a specified fuel consumption range
        double minConsumption = 5.0;
        double maxConsumption = 10.0;
        Aircraft[] filteredAircraft = airlineCompany.findAircraftByFuelConsumption(minConsumption, maxConsumption);
        System.out.println("\nAircraft with fuel consumption between " + minConsumption + " and " + maxConsumption + " L/km:");
        for (Aircraft aircraft : filteredAircraft) {
            System.out.println(aircraft);
        }
    }
}