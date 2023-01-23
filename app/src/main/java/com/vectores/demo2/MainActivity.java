package com.vectores.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    private Spinner spinnerMain;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerMain = (Spinner)findViewById(R.id.spinnerMainActivity);
        String operaciones[] = {"Operaciones con 1 vector","Operaciones con 2 vectores", "Operaciones con 3 vectores", "Más operaciones"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_main, operaciones);
        spinnerMain.setAdapter(adapter);
    }
    public void changeActivityButton(View view){
        String operacion = spinnerMain.getSelectedItem().toString();
        Intent nextActivity = null;
        if(operacion == "Operaciones con 1 vector"){
            nextActivity = new Intent(this, Operaciones2Vectores.class);
        }
        if(operacion == "Operaciones con 2 vectores"){
            nextActivity = new Intent(this, Operaciones2Vectores.class);
        }
        if(operacion == "Operaciones con 3 vectores"){
            nextActivity = new Intent(this, Operaciones2Vectores.class);
        }

        startActivity(nextActivity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menuApp){
        getMenuInflater().inflate(R.menu.menu_main_activity, menuApp);
        return true;
    }
}
