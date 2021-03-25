package com.android.savyoursdk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.savyourlibrary.SavyourTracker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SavyourTracker savyourTracker =new SavyourTracker();
        savyourTracker.initData(getIntent());
    }
}