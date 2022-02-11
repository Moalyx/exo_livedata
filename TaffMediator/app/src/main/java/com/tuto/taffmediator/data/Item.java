package com.tuto.taffmediator.data;

public class Item {

    private final int unitPrice;
    private String name;
    private final int quantity;

    public Item(int unitPrice, String name, int quantity) {
        this.unitPrice = unitPrice;
        this.name = name;
        this.quantity = quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public String getName() {
        return name;
    }

    // TODO NINO Immutability
    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

}
