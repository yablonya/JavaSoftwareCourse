import java.util.Arrays;

/**
 * The Main class is the entry point of the program that works with BuildingBlock objects.
 * It creates an array of blocks, sorts them by color (alphabetically) and weight (descending),
 * and searches for an identical block in the array.
 */
public class Main {

    /**
     * The main execution method of the program.
     * Creates an array of BuildingBlock objects, sorts them, and checks for an identical block.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Initialize an array of BuildingBlock objects with various properties
        BuildingBlock[] blocks = {
                new BuildingBlock("Wood", "Brown", 2.5, 1.5, 50),
                new BuildingBlock("Pine", "Brown", 2.5, 2, 50),
                new BuildingBlock("Stone", "Gray", 6.0, 3.0, 200),
                new BuildingBlock("Iron", "Silver", 7.0, 4.5, 300),
                new BuildingBlock("Gold", "Yellow", 5.0, 4.0, 100),
        };

        // Sort the array of blocks by color (alphabetically) and by weight (descending) manually
        for (int i = 0; i < blocks.length - 1; i++) {
            for (int j = i + 1; j < blocks.length; j++) {
                // Compare by color alphabetically
                if (blocks[i].getColor().compareTo(blocks[j].getColor()) > 0) {
                    BuildingBlock temp = blocks[i];
                    blocks[i] = blocks[j];
                    blocks[j] = temp;
                } else if (blocks[i].getColor().equals(blocks[j].getColor()) &&
                        blocks[i].getWeight() < blocks[j].getWeight()) {
                    // If colors are the same, compare by weight in descending order
                    BuildingBlock temp = blocks[i];
                    blocks[i] = blocks[j];
                    blocks[j] = temp;
                }
            }
        }

        // Display the sorted array of blocks
        System.out.println("Sorted blocks:");
        for (BuildingBlock block : blocks) {
            System.out.println(block);
        }

        // Search for an identical block by iterating through the array
        BuildingBlock searchBlock = new BuildingBlock("Gold", "Yellow", 5.0, 4.0, 100);
        boolean found = false;

        for (BuildingBlock block : blocks) {
            if (block.equals(searchBlock)) {
                found = true;
                break;
            }
        }

        // Display whether an identical block was found
        if (found) {
            System.out.println("Identical block found: " + searchBlock);
        } else {
            System.out.println("Identical block not found.");
        }
    }
}

