/**
 * Abstract class representing a general aircraft with basic characteristics.
 * This class serves as a base for different types of aircraft, providing common attributes
 * such as model, capacity, cargo capacity, flight range, and fuel consumption.
 */
public abstract class Aircraft {
    /**
     * The model name of the aircraft.
     */
    private String model;

    /**
     * The passenger capacity of the aircraft.
     */
    private int capacity;

    /**
     * The cargo capacity of the aircraft in tons.
     */
    private double cargoCapacity;

    /**
     * The maximum flight range of the aircraft in kilometers.
     */
    private double flightRange;

    /**
     * The fuel consumption of the aircraft in liters per kilometer.
     */
    private double fuelConsumption;

    /**
     * Constructs an Aircraft instance with the specified characteristics.
     *
     * @param model the model name of the aircraft
     * @param capacity the passenger capacity of the aircraft
     * @param cargoCapacity the cargo capacity of the aircraft in tons
     * @param flightRange the maximum flight range of the aircraft in kilometers
     * @param fuelConsumption the fuel consumption of the aircraft in liters per kilometer
     */
    public Aircraft(String model, int capacity, double cargoCapacity, double flightRange, double fuelConsumption) {
        this.model = model;
        this.capacity = capacity;
        this.cargoCapacity = cargoCapacity;
        this.flightRange = flightRange;
        this.fuelConsumption = fuelConsumption;
    }

    /**
     * Gets the model name of the aircraft.
     *
     * @return the model name
     */
    public String getModel() {
        return model;
    }

    /**
     * Gets the passenger capacity of the aircraft.
     *
     * @return the passenger capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets the cargo capacity of the aircraft in tons.
     *
     * @return the cargo capacity
     */
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    /**
     * Gets the maximum flight range of the aircraft in kilometers.
     *
     * @return the flight range
     */
    public double getFlightRange() {
        return flightRange;
    }

    /**
     * Gets the fuel consumption of the aircraft in liters per kilometer.
     *
     * @return the fuel consumption
     */
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * Returns a string representation of the aircraft, detailing its characteristics.
     *
     * @return a string with model, capacity, cargo capacity, flight range, and fuel consumption
     */
    @Override
    public String toString() {
        return "Model: " + model + ", Capacity: " + capacity + " passengers, Cargo Capacity: " +
                cargoCapacity + " tons, Flight Range: " + flightRange + " km, Fuel Consumption: " + fuelConsumption + " L/km";
    }
}

