package com.iamshekhargh.retrofitexample.apiClasses;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by <<-- iamShekharGH -->>
 * on 27 March 2017
 * at 12:56 PM.
 */

//  59a5a15a19d18280f13b9c4d434ae565
//  Example Call https://api.themoviedb.org/3/movie/550?api_key=59a5a15a19d18280f13b9c4d434ae565

public class APIClientMovie {
    public static final String BASE_URL = "http://api.themoviedb.org/3/";
//    public static final String BASE_URL = "https://android-api-practice.herokuapp.com/";
    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit == null) {
            //This is used for logging. -->
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);
            // <--

            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }


}
