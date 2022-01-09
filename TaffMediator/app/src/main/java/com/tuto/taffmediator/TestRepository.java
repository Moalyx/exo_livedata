package com.tuto.taffmediator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class TestRepository {

    private Item item;
    private final MutableLiveData<Integer> unitPriceMutableLiveData = new MutableLiveData<>(0);
    private final MutableLiveData<String>  nameMutableLiveData = new MutableLiveData<>();
    private final MutableLiveData<Integer> quantityMutableLiveData = new MutableLiveData<>(0);
    private final MutableLiveData<Integer> totalPriceMutableLiveData = new MutableLiveData<>(unitPriceMutableLiveData.getValue() * quantityMutableLiveData.getValue());
    private final MutableLiveData<List<Item>> itemMutableLiveDataList = new MutableLiveData<>();
    private final List<Item> items = new ArrayList<>();


    public LiveData<Integer> getUnitPriceLiveData(){return unitPriceMutableLiveData;}
    public LiveData<String> getNameLiveData(){return nameMutableLiveData;}
    public LiveData<Integer> getQuantityLiveData(){return quantityMutableLiveData;}
    public LiveData<Integer> getTotalPriceLiveData(){return totalPriceMutableLiveData;}
    public LiveData<List<Item>> getItemMutableLiveDataList(){return itemMutableLiveDataList;}

    public void setUnitPriceMutableLiveData(Integer value){
        unitPriceMutableLiveData.setValue(value);
    }

    public void setNameMutableLiveData(String value){
        nameMutableLiveData.setValue(value);
    }

    public void setQuantityMutableLiveData(Integer value){
        quantityMutableLiveData.setValue(value);
    }

    public void addItemMutableLiveDateToList(){
        items.add(item);
        itemMutableLiveDataList.setValue(items);

    }

//    public void setTotalPriceMutableLiveData(Integer value, Integer value2){
//       value = quantityMutableLiveData.getValue();
//       value2 = unitPriceMutableLiveData.getValue();
//       int sum = value * value2;
//       totalPriceMutableLiveData.setValue(sum);
//    }
}
