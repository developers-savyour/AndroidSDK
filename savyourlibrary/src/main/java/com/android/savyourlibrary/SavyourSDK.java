package com.android.savyourlibrary;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import android.util.Log;

public class SavyourSDK
{
    private  final String TAG = "SAVYOUR TRACKER";

    public  void showConnectedMessage(Context c, String message){

        Toast.makeText(c,message,Toast.LENGTH_SHORT).show();
    }

    public void initData(Intent intent)
    {
        if(intent!=null)
        {
            Log.e(TAG,"Intent is not null");

            if(intent.getAction().equalsIgnoreCase("savyour"))
            {
                Log.e(TAG,"Is Coming from savyour application");
                Log.e(TAG,"user Id is: " + intent.getStringExtra("userid"));
            }
            else
            {
                Log.e(TAG,"Is not Coming from savyour application");
            }
        }
        else
        {
            Log.e(TAG,"Intent is null");
        }
    }


    public  void orderPlaced()
    {
            Log.e(TAG,"order Placed");
    }
}
