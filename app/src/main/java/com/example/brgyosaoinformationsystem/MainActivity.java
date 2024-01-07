package com.example.brgyosaoinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    EditText ehouse,ename,ebirthdate,eage,egender,estatus,epurok;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        ehouse = (EditText)findViewById(R.id.ehousenum);
        ename = (EditText)findViewById(R.id.ename);
        ebirthdate = (EditText)findViewById(R.id.ebirthdate);
        eage = (EditText)findViewById(R.id.eage);
        egender = (EditText)findViewById(R.id.egender);
        estatus = (EditText)findViewById(R.id.estatus);
        epurok = (EditText)findViewById(R.id.epurok);
        btnSave = (Button) findViewById(R.id.btnsave);
        AddData();

    }

    public void AddData(){
        btnSave = (Button) findViewById(R.id.btnsave);
        btnSave.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                String txtHousenum = ehouse.getText().toString();
                String txtName = ename.getText().toString();
                String txtBirthdate = ebirthdate.getText().toString();
                String txtAge = eage.getText().toString();
                String txtGender = egender.getText().toString();
                String txtStatus = estatus.getText().toString();
                String txtPurok = epurok.getText().toString();

                boolean isInserted =  myDb.insertData(txtHousenum,txtName,txtBirthdate,txtAge,txtGender,txtStatus,txtPurok);
                if(isInserted =  true){
                    Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}