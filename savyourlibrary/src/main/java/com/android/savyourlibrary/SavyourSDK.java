package com.android.savyourlibrary;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.android.savyourlibrary.interfaces.APIServices;
import com.android.savyourlibrary.networking.WebClient;
import java.util.HashMap;
import androidx.annotation.NonNull;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SavyourSDK {

    private final String TAG = "SavyourSdk";
    //constants for partner
    public static final String ORDER_ID = "order_id";
    public static final String PACKAGE_NAME = "package_name";
    public static final String VERSION = "version";
    public static final String VERSION_CODE = "version_code";

    public void init(Intent intent) {
        if(intent != null) {
            Log.e(TAG,"Intent is not null");
            if(intent.getAction() != null) {
                if(intent.getAction().equalsIgnoreCase("savyour")) {
                    Log.e(TAG,"Is coming from Savyour App");
                    //Log.e(TAG,"User Id is: " + intent.getStringExtra("userid"));
                } else
                    Log.e(TAG,"Is Not coming from Savyour App");
            } else
                Log.e(TAG,"Intent action is null");
        } else
            Log.e(TAG,"Intent is null");
    }


    public  void order(Context context, HashMap<String,String> params) {
        Call<ResponseBody> response;
        Retrofit retrofit = WebClient.getInstance();
        APIServices apiServices = retrofit.create(APIServices.class);
        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            params.put(PACKAGE_NAME, context.getPackageName());
            params.put(VERSION, pInfo.versionName);
            params.put(VERSION_CODE, pInfo.versionCode + "");
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        response = apiServices.contactUs(params);
        response.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Log.e(TAG,"API IS SUCCESS");
                }
            }
            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                Log.e(TAG,"API IS FAILED");
            }
        });

        //old Android method
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try  {
//                    try {
//                        Network.sendGET();
//                        Log.e(TAG,"order Placed");
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.start();
    }
}
