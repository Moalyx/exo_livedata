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

    public LiveData<List<Item>> getListItemLiveData() {
        return testRepository.getItemMutableLiveDataList();
    }

    public void getItemList(Item item) {

    }

    public void getViewStateItemLiveData(){
        testRepository.getViewStateItemLiveData();
    }

    public LiveData<ListViewState>getListViewState(){
        return testRepository.getListViewState();
    }


//    public LiveData<List<ItemViewState>> getViewStateItemLiveData() {
//        return Transformations.map(testRepository.getItemMutableLiveDataList(), new Function<List<Item>, List<ItemViewState>>() {
//            @Override
//            public List<ItemViewState> apply(List<Item> items) {
//                List<ItemViewState> itemsViewState = new ArrayList<>();
//                for (Item item : items) {
//                    itemsViewState.add(
//                            new ItemViewState(
//                                    "" + item.getUnitPrice(),
//                                    "" + item.getName(),
//                                    "" + item.getQuantity(),
//                                    "" + item.getTotal()
//                            )
//                    );
//                }
//
//                return itemsViewState;
//            }
//        });
//    }

//    public LiveData<ListViewState> getListViewState(){
//        return Transformations.map(getViewStateItemLiveData(), new Function<List<ItemViewState>, ListViewState>() {
//            @Override
//            public ListViewState apply(List<ItemViewState> input) {
//                int totshop =0;
//                for (int i = 0; i < input.size(); i++){
//                    totshop += Integer.parseInt(input.get(i).getTotal());
//                }
//
//                ListViewState listViewState = new ListViewState(
//                        input, ""+ totshop
//                );
//                return listViewState;
//
//            }
//        });
//    }


        public void onDeleteItemClicked (String name){
            testRepository.onDeleteItemClicked(name);
        }

        public String onTotalshopping () {
            return null;
        }

    }
