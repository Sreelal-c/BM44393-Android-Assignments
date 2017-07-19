package com.sreelalc.assignment10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitClicked(View v) {
        EditText content = (EditText) findViewById(R.id.editText);
        String msg= content.getText().toString();
        Intent i = new Intent(this, NextActivity.class);
        i.putExtra("message",msg);
        startActivity(i);
    }
}
