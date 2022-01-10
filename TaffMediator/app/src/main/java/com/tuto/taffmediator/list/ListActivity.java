package com.tuto.taffmediator.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.tuto.taffmediator.data.Item;
import com.tuto.taffmediator.R;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    ListViewModel listViewModel;
//    List<Item> item = secondViewModel.getListItemLiveData();
    List<Item> item = listViewModel.getListItemLiveData().getValue();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);



        myAdapter = new MyAdapter(item,this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}