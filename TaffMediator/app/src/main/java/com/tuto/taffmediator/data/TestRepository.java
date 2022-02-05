package com.tuto.taffmediator.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.tuto.taffmediator.list.ItemViewState;

import java.util.ArrayList;
import java.util.List;

public class TestRepository {

    private final MutableLiveData<List<Item>> itemMutableLiveDataList = new MutableLiveData<>();
    private final List<Item> items = new ArrayList<>();

    public LiveData<List<Item>> getItemMutableLiveDataList() {
        return itemMutableLiveDataList;
    }

    public void addItemMutableLiveDateToList(Item item) {
        items.add(item);
        itemMutableLiveDataList.setValue(items);
    }

    public void onDeleteItemClicked(String name) {
        List<Item> items = itemMutableLiveDataList.getValue();
        if (items == null) return;

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                items.remove(items.get(i));
            }
        }
        itemMutableLiveDataList.setValue(items);
    }

    public LiveData<List<ItemViewState>> getViewStateItemLiveData() {
        return Transformations.map(getItemMutableLiveDataList(), items -> {
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
        });
    }

//        public LiveData<Integer> onTotalshopping () {
//            // TODO MO Utiliser un Transformations.map ici !
//            return Transformations.map(itemMutableLiveDataList, new Function<List<Item>, Integer>() {
//                @Override
//                public Integer apply(List<Item> items) {
//                    Integer totshop =0;
//
//                    for (int i = 0; i < items.size(); i++){
//                        totshop += items.get(i).getTotal();
//                    } return totshop;
//                }
//            });
//    }
}