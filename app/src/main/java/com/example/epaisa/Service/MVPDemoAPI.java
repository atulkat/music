package com.example.epaisa.Service;


import com.example.epaisa.Model.SongResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface MVPDemoAPI {

    @Headers("Content-Type: application/json")
    @GET("search?term=Michael+jackson")
    Call<SongResponse> getSongList();// throws NetworkErrorException;

   /* @POST("Michael+jackson")
    @FormUrlEncoded
    Call<SongResponse> notification(@Field("id") String id, @Field("language") String language);*/
}
