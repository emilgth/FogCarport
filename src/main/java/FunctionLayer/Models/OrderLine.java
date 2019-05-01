package FunctionLayer.Models;

//OrderLine er stykker i styklisten

public class OrderLine {
    private int materialId;
    private int amount;
    private String description;

    public OrderLine(int materialId, int amount) {
        this.materialId = materialId;
        this.amount = amount;
        this.description = "";
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
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
