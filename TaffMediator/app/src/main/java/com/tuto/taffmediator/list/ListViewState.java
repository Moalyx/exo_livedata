package com.tuto.taffmediator.list;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.Objects;

public class ListViewState {

    private final List<ItemViewState> items;

    private final String total;

    public ListViewState(List<ItemViewState> items, String total) {
        this.items = items;
        this.total = total;
    }

    public List<ItemViewState> getItems() {
        return items;
    }

    public String getTotal() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListViewState that = (ListViewState) o;
        return Objects.equals(items, that.items) && Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, total);
    }

    @NonNull
    @Override
    public String toString() {
        return "ListViewState{" +
                "items=" + items +
                ", total='" + total + '\'' +
                '}';
    }
}
