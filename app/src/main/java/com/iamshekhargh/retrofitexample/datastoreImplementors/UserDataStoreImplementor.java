package com.iamshekhargh.retrofitexample.datastoreImplementors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iamshekhargh.retrofitexample.Model.response.UserResponse;
import com.iamshekhargh.retrofitexample.apiClasses.APIClientMovie;
import com.iamshekhargh.retrofitexample.apiClasses.APIInterfaceMovie;
import com.iamshekhargh.retrofitexample.datasource.UsersDataStore;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by <<-- iamShekharGH -->>
 * on 17 April 2017
 * at 3:39 PM.
 */

public class UserDataStoreImplementor implements UsersDataStore {

    ResponseTrigger responseTrigger;
    APIInterfaceMovie apiInterfaceMovie;

    public UserDataStoreImplementor(ResponseTrigger responseTrigger) {
        this.responseTrigger = responseTrigger;
        apiInterfaceMovie = APIClientMovie.getClient().create(APIInterfaceMovie.class);
    }

    @Override
    public void getUserInfo() {
        Call<List<UserResponse>> call = apiInterfaceMovie.getUsers();
        call.enqueue(new Callback<List<UserResponse>>() {
            @Override
            public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response) {
//                responseTrigger.onDataArrived(new Gson().toJson(response));
                responseTrigger.onDataArrived(new GsonBuilder().setPrettyPrinting().create().toJson(response));
            }

            @Override
            public void onFailure(Call<List<UserResponse>> call, Throwable t) {
                responseTrigger.onDataArrived("Could not complete.");
            }
        });
    }
}
