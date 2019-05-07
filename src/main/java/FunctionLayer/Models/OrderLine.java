package FunctionLayer.Models;

//OrderLine er stykker i styklisten

public class OrderLine {
    private Material material;
    private int amount;
    private String description;

    public OrderLine(Material material, int amount) {
        this.material = material;
        this.amount = amount;
        this.description = "";
    }

    public OrderLine(Material material, int amount, String description) {
        this.material = material;
        this.amount = amount;
        this.description = description;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
