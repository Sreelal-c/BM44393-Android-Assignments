package com.sreelalc.sociallogin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sreelal on 24/7/17.
 */

public class Database extends SQLiteOpenHelper {


    public Database(Context context) {
        super(context, "db", null, 7);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table tbl_user(id integer primary key autoincrement,name TEXT, email " +
                "TEXT, " +
                "password TEXT, dob TEXT , gender" +
                " TEXT, picture BLOB)");
        //db.execSQL("Create table tbl_picture(picture BLOB)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("Drop table if exists tbl_user");
        //db.execSQL("Drop table if exists tbl_picture");
        onCreate(db);
    }

}
