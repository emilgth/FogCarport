package FunctionLayer.Models;

/**
 * Object representing an order's orderLines
 */
public class OrderLine {
    private Material material;
    private int amount;
    private String description;

    /**
     * @param material material object
     * @param amount how many
     * @param description material description
     */
    public OrderLine(Material material, int amount, String description) {
        this.material = material;
        this.amount = amount;
        this.description = description;
    }

    Material getMaterial() {
        return material;
    }

    int getAmount() {
        return amount;
    }

}
