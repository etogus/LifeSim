package com.mamedovga.lifesim;

import com.mamedovga.lifesim.models.Response;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface RetrofitAPI {
    @GET
    Call<Response> getMessage(@Url String url);

    @FormUrlEncoded
    @POST("chat")
    Call<Response> sendMessage(@Field("chatInput") String chatText);
}