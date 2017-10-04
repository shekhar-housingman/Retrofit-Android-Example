package com.iamshekhargh.retrofitexample.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.iamshekhargh.retrofitexample.Model.Movie;
import com.iamshekhargh.retrofitexample.R;
import com.iamshekhargh.retrofitexample.datasource.MoviesDataStore;
import com.iamshekhargh.retrofitexample.datasource.UsersDataStore;
import com.iamshekhargh.retrofitexample.datastoreImplementors.MoviesDataStoreImplementor;
import com.iamshekhargh.retrofitexample.datastoreImplementors.UserDataStoreImplementor;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by <<-- iamShekharGH -->>
 * on 27 March 2017
 * at 1:06 PM.
 */

public class FragmentShowMovieInfo extends Fragment implements View.OnClickListener,
        MoviesDataStore.ResponseTrigger,
        UsersDataStore.ResponseTrigger {

    Helper helper;
    String apiKey;
    List<Movie> list;
    ProgressDialog progressDialog;

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.responseBody)
    TextView responseBody;
    @BindView(R.id.button_makeAPIcall)
    Button buttonMakeAPIcall;
    MoviesDataStore dataStore;
    UsersDataStore usersDataStore;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_showmovies, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        apiKey = helper.getAPIKEY();
        Log.i("ShowMovieFragment", "\t" + apiKey);
        buttonMakeAPIcall.setOnClickListener(this);
        responseBody.setText("Movie List :~ \n");
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Loading...");
        dataStore = new MoviesDataStoreImplementor(this);
        usersDataStore = new UserDataStoreImplementor(this);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Helper) {
            helper = (Helper) context;
        } else throw new RuntimeException("Must implement FragmentShowMovieInfo.Helper");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_makeAPIcall) {
            makeAPICall();
            showProgressBar();
        }
    }

//    private void makeApiCall() {
//        APIInterfaceMovie apiInterfaceMovie = APIClientMovie.getClient().create(APIInterfaceMovie.class);
//        Call<MovieResponse> call = apiInterfaceMovie.getTopRatedMovie(apiKey);
//        call.enqueue(new Callback<MovieResponse>() {
//            @Override
//            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
//                if (progressDialog != null) {
//                    progressDialog.dismiss();
//                }
//                list = response.body().getResults();
//                for (Movie movie : list) {
////                        responseBody.setText(responseBody.getText().toString() + new GsonBuilder().setPrettyPrinting().create().toJson(movie) + "\n");
//                    responseBody.setText(
//                            responseBody.getText().toString()
//                                    + "Name : " + movie.getTitle() + "\n"
//                                    + "Language : " + movie.getOriginalLanguage() + "\n"
//                                    + "Release Date : " + movie.getReleaseDate() + "\n\n"
//
//                    );
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MovieResponse> call, Throwable t) {
//                if (progressDialog != null) {
//                    progressDialog.dismiss();
//                }
//                responseBody.setText("There was an error while connecting." + "\n" + new Gson().toJson(call));
//            }
//        });
//    }

    private void makeAPICall() {
//        usersDataStore.getUserInfo();
        dataStore.topRatedMovies(helper.getAPIKEY());
    }

    private void dismissProgressBar() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    private void showProgressBar() {
        progressDialog.show();
        progressDialog.setCancelable(false);
    }

    @Override
    public void onDataArrived(String s) {
        responseBody.setText(s);
        dismissProgressBar();
    }


    public interface Helper {
        String getAPIKEY();
    }
}
