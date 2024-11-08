/**
 * Class representing an airline company managing a collection of aircraft.
 */
public class AirlineCompany {
    /**
     * Array of aircraft managed by the airline.
     */
    private Aircraft[] fleet;

    /**
     * Constructs an AirlineCompany instance with the specified fleet of aircraft.
     *
     * @param fleet an array of aircraft
     * @throws IllegalArgumentException if the fleet is null or empty
     */
    public AirlineCompany(Aircraft[] fleet) {
        if (fleet == null || fleet.length == 0) {
            throw new IllegalArgumentException("Fleet cannot be null or empty.");
        }
        this.fleet = fleet;
    }

    /**
     * Calculates the total passenger capacity of the airline.
     *
     * @return the total capacity
     */
    public int getTotalCapacity() {
        int totalCapacity = 0;

        try {
            for (Aircraft aircraft : fleet) {
                totalCapacity += aircraft.getCapacity();
            }
        } catch (NullPointerException e) {
            throw new RuntimeException("Error calculating total capacity: Aircraft in the fleet is null.", e);
        }

        return totalCapacity;
    }

    /**
     * Calculates the total cargo capacity of the airline in tons.
     *
     * @return the total cargo capacity
     */
    public double getTotalCargoCapacity() {
        double totalCargoCapacity = 0;

        try {
            for (Aircraft aircraft : fleet) {
                totalCargoCapacity += aircraft.getCargoCapacity();
            }
        } catch (NullPointerException e) {
            throw new RuntimeException("Error calculating total cargo capacity: Aircraft in the fleet is null.", e);
        }

        return totalCargoCapacity;
    }

    /**
     * Sorts the aircraft in the fleet by flight range in ascending order.
     */
    public void sortFleetByFlightRange() {
        try {
            for (int i = 0; i < fleet.length - 1; i++) {
                for (int j = 0; j < fleet.length - i - 1; j++) {
                    if (fleet[j].getFlightRange() > fleet[j + 1].getFlightRange()) {
                        Aircraft temp = fleet[j];
                        fleet[j] = fleet[j + 1];
                        fleet[j + 1] = temp;
                    }
                }
            }
        } catch (NullPointerException e) {
            throw new RuntimeException("Error sorting fleet: Aircraft in the fleet is null.", e);
        }
    }

    /**
     * Finds aircraft in the fleet that have a fuel consumption within the specified range.
     *
     * @param minConsumption the minimum fuel consumption in liters per kilometer
     * @param maxConsumption the maximum fuel consumption in liters per kilometer
     * @return an array of aircraft that match the criteria
     * @throws IllegalArgumentException if minConsumption is greater than maxConsumption
     */
    public Aircraft[] findAircraftByFuelConsumption(double minConsumption, double maxConsumption) {
        if (minConsumption > maxConsumption) {
            throw new IllegalArgumentException("Minimum consumption cannot be greater than maximum consumption.");
        }

        Aircraft[] result = new Aircraft[fleet.length];
        int index = 0;

        try {
            for (Aircraft aircraft : fleet) {
                if (aircraft != null && aircraft.getFuelConsumption() >= minConsumption && aircraft.getFuelConsumption() <= maxConsumption) {
                    result[index++] = aircraft;
                }
            }
        } catch (NullPointerException e) {
            throw new RuntimeException("Error finding aircraft by fuel consumption: Aircraft in the fleet is null.", e);
        }

        // Trim the result array to the actual size
        return java.util.Arrays.copyOf(result, index);
    }
}
