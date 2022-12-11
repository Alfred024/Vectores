package com.vectores.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class proceduresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procedures);
    }
    public void backToMain(View view){
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }
}