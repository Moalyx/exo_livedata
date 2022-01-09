package com.tuto.taffmediator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MainViewModel extends ViewModel {

    private final TestRepository testRepository; //lorque j'ai mis final cela a souligné en rouge
    private final MediatorLiveData<String> mediatorLiveData = new MediatorLiveData();
    private Item item;

//    LiveData<Integer> priceLiveData = testRepository.getPriceLiveData();
//    LiveData<String> nameLiveData = testRepository.getNameLiveData();
//    LiveData<Integer> quantityLiveData = testRepository.getQuantityLiveData();



    public MainViewModel(TestRepository testRepository) {
        this.testRepository = testRepository;

        LiveData<Integer> priceLiveData = testRepository.getUnitPriceLiveData();
        LiveData<String> nameLiveData = testRepository.getNameLiveData();
        LiveData<Integer> quantityLiveData = testRepository.getQuantityLiveData();
        LiveData<Integer> totalPriceLiveData = testRepository.getTotalPriceLiveData();

        mediatorLiveData.addSource(priceLiveData, price -> combine(price, nameLiveData.getValue(), quantityLiveData.getValue(), totalPriceLiveData.getValue()));

        mediatorLiveData.addSource(nameLiveData, name -> combine(priceLiveData.getValue(), name, quantityLiveData.getValue(), totalPriceLiveData.getValue()));

        mediatorLiveData.addSource(quantityLiveData, quantity -> combine(priceLiveData.getValue(), nameLiveData.getValue(), quantity, totalPriceLiveData.getValue()));

        mediatorLiveData.addSource(totalPriceLiveData, totalPrice -> combine(priceLiveData.getValue(), nameLiveData.getValue(), quantityLiveData.getValue(), totalPriceLiveData.getValue()));
    }

    private void combine (Integer price , String name, Integer quantity, Integer totalPrice){

        mediatorLiveData.setValue("Vous avez acheté la quantité de " + quantity + " " + name + " au prix unitaire de " + price + " pour un prix total de " + totalPrice);
        item = new Item (price, name, quantity, totalPrice);
        testRepository.addItemMutableLiveDateToList();
    }

    public LiveData<String> getMessageLiveData(){return mediatorLiveData;}

    public LiveData<List<Item>> getListItemLiveData(){return testRepository.getItemMutableLiveDataList();}

    public void onPriceChanged (int price){
        testRepository.setUnitPriceMutableLiveData(price);
    }

    public void onNameChanged (String name){
        testRepository.setNameMutableLiveData(name);
    }

//    public void onQuantityChanged (Integer quantity){
//        testRepository.setQuantityMutableLiveData(quantity);
//    }

    public void onIncreaseButtonClick(){
        testRepository.setQuantityMutableLiveData(testRepository.getQuantityLiveData().getValue() + 1);
    }

    public void onDecreaseButtonClick(){
        testRepository.setQuantityMutableLiveData(testRepository.getQuantityLiveData().getValue() -1);
    }



//    public void onTotalPriceChanged(){
//
//    }

}
