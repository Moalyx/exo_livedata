package com.tuto.taffmediator.main;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tuto.taffmediator.data.Item;
import com.tuto.taffmediator.data.TestRepository;

import java.util.List;

public class MainViewModel extends ViewModel {

    private final TestRepository testRepository; //lorque j'ai mis final cela a souligné en rouge
    private final MediatorLiveData<String> mediatorLiveData = new MediatorLiveData<>();

//    LiveData<Integer> priceLiveData = testRepository.getPriceLiveData();
//    LiveData<String> nameLiveData = testRepository.getNameLiveData();
//    LiveData<Integer> quantityLiveData = testRepository.getQuantityLiveData();

    private final MutableLiveData<Integer> priceLiveData = new MutableLiveData<>(0);

    public MainViewModel(TestRepository testRepository) { // TODO MO décommente :p
        this.testRepository = testRepository;
        

        LiveData<String> nameLiveData = this.testRepository.getNameLiveData();
        LiveData<Integer> quantityLiveData = this.testRepository.getQuantityLiveData();

        mediatorLiveData.addSource(priceLiveData, price -> combine(price, nameLiveData.getValue(), quantityLiveData.getValue()));

        mediatorLiveData.addSource(nameLiveData, name -> combine(priceLiveData.getValue(), name, quantityLiveData.getValue()));

        mediatorLiveData.addSource(quantityLiveData, quantity -> combine(priceLiveData.getValue(), nameLiveData.getValue(), quantity));
    }

    private void combine(Integer price, String name, Integer quantity) {

        mediatorLiveData.setValue("Vous avez acheté la quantité de " + quantity + " " + name + " au prix unitaire de " + price + " pour un prix total de " + quantity * price);
        Item item = new Item(price, name, quantity, quantity * price);
        testRepository.addItemMutableLiveDateToList(item);
        testRepository.addItemToList(item);

    }

    public List<Item> getItems(){return testRepository.getAllItemsList();}

    public LiveData<String> getMessageLiveData() {
        return mediatorLiveData;
    }

    public LiveData<List<Item>> getListItemLiveData() {
        return testRepository.getItemMutableLiveDataList();
    }

    public void onPriceChanged(int price) {
        priceLiveData.setValue(price);
    }

    public void onNameChanged(String name) {
        testRepository.setNameMutableLiveData(name);
    }

//    public void onQuantityChanged (Integer quantity){
//        testRepository.setQuantityMutableLiveData(quantity);
//    }

    public void onIncreaseButtonClick() {
        testRepository.setQuantityMutableLiveData(testRepository.getQuantityLiveData().getValue() + 1);
    }

    public void onDecreaseButtonClick() {
        if (testRepository.getQuantityLiveData().getValue() < 0){

        }
        testRepository.setQuantityMutableLiveData(testRepository.getQuantityLiveData().getValue() - 1);
    }

    public int getQuantity(){
        return testRepository.getQuantityLiveData().getValue();
    }




//    public void onTotalPriceChanged(){
//
//    }

}
