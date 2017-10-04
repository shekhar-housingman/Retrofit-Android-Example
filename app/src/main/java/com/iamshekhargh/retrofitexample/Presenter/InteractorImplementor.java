package com.iamshekhargh.retrofitexample.Presenter;

import android.os.Handler;

/**
 * Created by <<-- iamShekharGH -->>
 * on 27 March 2017
 * at 5:10 PM.
 */

public class InteractorImplementor implements Interactor {
    @Override
    public void validateInfo(final String uname, final String pwd, final String profession, final OnClicked onClicked) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (uname == null || uname.isEmpty()) {
                    onClicked.userError();
                }
                if (pwd == null || pwd.isEmpty()) {
                    onClicked.pwdError();
                }
                if (profession == null || profession.isEmpty()) {
                    onClicked.professionError();
                }
            }
        }, 2000);
    }
}
