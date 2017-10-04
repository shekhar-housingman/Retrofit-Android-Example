package com.iamshekhargh.retrofitexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.iamshekhargh.retrofitexample.Fragment.FragmentAcceptData;
import com.iamshekhargh.retrofitexample.Fragment.FragmentShowMovieInfo;


//  59a5a15a19d18280f13b9c4d434ae565
// Example Call https://api.themoviedb.org/3/movie/550?api_key=59a5a15a19d18280f13b9c4d434ae565

public class MainActivity extends AppCompatActivity implements FragmentShowMovieInfo.Helper {

    String API_KEY = "59a5a15a19d18280f13b9c4d434ae565";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addFragment(new FragmentShowMovieInfo());
    }
//
    private void addFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public String getAPIKEY() {
        return API_KEY;
    }
}
