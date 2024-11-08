/**
 * Class representing a passenger plane with additional specific attributes.
 */
public class PassengerPlane extends Aircraft {
    /**
     * Number of economy seats on the plane.
     */
    private int economySeats;

    /**
     * Number of business class seats on the plane.
     */
    private int businessSeats;

    /**
     * Constructs a PassengerPlane instance with specific attributes.
     *
     * @param model the model name of the plane
     * @param capacity the total passenger capacity
     * @param cargoCapacity the cargo capacity in tons
     * @param flightRange the flight range in kilometers
     * @param fuelConsumption the fuel consumption in liters per kilometer
     * @param economySeats the number of economy class seats
     * @param businessSeats the number of business class seats
     */
    public PassengerPlane(String model, int capacity, double cargoCapacity, double flightRange, double fuelConsumption, int economySeats, int businessSeats) {
        super(model, capacity, cargoCapacity, flightRange, fuelConsumption);
        this.economySeats = economySeats;
        this.businessSeats = businessSeats;
    }

    /**
     * Gets the number of economy class seats.
     *
     * @return the number of economy class seats
     */
    public int getEconomySeats() {
        return economySeats;
    }

    /**
     * Gets the number of business class seats.
     *
     * @return the number of business class seats
     */
    public int getBusinessSeats() {
        return businessSeats;
    }

    @Override
    public String toString() {
        return super.toString() + ", Economy Seats: " + economySeats + ", Business Seats: " + businessSeats;
    }
}
