package com.tuto.taffmediator.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class TestRepository {

    private final MutableLiveData<String> nameMutableLiveData = new MutableLiveData<>();
    private final MutableLiveData<Integer> quantityMutableLiveData = new MutableLiveData<>(0);
    private final MutableLiveData<List<Item>> itemMutableLiveDataList = new MutableLiveData<>();
    private final List<Item> items = new ArrayList<>();

    public LiveData<String> getNameLiveData() {
        return nameMutableLiveData;
    }

    public LiveData<Integer> getQuantityLiveData() {
        return quantityMutableLiveData;
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



    public void addItemMutableLiveDateToList(Item item) { // ici j'avais oublié de rajouter le parametre Item item mais meme avec le changement je n'ai pas de resultat
        items.add(item);
        itemMutableLiveDataList.setValue(items);
    }

    public void addItemToList(Item item){
        items.add(item);
    }

    public List<Item> getAllItemsList (){
        return items;
    }



//    public void setTotalPriceMutableLiveData(Integer value, Integer value2){
//       value = quantityMutableLiveData.getValue();
//       value2 = unitPriceMutableLiveData.getValue();
//       int sum = value * value2;
//       totalPriceMutableLiveData.setValue(sum);
//    }
}
