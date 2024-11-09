/**
 * The Main class to demonstrate the functionality of the AircraftCollection class.
 * This class creates instances of Aircraft, adds them to an AircraftCollection,
 * and prints the contents of the collection.
 */
class Main {
    /**
     * The main method to demonstrate the usage of the AircraftCollection class.
     * This method creates several Aircraft objects, adds them to an instance
     * of AircraftCollection, and displays the contents of the collection.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Aircraft aircraft1 = new Aircraft("Boeing 747", 400, 70.0, 13000.0, 3.5);
        Aircraft aircraft2 = new Aircraft("Airbus A320", 180, 30.0, 6100.0, 2.5);
        Aircraft aircraft3 = new Aircraft("Cessna 172", 4, 0.5, 1280.0, 0.2);

        AircraftCollection collection = new AircraftCollection();
        collection.add(aircraft1);
        collection.add(aircraft2);
        collection.add(aircraft3);

        System.out.println("Aircraft in the collection:");
        for (Aircraft aircraft : collection) {
            System.out.println(aircraft);
        }
    }
}