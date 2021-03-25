package com.android.savyourlibrary;

import android.content.Context;
import android.widget.Toast;

public class SavyourTracker
{
    private  final String TAG = "SAVYOUR PLUGIN";

    public  void showConnectedMessage(Context c, String message){

        Toast.makeText(c,message,Toast.LENGTH_SHORT).show();
    }
}
