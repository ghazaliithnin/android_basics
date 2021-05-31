package com.basic_android.searchfilterrecycler;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private ArrayList<ExampleItem> mExampleList;
    //private RecyclerView mRecyclerView;
    static RecyclerView mRecyclerView;
    static EditText mEditText;
    static TextView mTextView2;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    static MainActivity mMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createExampleList();
        buildRecyclerView();

        mEditText = findViewById(R.id.edittext);
        mTextView2 = findViewById(R.id.textView2);

        // Initizialization to to change the mRecyclerView position to be below edittext
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mRecyclerView.getLayoutParams();

        // #################################################
        // ##
        mRecyclerView.setVisibility(View.INVISIBLE);

        // Upon pressing textView2, start the search filter function
        // The textView2 will be replaced by edittext by changing both setVisibility
        mTextView2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public  void onClick(View v)
            {
                mEditText.setVisibility(View.VISIBLE);
                mTextView2.setVisibility(View.INVISIBLE);

                mRecyclerView.setVisibility(View.VISIBLE); // try 31 may 21
                // Change the recyclerView position to be below edittext
                params.addRule(RelativeLayout.BELOW, R.id.edittext); // try 31 may 21
            }
        });


        // #################################################################
        // # edittext search filter
        mEditText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
            }
            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
        //###############


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
    private void createExampleList()
    {
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
        //mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new ExampleAdapter(mExampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}