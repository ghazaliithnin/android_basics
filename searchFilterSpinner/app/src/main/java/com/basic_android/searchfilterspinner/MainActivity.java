// taken from
// http://android.devise.space/searchable-spinner-with-search-box-example-in-android/

package com.basic_android.searchfilterspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Context mContext;
    private ArrayList<String> arrayList = new ArrayList<>();
    private SearchableSpinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        AddDataToArrayList();
        findViews();
    }

    private void AddDataToArrayList() {
        arrayList.add("Aprilia India");
        arrayList.add("Bajaj");
        arrayList.add("Benelli India");
        arrayList.add("Big Dog Motorcycles");
        arrayList.add("BMW India");
        arrayList.add("Ducati India");
        arrayList.add("Harley-Davidson India");
        arrayList.add("Hero Moto Corp");
        arrayList.add("Honda India");
        arrayList.add("Hysoung India");
        arrayList.add("Indian Motocycle Manufacturing Company");
        arrayList.add("Kawasaki India");
        arrayList.add("Kinetic");
        arrayList.add("KTM India ");
        arrayList.add("Mahindra");
        arrayList.add("Moto Guzzi India");
        arrayList.add("MV Agusta India ");
        arrayList.add("Norton India");
        arrayList.add("Royal Enfield");
        arrayList.add("Suzuki India");
        arrayList.add("Triumph India");
        arrayList.add("TVS");
        arrayList.add("UM Motors");
        arrayList.add("Vespa India");
        arrayList.add("Vibgyor Vehicles");
        arrayList.add("Yamaha India");
        arrayList.add("Jawa India");
    }
    private void findViews()
    {
        spinner = (SearchableSpinner) findViewById(R.id.spinner);
        //For set Title to Spinner
        spinner.setTitle("Select Company");
        setDataToAdapter(arrayList);
    }

    private void setDataToAdapter(ArrayList<String> arrayList)
    {
        // Creating ArrayAdapter using the string array and default spinner layout
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, arrayList);
        // Specify layout to be used when list of choices appears
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Applying the adapter to our spinner
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedItemText = parent.getItemAtPosition(position).toString();
        Toast.makeText(mContext, " You select >> " + selectedItemText, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}