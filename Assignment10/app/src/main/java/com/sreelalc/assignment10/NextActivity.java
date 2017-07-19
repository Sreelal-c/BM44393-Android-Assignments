package com.sreelalc.assignment10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        TextView t = (TextView) findViewById(R.id.content);
        String m =  getIntent().getExtras().getString("message");
        t.setText(m);

    }


}
