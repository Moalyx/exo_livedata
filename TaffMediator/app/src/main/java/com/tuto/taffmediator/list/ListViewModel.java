package com.tuto.taffmediator.list;

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
        return Transformations.map(testRepository.getItemListLiveData(), items -> {
            List<ItemViewState> itemViewStates = new ArrayList<>();

            int totalShopping = 0;

            for (int i = 0; i < items.size(); i++) {
                Item item = items.get(i);

                int total = item.getUnitPrice() * item.getQuantity();

                totalShopping += total;

                itemViewStates.add(
                    new ItemViewState(
                        "" + item.getUnitPrice(),
                        "" + item.getName(),
                        "" + item.getQuantity(),
                        "" + total
                    )
                );
            }

            return new ListViewState(itemViewStates, "" + totalShopping);

        });
    }

    public void onDeleteItemClicked(String name) {
        testRepository.deleteItem(name);
    }

}
