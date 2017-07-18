package com.sreelalc.assignment6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void onButtonClicked(View v) {
        EditText content = (EditText) findViewById(R.id.content);
        TextView dispaly = (TextView) findViewById(R.id.display);
        Button send = (Button) findViewById(R.id.button);
        String m = content.getText().toString();
        dispaly.setText(m);

    }

}
