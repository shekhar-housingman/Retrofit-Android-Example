package com.iamshekhargh.retrofitexample.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.iamshekhargh.retrofitexample.Presenter.FormFillingPresenter;
import com.iamshekhargh.retrofitexample.Presenter.FormView;
import com.iamshekhargh.retrofitexample.Presenter.FormViewPresenterImplementor;
import com.iamshekhargh.retrofitexample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by <<-- iamShekharGH -->>
 * on 24/03/17.
 */

public class FragmentAcceptData extends Fragment implements FormView {


    @BindView(R.id.formfilling_name)
    EditText formfillingName;
    @BindView(R.id.formfilling_password)
    EditText formfillingPassword;
    @BindView(R.id.formfilling_profession)
    EditText formfillingProfession;
    @BindView(R.id.formfilling_submit)
    Button formfillingSubmit;
    FormFillingPresenter presenter;
    ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_formfilling, container, false);
        progressDialog = new ProgressDialog(getContext());
        presenter = new FormViewPresenterImplementor(this);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewFunctionality();

    }

    private void viewFunctionality() {
        formfillingSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.validateUP(
                        extractET(formfillingName),
                        extractET(formfillingPassword),
                        extractET(formfillingProfession)
                );
            }
        });
    }

    @Override
    public void usernameError() {
        formfillingName.setText("");
        formfillingName.setHint("Username invalid");
    }

    @Override
    public void passwordError() {
        formfillingPassword.setText("");
        formfillingPassword.setHint("Password Invalid");

    }

    @Override
    public void professionError() {
        formfillingProfession.setText("");
        formfillingProfession.setHint("Profession Invalid");

    }

    @Override
    public void showProgressBar() {
        if (progressDialog != null) {
            progressDialog.setTitle("Loading...");
            progressDialog.show();
        }
    }

    @Override
    public void hideProgressBar() {
        if (progressDialog != null)
            progressDialog.dismiss();
    }


    private String extractET(EditText editText) {
        if (editText == null || editText.getText().toString().equals("")) {
            return "";
        } else return editText.getText().toString();
    }
}
