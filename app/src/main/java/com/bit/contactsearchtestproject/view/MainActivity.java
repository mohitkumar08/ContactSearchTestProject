package com.bit.contactsearchtestproject.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProvider.AndroidViewModelFactory;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.bit.contactsearchtestproject.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this, new AndroidViewModelFactory(getApplication())).get(MainViewModel.class);
        initView();
        addObserver();

        mainViewModel.getAllAccounts();
    }

    private void initView() {
        spinner = (Spinner) findViewById(R.id.spinner);
    }

    private void addObserver() {
        mainViewModel.getListAccountsData().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable final List<String> strings) {
                activateSpinner(strings);
            }
        });

    }


    private void activateSpinner(List<String> list) {
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {

            }

            @Override
            public void onNothingSelected(final AdapterView<?> parent) {

            }
        });
    }

}
