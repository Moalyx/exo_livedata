package com.tuto.taffmediator.data;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.tuto.taffmediator.list.ItemViewState;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestRepository {

    private final MutableLiveData<List<Item>> itemMutableLiveDataList = new MutableLiveData<>();
    private final List<Item> items = new ArrayList<>();

    public LiveData<List<Item>> getItemListLiveData() {
        return itemMutableLiveDataList;
    }

    public void addItem(Item item) {
        items.add(item);
        itemMutableLiveDataList.setValue(items);
    }

    public void deleteItem(String name) {
        for (Iterator<Item> iterator = items.iterator(); iterator.hasNext(); ) {
            Item item = iterator.next();

            if (item.getName().equals(name)) {
                iterator.remove();
            }
        }

<<<<<<< HEAD
    public LiveData<List<ItemViewState>> getViewStateItemLiveData() {
        return Transformations.map(getItemMutableLiveDataList(), new Function<List<Item>, List<ItemViewState>>() {
            @Override
            public List<ItemViewState> apply(List<Item> items) {
                List<ItemViewState> itemsViewState = new ArrayList<>();
                for (Item item : items) {
                    itemsViewState.add(
                            new ItemViewState(
                                    "" + item.getUnitPrice(),
                                    "" + item.getName(),
                                    "" + item.getQuantity(),
                                    "" + item.getTotal()
                            )
                    );
                }
//
                return itemsViewState;
            }
        });
=======
        itemMutableLiveDataList.setValue(items);
>>>>>>> 93e10fbc1a0ce684268ed5f58a91a66fe1ea1ea1
    }
}