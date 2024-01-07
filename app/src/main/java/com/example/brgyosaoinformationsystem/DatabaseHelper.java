package com.example.brgyosaoinformationsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "osaoInfo";

    public static String TABLE_NAME = "person";
    public static final String COL_1 = "id";
    public static final String COL_2 = "housenum";
    public static final String COL_3 = "name";
    public static final String COL_4 = "birthdate";
    public static final String COL_5 = "age";
    public static final String COL_6 = "gender";
    public static final String COL_7 = "status";

    public static final String COL_8 = "purok";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME +"(" +
                "id integer primary key autoincrement," +
                "housenum varchar NOT NULL," +
                "name varchar NOT NULL," +
                "birthdate varchar NOT NULL," +
                "age varchar NOT NULL," +
                "gender varchar NOT NULL," +
                "status varchar NOT NULL," +
                "purok varchar NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int ii) {
        db.execSQL("drop table if exists " + DATABASE_NAME);
        onCreate(db);
    }

    public boolean insertData(String housenum, String name ,String birthdate,String age, String gender , String status , String purok){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =  new ContentValues();
        contentValues.put(COL_2, housenum);
        contentValues.put(COL_3, name);
        contentValues.put(COL_4, birthdate);
        contentValues.put(COL_5, age);
        contentValues.put(COL_6, gender);
        contentValues.put(COL_7, status);
        contentValues.put(COL_8, purok);

        Long result = db.insert(TABLE_NAME,null,contentValues);

        if(result == -1)
            return false;
        else
            return true;

    }
    public Cursor getdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+ TABLE_NAME,null );
        return res;
    }

}
