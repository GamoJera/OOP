package com.example.brgyosaoinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashBoard extends AppCompatActivity {

    Button btnadd,btnview;
    DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        btnadd = (Button) findViewById(R.id.btnreserve);
        btnview = (Button) findViewById(R.id.btnView);

        DB = new DatabaseHelper(this);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openReservation(); }
        });

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openCustomerData(); }
        });
    }

    public void openReservation (){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openCustomerData (){
        Intent intent = new Intent(this, PersonList.class);
        startActivity(intent);
    }

}