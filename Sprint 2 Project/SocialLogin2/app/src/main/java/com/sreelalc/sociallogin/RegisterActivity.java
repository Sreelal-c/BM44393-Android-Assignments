package com.sreelalc.sociallogin;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    String gender,email1,password1;
    long i;
    Spinner spinner, spinner2, spinner3;

    String day,month,year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        spinner = (Spinner) findViewById(R.id.day);
        spinner2 = (Spinner) findViewById(R.id.month);
        spinner3 = (Spinner) findViewById(R.id.year);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dob_day, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                year = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter<CharSequence> monthAdapter = ArrayAdapter.createFromResource(this,R.array.dob_month,
                android.R.layout.simple_spinner_dropdown_item);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(monthAdapter);
        // Toast.makeText(RegisterActivity.this, spinner2.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    //Toast.makeText(RegisterActivity.this, spinner2.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    day = spinner2.getSelectedItem().toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });


        ArrayAdapter<CharSequence> yearAdapter = ArrayAdapter.createFromResource(this,
                R.array.dob_year,android.R.layout.simple_spinner_dropdown_item);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(yearAdapter);

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                year = spinner3.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.gender_male:
                if (checked)
                    gender=((RadioButton) view).getText().toString();
                    break;
            case R.id.gender_female:
                if (checked)
                    gender=((RadioButton) view).getText().toString();
                    break;
        }
    }

    public void registerUser(View v) {

        //System.out.println("registering user !!!!");

        Database reg = new Database(this);
        SQLiteDatabase db = reg.getWritableDatabase();

        ContentValues mContent = new ContentValues();

        //EditText fname = (EditText) findViewById(R.id.fname);
        //EditText lname = (EditText) findViewById(R.id.lname);
        //EditText pass1 = (EditText) findViewById(R.id.pass1);
        //EditText pass2 = (EditText) findViewById(R.id.pass2);
        //EditText email1 = (EditText) findViewById(R.id.email1);
        //EditText email2 = (EditText) findViewById(R.id.email2);

        String first_name = ((EditText) findViewById(R.id.fname)).getText().toString();
        String last_name = ((EditText) findViewById(R.id.lname)).getText().toString();
        password1 = ((EditText) findViewById(R.id.pass1)).getText().toString();
        email1 = ((EditText) findViewById(R.id.email1)).getText().toString();
        // String password2 = ((EditText) findViewById(R.id.pass2)).getText().toString();
        //String email2 = ((EditText) findViewById(R.id.email2)).getText().toString();



        mContent.put("name", first_name + last_name);
        mContent.put("password", password1);
        mContent.put("email", email1);

        /* if(password1.equals(password2)) {
            mContent.put("password", password1);
        }
        else {
            Toast mToast = Toast.makeText(this, "Password dont match", Toast.LENGTH_SHORT);
            return;
        }
        if(email1.equals(email2))
        mContent.put("email", email1);
        else {
            Toast toast = Toast.makeText(this, "Emails do not match", Toast.LENGTH_SHORT);
            return;
        }

        */
        if(gender.isEmpty()){
            Toast.makeText(RegisterActivity.this,"Gender not Selected", Toast.LENGTH_SHORT);
            return;
        }
        else{
            mContent.put("gender", gender);
        }


        try {
                String dob =  day + month + year;
                mContent.put("dob", dob);
                i = db.insert("tbl_user", "name,email,password,gender,dob", mContent);
                System.out.print("register row = " + i);
        }

        catch (Exception e) {
            e.printStackTrace();
           Toast.makeText(RegisterActivity.this,"Spinner Error occured", Toast.LENGTH_SHORT);
        }

        if(i>0) {
            Toast.makeText(RegisterActivity.this, "Successfully Registered", Toast.LENGTH_SHORT);

            db = reg.getReadableDatabase();
            String[] args = {email1,password1};
            Cursor c = db.query("tbl_user", null, "email =? and password =? ", args, null, null, null);
            c.moveToFirst();
            if (c.getString(2).equals(email1) && c.getString(3).equals(password1)) {

                Intent i = new Intent(this, ProfileActivity.class);
                i.putExtra("userid",c.getString(0));
                startActivity(i);
                finish();
            }

        }

    }
}

