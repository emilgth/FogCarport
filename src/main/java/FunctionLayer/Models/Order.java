package FunctionLayer.Models;

import java.util.ArrayList;

public class Order {
    private int orderId;
    private User user;
    private String status;
    private ArrayList<OrderLine> orderLineList;
    private double price;
    private int roofId;
    private int angle;
    private int length;
    private int width;
    private int height;
    private int shedLength;
    private int shedWidth;

    public Order() {
    }

    public Order(User user, String status, int roofId, int angle, int length, int width, int height) {
        this.orderId = 0;
        this.user = user;
        this.status = status;
        this.orderLineList = new ArrayList<>();
        this.price = 0;
        this.roofId = roofId;
        this.angle = angle;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    private int priceCalc(ArrayList<OrderLine> orderLineList, ArrayList<Material> materialList) {

        int total = 0;

        for (OrderLine o : orderLineList) {
            total += o.getMaterial().getPrice() * o.getAmount();
        }
        return total;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<OrderLine> getOrderLineList() {
        return orderLineList;
    }

    public void setOrderLineList(ArrayList<OrderLine> orderLineList) {
        this.orderLineList = orderLineList;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRoofId() {
        return roofId;
    }

    public void setRoofId(int roofId) {
        this.roofId = roofId;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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

    public int getShedLength() {
        return shedLength;
    }

    public void setShedLength(int shedLength) {
        this.shedLength = shedLength;
    }

    public int getShedWidth() {
        return shedWidth;
    }

    public void setShedWidth(int shedWidth) {
        this.shedWidth = shedWidth;
    }
}