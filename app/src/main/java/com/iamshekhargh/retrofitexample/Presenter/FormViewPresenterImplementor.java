package com.iamshekhargh.retrofitexample.Presenter;

/**
 * Created by <<-- iamShekharGH -->>
 * on 24/03/17.
 */

public class FormViewPresenterImplementor implements FormFillingPresenter, Interactor.OnClicked {

    FormView view;
    Interactor interactor;

    public FormViewPresenterImplementor(FormView view) {
        this.view = view;
        interactor = new InteractorImplementor();
    }

    @Override
    public void validateUP(final String user, final String password, final String profession) {
        view.showProgressBar();
        interactor.validateInfo(user, password, profession, this);
    }

    @Override
    public void userError() {
        view.usernameError();
        view.hideProgressBar();
    }

    @Override
    public void pwdError() {
        view.passwordError();
        view.hideProgressBar();
    }

    @Override
    public void professionError() {
        view.professionError();
        view.hideProgressBar();
    }
}

