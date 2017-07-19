package com.sreelalc.assignment9;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button1Clicked(View v) {


        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        mBuilder.setTitle("Button Clicked");
        mBuilder.setMessage("Alert with 1 button");
        mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, " Closed!", Toast.LENGTH_SHORT).show();
            }
        });

           /* mBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            */

        AlertDialog mAlert = mBuilder.create();
        mAlert.show();


    }

    public void button2Clicked(View v) {


        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        mBuilder.setTitle("Button Clicked");
        mBuilder.setMessage("Alert with 2 button");
        mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, " Closed!", Toast.LENGTH_SHORT).show();
            }
        });

        mBuilder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });


        AlertDialog mAlert = mBuilder.create();
        mAlert.show();


    }

    public void button3Clicked(View v) {


        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        mBuilder.setTitle("Button Clicked");
        mBuilder.setMessage("Alert with 3 button");
        mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, " Closed!", Toast.LENGTH_SHORT).show();
            }
        });

        mBuilder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        mBuilder.setNeutralButton( "No Action", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {

            }});

        AlertDialog mAlert = mBuilder.create();
        mAlert.show();


    }




}
