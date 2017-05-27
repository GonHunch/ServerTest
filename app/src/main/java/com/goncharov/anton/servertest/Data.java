package com.goncharov.anton.servertest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Data {
    @GET("/users/Pr0xifier")
    Call<Post> getData(@Query("id") int resourceName);
}
