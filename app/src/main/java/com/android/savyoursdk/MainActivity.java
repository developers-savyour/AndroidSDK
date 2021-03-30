package com.android.savyoursdk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.savyourlibrary.SavyourSDK;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SavyourSDK savyourSDK = new SavyourSDK();
        //initialization
        savyourSDK.init(getIntent());
        //order
        HashMap<String, String> params = new HashMap<>();
        params.put(SavyourSDK.ORDER_ID, "98765");
        savyourSDK.order(this, params);
    }
}