package com.tuto.taffmediator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    SecondViewModel secondViewModel;
//    List<Item> item = secondViewModel.getListItemLiveData();
    List<Item> item = secondViewModel.getListItemLiveData().getValue();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);



        myAdapter = new MyAdapter(item,this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}