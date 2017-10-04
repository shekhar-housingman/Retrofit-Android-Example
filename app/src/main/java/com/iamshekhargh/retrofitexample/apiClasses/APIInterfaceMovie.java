package com.iamshekhargh.retrofitexample.apiClasses;

import com.iamshekhargh.retrofitexample.Model.MovieResponse;
import com.iamshekhargh.retrofitexample.Model.UserObject;
import com.iamshekhargh.retrofitexample.Model.response.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by <<-- iamShekharGH -->>
 * on 27 March 2017
 * at 12:26 PM.
 */

public interface APIInterfaceMovie {

    @GET("/get")
    Call<List<UserObject>> getList();

    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovie(@Query("api_key") String key);

    @GET("movie/{id}")
    Call<MovieResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String key);

    @GET("get")
    Call<List<UserResponse>> getUsers();

}
