package com.tuto.taffmediator.data;

public class Item {

    private final int unitPrice;
    private String name;
    private final int quantity;
    private final int total;

    public Item(int unitPrice, String name, int quantity, int total) {
        this.unitPrice = unitPrice;
        this.name = name;
        this.quantity = quantity;
        this.total = total;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotal() {
        return total;
    }

}
