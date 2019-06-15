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
import android.widget.TextView;

import com.bit.contactsearchtestproject.R;
import com.bit.contactsearchtestproject.repo.local.database.model.SearchRecordData;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private Spinner spinner;
    private View recordLayout;

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
        spinner = findViewById(R.id.spinner);
        recordLayout = findViewById(R.id.record_layout);

    }

    private void addObserver() {
        mainViewModel.getListAccountsData().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable final List<String> strings) {
                activateSpinner(strings);
            }
        });
        mainViewModel.getSearchResultData().observe(this, new Observer<SearchRecordData>() {
            @Override
            public void onChanged(@Nullable final SearchRecordData searchRecordData) {
                if (searchRecordData == null) {
                    findViewById(R.id.tv_no_record).setVisibility(View.VISIBLE);
                    recordLayout.setVisibility(View.GONE);
                } else {
                    setValueRecordLayout(searchRecordData);
                }
            }
        });

    }


    private void activateSpinner(List<String> list) {
        list.add(0, "Please Select Contact Id");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
                if (position == 0) {
                    findViewById(R.id.tv_no_record).setVisibility(View.GONE);
                    recordLayout.setVisibility(View.GONE);
                    return;
                }
                mainViewModel.searchContact(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(final AdapterView<?> parent) {

            }
        });
    }

    private void setValueRecordLayout(SearchRecordData searchRecordData) {
        ((TextView) findViewById(R.id.tv_staging)).setText(String.valueOf(searchRecordData.getStaging()));
        ((TextView) findViewById(R.id.tv_status)).setText(String.valueOf(searchRecordData.getStatus()));
        ((TextView) findViewById(R.id.tv_context)).setText(searchRecordData.getContext());
        ((TextView) findViewById(R.id.tv_user_id)).setText(searchRecordData.getUserId());
        findViewById(R.id.tv_no_record).setVisibility(View.GONE);
        recordLayout.setVisibility(View.VISIBLE);
    }

}
