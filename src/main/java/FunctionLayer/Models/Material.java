package FunctionLayer.Models;

//Material er materialer i materialelisten

public class Material {
    private int materialId;
    private String name;
    private String unit;
    private double price;
    private int width;
    private int height;
    private int length;

    public Material() {
    }

    public Material(String name, String unit, double price) {
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    public Material(String name, String unit, double price, int width, int length) {
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.width = width;
        this.length = length;
    }

    public Material(String name, String unit, double price, int width, int height, int length) {
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
