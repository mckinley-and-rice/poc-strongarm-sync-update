package com.syncupdate;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class BloggerAPI {

    private static final String url = "https://randomuser.me/";

    public static PostService postService = null;

    public static PostService getPostService()
    {
        if(postService == null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            postService = retrofit.create(PostService.class);

        }
        return postService;

    }

    public interface PostService
    {
        @GET("api/")
        Call<PojoRandom> getPostList();
    }
}
