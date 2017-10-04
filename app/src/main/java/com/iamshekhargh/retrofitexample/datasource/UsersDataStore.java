package com.iamshekhargh.retrofitexample.datasource;

/**
 * Created by <<-- iamShekharGH -->>
 * on 17 April 2017
 * at 3:38 PM.
 */

public interface UsersDataStore {

    void getUserInfo();

    interface ResponseTrigger {
        void onDataArrived(String string);
    }
}
