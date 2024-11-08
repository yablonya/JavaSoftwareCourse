/**
 * Class representing a military plane with specific attributes.
 */
public class MilitaryPlane extends Aircraft {
    /**
     * Type of armament equipped on the plane.
     */
    private String armamentType;

    /**
     * Constructs a MilitaryPlane instance with specific attributes.
     *
     * @param model the model name of the plane
     * @param capacity the total passenger capacity
     * @param cargoCapacity the cargo capacity in tons
     * @param flightRange the flight range in kilometers
     * @param fuelConsumption the fuel consumption in liters per kilometer
     * @param armamentType the type of armament equipped on the plane
     */
    public MilitaryPlane(String model, int capacity, double cargoCapacity, double flightRange, double fuelConsumption, String armamentType) {
        super(model, capacity, cargoCapacity, flightRange, fuelConsumption);
        this.armamentType = armamentType;
    }

    /**
     * Gets the type of armament equipped on the plane.
     *
     * @return the type of armament
     */
    public String getArmamentType() {
        return armamentType;
    }

    @Override
    public String toString() {
        return super.toString() + ", Armament Type: " + armamentType;
    }
}
