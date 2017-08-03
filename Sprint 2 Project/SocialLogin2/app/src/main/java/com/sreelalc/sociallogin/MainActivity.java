package com.sreelalc.sociallogin;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void registerClicked(View v) {
        Intent i = new Intent(this,RegisterActivity.class);
        startActivity(i);
    }

    boolean loginError = false;

    public void loginClicked(View v){
        //System.out.print("hello ............ Working");
        String email =  ((EditText) findViewById(R.id.email1)).getText().toString();
        String  password = ((EditText) findViewById(R.id.password)).getText().toString();
        TextView errorText = (TextView) findViewById(R.id.error);
        String args[] = {email,password};
        try {
            Database reg = new Database(this);
            SQLiteDatabase db = reg.getReadableDatabase();
            Cursor c = db.query("tbl_user", null, "email =? and password =? ", args, null, null, null);
            c.moveToFirst();
                if (c.getString(2).equals(email) && c.getString(3).equals(password)) {
                    errorText.setVisibility(View.GONE);
                    loginError = false;
                    String id = c.getString(0);
                    Intent i = new Intent(this, ProfileActivity.class);
                    i.putExtra("userid", id);
                    startActivity(i);
                }

                else loginError  = true;
            if(loginError) {
                errorText.setVisibility(View.VISIBLE);

            }
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this,"Error occured", Toast.LENGTH_SHORT);
        }
    }
}
