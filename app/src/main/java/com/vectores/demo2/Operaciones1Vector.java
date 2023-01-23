package com.vectores.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class Operaciones1Vector extends AppCompatActivity {
    private EditText x,y,z;
    private TextView resView, operationView;
    private Spinner spinner1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones1_vector);

        x = (EditText)findViewById(R.id.ejeA);
        y = (EditText)findViewById(R.id.ejeB);
        z = (EditText)findViewById(R.id.ejeC);

        resView = (TextView)findViewById(R.id.txt_resB);
        operationView = (TextView)findViewById(R.id.operationLabelB);

        spinner1 = (Spinner)findViewById(R.id.mainSpinnerB);
        String operaciones[] = {"Longitud vector", "Cosenos directores", "Multiplicaciónde vector por x"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_operaciones, operaciones);
        spinner1.setAdapter(adapter);
    }


}
