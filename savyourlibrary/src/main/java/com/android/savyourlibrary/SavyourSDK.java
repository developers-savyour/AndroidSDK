package com.android.savyourlibrary;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import android.util.Log;

import com.android.savyourlibrary.interfaces.APIServices;
import com.android.savyourlibrary.networking.WebClient;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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


    public  void orderPlaced(HashMap<String,String> params)
    {
        callApiOrderPlaced();
       /* Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try  {
                    try {
                        Network.sendGET();
                        Log.e(TAG,"order Placed");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();*/

    }

    private void callApiOrderPlaced()
    {
        Call<ResponseBody> getOrderPlaced;
        Retrofit retrofit = WebClient.getInstance();
        APIServices apiServices = retrofit.create(APIServices.class);
        HashMap<String, String> params = new HashMap<>();
        params.put("subject","test");
        params.put("message", "test message");
        getOrderPlaced=apiServices.contactUs(params);
        getOrderPlaced.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Log.e(TAG,"API IS SUCCESS");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG,"API IS FAILED");
            }
        });
    }
}
