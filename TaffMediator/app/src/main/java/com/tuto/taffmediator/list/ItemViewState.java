package com.tuto.taffmediator.list;

import java.util.Objects;

public class ItemViewState {

    private final String unitPrice;
    private final String name;
    private final String quantity;
    private final String total;

    public ItemViewState(String unitPrice, String name, String quantity, String total) {
        this.unitPrice = unitPrice;
        this.name = name;
        this.quantity = quantity;
        this.total = total;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getTotal() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemViewState that = (ItemViewState) o;
        return unitPrice.equals(that.unitPrice) && name.equals(that.name) && quantity.equals(that.quantity) && total.equals(that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitPrice, name, quantity, total);
    }
}
