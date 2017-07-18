package com.sreelalc.assignment4_framelayout;

import android.sax.RootElement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout panel1 = (RelativeLayout) findViewById(R.id.panel1);
        RelativeLayout panel2 = (RelativeLayout) findViewById(R.id.panel2);

        panel2.setVisibility(View.GONE);
        panel1.setVisibility(View.VISIBLE);
    }

    public void step1Clicked(View v) {
       RelativeLayout  panel1 = (RelativeLayout) findViewById(R.id.panel1);
       RelativeLayout panel2 = (RelativeLayout) findViewById(R.id.panel2);

        panel2.setVisibility(View.GONE);
        panel1.setVisibility(View.VISIBLE);


    }

    public void  step2Clicked(View v) {
        RelativeLayout panel1 = (RelativeLayout) findViewById(R.id.panel1);
        RelativeLayout panel2 = (RelativeLayout) findViewById(R.id.panel2);

        panel1.setVisibility(View.GONE);
        panel2.setVisibility(View.VISIBLE);
    }

}
