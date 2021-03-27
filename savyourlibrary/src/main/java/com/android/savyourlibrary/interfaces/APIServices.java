package com.android.savyourlibrary.interfaces;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIServices
{

    @GET("")
    Call <ResponseBody> orderPlaced();

    @FormUrlEncoded
    @POST("contact-us")
    Call<ResponseBody> contactUs(@FieldMap Map<String, String> map);

}
