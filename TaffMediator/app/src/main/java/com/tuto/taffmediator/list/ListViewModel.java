package com.tuto.taffmediator.list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.tuto.taffmediator.data.Item;
import com.tuto.taffmediator.data.TestRepository;

import java.util.List;

public class ListViewModel extends ViewModel {

    private final TestRepository testRepository;


    public ListViewModel(TestRepository testRepository){
        this.testRepository = testRepository;
    }

    public LiveData<List<Item>> getListItemLiveData(){return testRepository.getItemMutableLiveDataList();}


}
