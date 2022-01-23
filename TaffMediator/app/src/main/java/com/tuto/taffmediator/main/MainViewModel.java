package com.tuto.taffmediator.main;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.tuto.taffmediator.data.Item;
import com.tuto.taffmediator.data.TestRepository;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    private final TestRepository testRepository;
    private final MediatorLiveData<MainViewState> mediatorLiveData = new MediatorLiveData<>();

    private Item item;
    private List<Item> items = new ArrayList<>();

    public MainViewModel(TestRepository testRepository) { // TODO MO décommente :p
        this.testRepository = testRepository;

        LiveData<String> nameLiveData = this.testRepository.getNameLiveData();
        LiveData<Integer> quantityLiveData = this.testRepository.getQuantityLiveData();
        LiveData<Integer> priceLiveData = this.testRepository.getPriceLiveData();


        mediatorLiveData.addSource(priceLiveData, new Observer<Integer>() {
            @Override
            public void onChanged(Integer price) {
                MainViewModel.this.combine(price, nameLiveData.getValue(), quantityLiveData.getValue());
            }
        });

        mediatorLiveData.addSource(nameLiveData, name -> combine(priceLiveData.getValue(), name, quantityLiveData.getValue()));

        mediatorLiveData.addSource(quantityLiveData, quantity -> combine(priceLiveData.getValue(), nameLiveData.getValue(), quantity));
    }

    private void combine(Integer price, String name, Integer quantity) {

        String sentence = "Vous avez acheté la quantité de " + quantity + " " + name + " au prix unitaire de " + price + " pour un prix total de " + quantity * price;

        mediatorLiveData.setValue(new MainViewState(sentence));
//        item = new Item(price, name, quantity, quantity * price);
//        items.add(item);
//        testRepository.addItemMutableLiveDateToList(item);
    }

    public void addItemtoList(Integer price, String name, Integer quant, Integer total){
        item = new Item(price, name, quant, total );
        testRepository.addItemMutableLiveDateToList(item);
    }

    public List<Item> getItems(){return testRepository.getAllItemsList();}

    public LiveData<MainViewState> getMessageLiveData() {
        return mediatorLiveData;
    }

    public LiveData<List<Item>> getListItemLiveData() {
        return testRepository.getItemMutableLiveDataList();
    }

    public void onPriceChanged(int price) {
        testRepository.setPriceMutableLiveData(price);
    }

    public void onNameChanged(String name) {
        testRepository.setNameMutableLiveData(name);
    }

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

    public int getPrice(){return testRepository.getPriceLiveData().getValue();}

    public String getName(){return testRepository.getNameLiveData().getValue();}



}
