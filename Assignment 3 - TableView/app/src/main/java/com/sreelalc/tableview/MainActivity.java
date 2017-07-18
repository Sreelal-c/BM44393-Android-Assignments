package com.sreelalc.tableview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClikced(View v) {
        TextView text  = (TextView) findViewById(R.id.textView1);
        text.setText("Hello Baabtra");
    }
}
