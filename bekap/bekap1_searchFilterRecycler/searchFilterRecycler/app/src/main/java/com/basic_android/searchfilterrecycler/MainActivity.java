package com.basic_android.searchfilterrecycler;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private ArrayList<ExampleItem> mExampleList;
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createExampleList();
        buildRecyclerView();
        EditText editText = findViewById(R.id.edittext);


        // #################################################
        // ##
        mRecyclerView.setVisibility(View.INVISIBLE);
        editText.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mRecyclerView.setVisibility(View.VISIBLE);
                //filter(s.toString());
                //#########################
                //#############
                editText.addTextChangedListener(new TextWatcher()
                {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after)
                    {
                    }
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }
                    @Override
                    public void afterTextChanged(Editable s) {
                        //mRecyclerView.setVisibility(View.VISIBLE);
                        filter(s.toString());
                    }
                });
                //###############
            }


        });
        // ##################
    }
    private void filter(String text) {
        ArrayList<ExampleItem> filteredList = new ArrayList<>();
        for (ExampleItem item : mExampleList) {
            if (item.getText1().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        mAdapter.filterList(filteredList);
    }
    private void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem( "One"));
        mExampleList.add(new ExampleItem("Two"));
        mExampleList.add(new ExampleItem("Three"));
        mExampleList.add(new ExampleItem("Four"));
        mExampleList.add(new ExampleItem("Five"));
        mExampleList.add(new ExampleItem("Six"));
        mExampleList.add(new ExampleItem("Seven"));
        mExampleList.add(new ExampleItem("Eight"));
        mExampleList.add(new ExampleItem("Nine"));
    }
    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}