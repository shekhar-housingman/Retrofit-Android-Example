package com.iamshekhargh.retrofitexample.apiClasses;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by <<-- iamShekharGH -->>
 * on 28 March 2017
 * at 3:13 PM.
 */

public abstract class ExperimentingCallback<T> implements Callback<T> {

    public abstract void onDataArrived(T t);

    public abstract void onError(String error);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        T t = response.body();
        onDataArrived(t);
    }


//    @Override
//    public void onResponse(Call call, Response response) {
//        T t = response.body();
//
//    }

    @Override
    public void onFailure(Call call, Throwable t) {
        onError("Call did'ent go thru . " + t.toString());
        t.printStackTrace();
    }
}
