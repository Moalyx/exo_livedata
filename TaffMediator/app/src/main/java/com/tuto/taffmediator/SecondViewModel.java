package com.tuto.taffmediator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class SecondViewModel extends ViewModel {

    private TestRepository testRepository;


    public SecondViewModel(TestRepository testRepository){
        this.testRepository = testRepository;
    }

    public LiveData<List<Item>> getListItemLiveData(){return testRepository.getItemMutableLiveDataList();}


}
