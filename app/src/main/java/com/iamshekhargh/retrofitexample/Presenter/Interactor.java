package com.iamshekhargh.retrofitexample.Presenter;

/**
 * Created by <<-- iamShekharGH -->>
 * on 27 March 2017
 * at 4:01 PM.
 */

public interface Interactor {

    interface OnClicked {
        void userError();

        void pwdError();

        void professionError();
    }

    void validateInfo(String uname, String pwd, String profession, OnClicked onClicked);
}
