package com.tutorial.visibility_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

    }

    public void button1_ditekan(View v)
    {
        button1.setVisibility(View.GONE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
//        button2.setVisibility(View.INVISIBLE);
    }

    public void button2_ditekan(View v)
    {
        button2.setVisibility(View.GONE);
        button1.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
    }

    public void button3_ditekan(View v)
    {
        button3.setVisibility(View.GONE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        //button1.setVisibility(View.INVISIBLE);
    }
}
