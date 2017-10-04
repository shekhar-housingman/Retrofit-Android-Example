package com.iamshekhargh.retrofitexample.datasource;

/**
 * Created by <<-- iamShekharGH -->>
 * on 14 April 2017
 * at 6:42 PM.
 */

public interface MoviesDataStore {

    void topRatedMovies(String apiKeys);

    interface ResponseTrigger {
        void onDataArrived(String string);
    }
}
