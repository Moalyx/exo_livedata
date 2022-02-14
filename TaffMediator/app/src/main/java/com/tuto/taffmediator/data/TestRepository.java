package com.tuto.taffmediator.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestRepository {

    private final MutableLiveData<List<Item>> itemMutableLiveDataList = new MutableLiveData<>();
    private final List<Item> items = new ArrayList<>();

    public LiveData<List<Item>> getItemListLiveData() {
        return itemMutableLiveDataList;
    }

    public void addItem(Item item) {
        items.add(item);
        itemMutableLiveDataList.setValue(items);
    }

    public void deleteItem(String name) {
        for (Iterator<Item> iterator = items.iterator(); iterator.hasNext(); ) {
            Item item = iterator.next();

            if (item.getName().equals(name)) {
                iterator.remove();
            }
        }
        itemMutableLiveDataList.setValue(items);
    }
}