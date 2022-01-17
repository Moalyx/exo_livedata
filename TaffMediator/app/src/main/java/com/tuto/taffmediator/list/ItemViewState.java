package com.tuto.taffmediator.list;

import java.util.Objects;

public class ItemViewState {

    private int unitPrice;
    private String name;
    private int quantity;
    private int total;

    public ItemViewState (int unitPrice, String name, int quantity, int total){
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

    public int getQuantity() {
        return quantity;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemViewState that = (ItemViewState) o;
        return unitPrice == that.unitPrice && quantity == that.quantity && total == that.total && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitPrice, name, quantity, total);
    }
}
