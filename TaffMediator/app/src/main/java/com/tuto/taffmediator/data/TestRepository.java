package com.tuto.taffmediator.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class TestRepository {

    private final MutableLiveData<String> nameMutableLiveData = new MutableLiveData<>();
    private final MutableLiveData<Integer> quantityMutableLiveData = new MutableLiveData<>(0);
    private final MutableLiveData<List<Item>> itemMutableLiveDataList = new MutableLiveData<>();
    private final MutableLiveData<Integer> priceMutableLiveData = new MutableLiveData<>(0);

    private final List<Item> items = new ArrayList<>();


    //public MediatorLiveData<String> getMediatorLiveData() { return mediatorLiveData;}

    public LiveData<String> getNameLiveData() {
        return nameMutableLiveData;
    }

    public LiveData<Integer> getQuantityLiveData() {
        return quantityMutableLiveData;
    }

    public LiveData<Integer> getPriceLiveData() {
        return priceMutableLiveData;
    }

    public LiveData<List<Item>> getItemMutableLiveDataList() {
        return itemMutableLiveDataList;
    }


    public void setNameMutableLiveData(String value) {
        nameMutableLiveData.setValue(value);
    }

    public void setQuantityMutableLiveData(Integer value) {
        quantityMutableLiveData.setValue(value);
    }
    public void setPriceMutableLiveData(Integer value){
        priceMutableLiveData.setValue(value);
    }

//    public void setMediatorLiveData(String value){
//        mediatorLiveData.setValue(value);
//    }

    public void addItemMutableLiveDateToList(Item item) {
        items.add(item);
        itemMutableLiveDataList.setValue(items);
    }

    public void addItemMutableLiveDateToList2 (List<Item> items) {
        itemMutableLiveDataList.setValue(items);
    }

    public void addItemToList(Item item){
        items.add(item);
    }

    public List<Item> getAllItemsList (){
        return items;
    }
}
