package org.katas.refactoring;

public class LineItem {
    private String desc;
    private double price;
    private int quantity;

    public LineItem(String desc, double price, int quantity) {
        this.desc = desc;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDesc() {
        return desc;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    double totalAmount() {
        return price * quantity;
    }
}