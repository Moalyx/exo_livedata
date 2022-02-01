package com.tuto.taffmediator.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tuto.taffmediator.DI.ViewModelFactory;
import com.tuto.taffmediator.data.Item;
import com.tuto.taffmediator.R;
import com.tuto.taffmediator.main.MainActivity;
import com.tuto.taffmediator.main.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private MyAdapter myAdapter;
    private ListViewModel listViewModel;
    //    List<Item> item = secondViewModel.getListItemLiveData();
//    List<Item> item = listViewModel.getListItemLiveData().getValue();
//    List<Item> items = listViewModel.getItems();
    private List<Item> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        Button returnButton = findViewById(R.id.returnbutton);
        TextView montant = findViewById(R.id.montant);


        final ListViewModel listViewModel = new ViewModelProvider(this, ViewModelFactory.getInstance()).get(ListViewModel.class);

        listViewModel.getViewStateItemLiveData().observe(this, new Observer<ListViewState>() {
            @Override
<<<<<<< HEAD
            public void onChanged(List<ItemViewState> itemsViewState) {
                myAdapter.submitList(itemsViewState);
                ;
=======
            public void onChanged(ListViewState viewState) {
                myAdapter.submitList(viewState.getItems());
                montant.setText(viewState.getTotal());
>>>>>>> 5ee40ec35741207401476939409abc06ab666a30
            }
        });

        myAdapter = new MyAdapter(name -> listViewModel.onDeleteItemClicked(name));
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

<<<<<<< HEAD
        montant.setText(String.valueOf(listViewModel.onTotalshopping()));
=======





>>>>>>> 5ee40ec35741207401476939409abc06ab666a30
    }
}