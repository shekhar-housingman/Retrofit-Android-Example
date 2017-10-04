package com.iamshekhargh.retrofitexample.datastoreImplementors;

import com.iamshekhargh.retrofitexample.Model.Movie;
import com.iamshekhargh.retrofitexample.Model.MovieResponse;
import com.iamshekhargh.retrofitexample.apiClasses.APIClientMovie;
import com.iamshekhargh.retrofitexample.apiClasses.APIInterfaceMovie;
import com.iamshekhargh.retrofitexample.apiClasses.ExperimentingCallback;
import com.iamshekhargh.retrofitexample.datasource.MoviesDataStore;

import java.util.List;

import retrofit2.Call;

/**
 * Created by <<-- iamShekharGH -->>
 * on 17 April 2017
 * at 12:09 PM.
 */

public class MoviesDataStoreImplementor implements MoviesDataStore {
    ResponseTrigger responseTrigger;
    APIInterfaceMovie apiInterfaceMovie;
    String responseString = "";

    public MoviesDataStoreImplementor(ResponseTrigger responseTrigger) {
        this.responseTrigger = responseTrigger;
        apiInterfaceMovie = APIClientMovie.getClient().create(APIInterfaceMovie.class);
    }

    public void topRatedMovies(String apiKeys) {
        Call<MovieResponse> movieResponseCall = apiInterfaceMovie.getTopRatedMovie(apiKeys);
        movieResponseCall.enqueue(new ExperimentingCallback<MovieResponse>() {
            @Override
            public void onDataArrived(MovieResponse movieResponse) {
                List<Movie> list = movieResponse.getResults();
                for (Movie m : list) {
                    responseString = responseString + "Name : " + m.getTitle() + "\n"
                            + "Language : " + m.getOriginalLanguage() + "\n"
                            + "Release Date : " + m.getReleaseDate() + "\n\n";
                }
                responseTrigger.onDataArrived(responseString);
            }

            @Override
            public void onError(String error) {
                responseTrigger.onDataArrived("There was an error while connecting. " + error);
            }
        });

//        movieResponseCall.enqueue(new Callback<MovieResponse>() {
//            @Override
//            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
//                if (response.body() == null) {
//                    responseTrigger.onDataArrived("Response is null");
//                    return;
//                }
//                List<Movie> list = response.body().getResults();
//                for (Movie m : list) {
//                    responseString = responseString + "Name : " + m.getTitle() + "\n"
//                            + "Language : " + m.getOriginalLanguage() + "\n"
//                            + "Release Date : " + m.getReleaseDate() + "\n\n";
//
//                }
//                responseTrigger.onDataArrived(responseString);
//            }
//
//            @Override
//            public void onFailure(Call<MovieResponse> call, Throwable t) {
//                responseTrigger.onDataArrived("There was an error while connecting." + "\n" + new Gson().toJson(call));
//            }
//        });

    }
}
