package com.tuto.taffmediator.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.tuto.taffmediator.DI.ViewModelFactory;
import com.tuto.taffmediator.R;
import com.tuto.taffmediator.main.MainActivity;


public class ListActivity extends AppCompatActivity {

    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        Button returnButton = findViewById(R.id.returnbutton);
        TextView montant = findViewById(R.id.montant);


        final ListViewModel listViewModel = new ViewModelProvider(this, ViewModelFactory.getInstance()).get(ListViewModel.class);

        listViewModel.getListViewState().observe(this, new Observer<ListViewState>() {
            @Override
            public void onChanged(ListViewState listViewState) {
                myAdapter.submitList(listViewState.getItems());
                montant.setText(listViewState.getTotal());
            }
        });

        myAdapter = new MyAdapter(new OnItemClickedListener() {
            @Override
            public void onDeleteItemClicked(String name) {
                listViewModel.onDeleteItemClicked(name);
            }
        });
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        returnButton.setOnClickListener(view -> {
            Intent intent = new Intent(ListActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}





