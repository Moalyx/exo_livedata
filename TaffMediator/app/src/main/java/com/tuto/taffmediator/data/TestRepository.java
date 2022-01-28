package com.tuto.taffmediator.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class TestRepository {

    private final MutableLiveData<List<Item>> itemMutableLiveDataList = new MutableLiveData<>();
    private final List<Item> items = new ArrayList<>();

    public LiveData<List<Item>> getItemMutableLiveDataList() {
        return itemMutableLiveDataList;
    }

    public void addItemMutableLiveDateToList(Item item) {
        items.add(item);
        itemMutableLiveDataList.setValue(items);
    }
    public void onDeleteItemClicked(String name){
        List<Item> items = itemMutableLiveDataList.getValue();
        if (items == null) return;

        for (int i = 0 ; i < items.size(); i++){
            if (items.get(i).getName().equals(name)){
                items.remove(items.get(i));
            }
        }
        itemMutableLiveDataList.setValue(items);
    }

    public int onTotalshopping(){
        List<Item> items = itemMutableLiveDataList.getValue();

        int totshop = 0;

        for (int i =0 ; i < items.size(); i ++){
            totshop += items.get(i).getTotal();
        }
        return totshop;

    }




}
