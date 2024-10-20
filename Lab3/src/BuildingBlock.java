import java.util.Objects;

/**
 * The BuildingBlock class represents a building block (similar to Minecraft blocks).
 * Each block has properties like material, color, hardness, weight, and durability.
 */
public class BuildingBlock {

    private String material;
    private String color;
    private double hardness;
    private double weight;
    private int durability;

    /**
     * Constructor for creating a BuildingBlock object.
     *
     * @param material   the material of the block (e.g., "Wood", "Stone")
     * @param color      the color of the block (e.g., "Brown", "Gray")
     * @param hardness   the hardness of the block (as a floating point number)
     * @param weight     the weight of the block (as a floating point number)
     * @param durability the durability of the block (as an integer)
     */
    public BuildingBlock(String material, String color, double hardness, double weight, int durability) {
        this.material = material;
        this.color = color;
        this.hardness = hardness;
        this.weight = weight;
        this.durability = durability;
    }

    /**
     * Gets the material of the block.
     *
     * @return the material of the block
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Sets the material of the block.
     *
     * @param material the material to set
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Gets the color of the block.
     *
     * @return the color of the block
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the block.
     *
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Gets the hardness of the block.
     *
     * @return the hardness of the block
     */
    public double getHardness() {
        return hardness;
    }

    /**
     * Sets the hardness of the block.
     *
     * @param hardness the hardness to set
     */
    public void setHardness(double hardness) {
        this.hardness = hardness;
    }

    /**
     * Gets the weight of the block.
     *
     * @return the weight of the block
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the block.
     *
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Gets the durability of the block.
     *
     * @return the durability of the block
     */
    public int getDurability() {
        return durability;
    }

    /**
     * Sets the durability of the block.
     *
     * @param durability the durability to set
     */
    public void setDurability(int durability) {
        this.durability = durability;
    }

    /**
     * Checks if the current block is equal to another object.
     * Two blocks are considered equal if they have the same material, color, hardness, weight, and durability.
     *
     * @param obj the object to compare
     * @return true if the objects are identical, otherwise false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BuildingBlock other = (BuildingBlock) obj;
        return material.equals(other.material) && color.equals(other.color)
                && Double.compare(hardness, other.hardness) == 0
                && Double.compare(weight, other.weight) == 0
                && durability == other.durability;
    }

    /**
     * Generates a hash code for the BuildingBlock object based on its fields.
     *
     * @return the hash code of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(material, color, hardness, weight, durability);
    }

    /**
     * Returns a string representation of the BuildingBlock object.
     * The string contains the block's material, color, hardness, weight, and durability.
     *
     * @return a string containing the block's information
     */
    @Override
    public String toString() {
        return "BuildingBlock{" +
                "material='" + material + '\'' +
                ", color='" + color + '\'' +
                ", hardness=" + hardness +
                ", weight=" + weight +
                ", durability=" + durability +
                '}';
    }
}

