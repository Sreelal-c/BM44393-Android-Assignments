package com.sreelalc.sociallogin;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    ImageView imageView;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageView = (ImageView) findViewById(R.id.imageView);
        uid = getIntent().getExtras().getString("userid");


        Database reg = new Database(this);
        SQLiteDatabase db = reg.getReadableDatabase();
        try {
            // tablename, coloumn, where conditin, where argument
            Cursor c = db.query("tbl_user", new String[] {"picture"}, "id=?", new String[] {uid},
                    null,null,null);
            c.moveToFirst();
            byte[] b = c.getBlob(0);
            Bitmap bit = BitmapFactory.decodeByteArray(b, 0,b.length);
            imageView.setImageBitmap(bit);
            db.close();

        } catch (Exception e) {
            Toast.makeText(this, "DB Error or Image not set", Toast.LENGTH_SHORT).show();
            e.printStackTrace();

        }
    }

    public void imageClicked(View v){
        Intent i = new Intent(this, PhotoActivity.class);
        i.putExtra("userid",uid);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                finish();
                break;
            default:
                ;
        }
            return super.onOptionsItemSelected(item);

    }

}
