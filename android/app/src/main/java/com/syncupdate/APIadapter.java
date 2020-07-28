package com.syncupdate;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

    public interface APIadapter
    {
        @GET("dev/getAthletes")
        Call<List<GetAthleteModel>> getAthletes(@Header("Content-Type") String content_type,
                               @Query("client_id") int client_id,
                               @Query("warehouse_id") int warehouse__id,
                               @Query("build_number") int build_number);
    }
