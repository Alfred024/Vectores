package com.vectores.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class proceduresActivity extends AppCompatActivity {

    private TextView procedimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procedures);

        procedimiento = (TextView)findViewById(R.id.title_Procedures);
        String procedimintoRecibido = getIntent().getStringExtra("key");
        procedimiento.setText(procedimintoRecibido);
    }
    public void backToMain(View view){
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }
}