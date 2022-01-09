package com.tuto.taffmediator;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        EditText name = findViewById(R.id.itemname);
        EditText price = findViewById(R.id.itemprice);
        Button minus =findViewById(R.id.buttonminus);
        Button plus = findViewById(R.id.buttonplus);
        TextView messageText = findViewById(R.id.message);
        Button addButton =findViewById(R.id.addbutton);

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mViewModel.onNameChanged(s.toString());
            }
        });

        price.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mViewModel.onPriceChanged(Integer.parseInt(s.toString()));
            }
        });

        minus.setOnClickListener(view -> mViewModel.onDecreaseButtonClick());

        plus.setOnClickListener(view -> mViewModel.onIncreaseButtonClick());

        mViewModel.getMessageLiveData().observe(this, messageText::setText);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });


    }
}