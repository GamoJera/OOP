package com.example.brgyosaoinformationsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class PersonList extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> id,housenum, name, birthdate, age, gender,status,purok;
    DatabaseHelper DB;
    MyAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);

        DB = new DatabaseHelper(this);
        id = new ArrayList<>();
        housenum = new ArrayList<>();
        name = new ArrayList<>();
        birthdate = new ArrayList<>();
        age = new ArrayList<>();
        gender = new ArrayList<>();
        status = new ArrayList<>();
        purok = new ArrayList<>();
        recyclerView = findViewById(R.id.list);
        adapter = new MyAdapter(this,id,housenum,name,birthdate,age,gender,status,purok);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata() {
        Cursor cursor = DB.getdata();
        if(cursor.getCount() == 0){
            Toast.makeText(PersonList.this,"No Entry Exists",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                housenum.add(cursor.getString(1));
                name.add(cursor.getString(2));
                birthdate.add(cursor.getString(3));
                age.add(cursor.getString(4));
                gender.add(cursor.getString(5));
                status.add(cursor.getString(6));
                purok.add(cursor.getString(7));
            }
        }
    }
}