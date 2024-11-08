/**
 * Class representing a cargo plane with specific attributes for cargo transport.
 */
public class CargoPlane extends Aircraft {
    /**
     * Maximum cargo load in cubic meters.
     */
    private double maxCargoVolume;

    /**
     * Constructs a CargoPlane instance with specific attributes.
     *
     * @param model the model name of the plane
     * @param capacity the total passenger capacity
     * @param cargoCapacity the cargo capacity in tons
     * @param flightRange the flight range in kilometers
     * @param fuelConsumption the fuel consumption in liters per kilometer
     * @param maxCargoVolume the maximum cargo volume in cubic meters
     */
    public CargoPlane(String model, int capacity, double cargoCapacity, double flightRange, double fuelConsumption, double maxCargoVolume) {
        super(model, capacity, cargoCapacity, flightRange, fuelConsumption);
        this.maxCargoVolume = maxCargoVolume;
    }

    /**
     * Gets the maximum cargo volume.
     *
     * @return the maximum cargo volume in cubic meters
     */
    public double getMaxCargoVolume() {
        return maxCargoVolume;
    }

    @Override
    public String toString() {
        return super.toString() + ", Max Cargo Volume: " + maxCargoVolume + " cubic meters";
    }
}

