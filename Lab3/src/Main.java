import java.util.Arrays;
import java.util.Comparator;

/**
 * The Main class is the entry point of the program that works with BuildingBlock objects.
 * It creates an array of blocks, sorts them by hardness (ascending) and weight (descending),
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
        BuildingBlock[] blocks = {
                new BuildingBlock("Wood", "Brown", 2.5, 1.5, 50),
                new BuildingBlock("Stone", "Gray", 6.0, 3.0, 200),
                new BuildingBlock("Iron", "Silver", 7.0, 4.5, 300),
                new BuildingBlock("Gold", "Yellow", 5.0, 4.0, 100),
                new BuildingBlock("Diamond", "Blue", 10.0, 3.2, 500)
        };

        // Sort the array of blocks
        Arrays.sort(blocks, Comparator.comparing(BuildingBlock::getHardness)
                .thenComparing(Comparator.comparing(BuildingBlock::getWeight).reversed()));

        System.out.println("Sorted blocks:");
        for (BuildingBlock block : blocks) {
            System.out.println(block);
        }

        // Search for an identical block
        BuildingBlock searchBlock = new BuildingBlock("Gold", "Yellow", 5.0, 4.0, 100);
        boolean found = Arrays.asList(blocks).contains(searchBlock);

        if (found) {
            System.out.println("Identical block found: " + searchBlock);
        } else {
            System.out.println("Identical block not found.");
        }
    }
}
