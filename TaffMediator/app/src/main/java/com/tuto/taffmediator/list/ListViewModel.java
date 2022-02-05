package com.tuto.taffmediator.list;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.tuto.taffmediator.data.Item;
import com.tuto.taffmediator.data.TestRepository;

import java.util.ArrayList;
import java.util.List;

public class ListViewModel extends ViewModel {

    private final TestRepository testRepository;


    public ListViewModel(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public LiveData<ListViewState> getListViewState() {
        return Transformations.map(testRepository.getViewStateItemLiveData(), input -> {
            int totshop = 0;
            for (int i = 0; i < input.size(); i++) {
                totshop += Integer.parseInt(input.get(i).getTotal());
            }

            ListViewState listViewState = new ListViewState(
                    input, "" + totshop
            );
            return listViewState;

        });
    }

    public void onDeleteItemClicked(String name) {
        testRepository.onDeleteItemClicked(name);
    }

}
