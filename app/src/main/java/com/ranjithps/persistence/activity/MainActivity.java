package com.ranjithps.persistence.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.facebook.stetho.Stetho;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ranjithps.persistence.R;
import com.ranjithps.persistence.dao.ConfigRepository;
import com.ranjithps.persistence.databinding.ActivityMainBinding;
import com.ranjithps.persistence.entity.Config;
import com.ranjithps.persistence.network.APIInterface;
import com.ranjithps.persistence.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        activityMainBinding.clickHereBtn.setOnClickListener(view ->
                networkCall()
        );

        activityMainBinding.getDataBtn.setOnClickListener(view ->
                getData()
        );
    }

    void getData(){
        //TODO Need to implement data retrieval
        Toast.makeText(MainActivity.this, "The database response" , Toast.LENGTH_SHORT).show();

    }

    void networkCall(){
        /** Create handle for the RetrofitInstance interface*/
        APIInterface service = RetrofitClient.getInstance().create(APIInterface.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<Config> call = service.getConfiguration();

        /**Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");
        ConfigRepository configRepository = new ConfigRepository(this);

        call.enqueue(new Callback<Config>() {
            @Override
            public void onResponse(Call<Config> call, Response<Config> response) {
                Toast.makeText(MainActivity.this, "Got the response" , Toast.LENGTH_SHORT).show();
                configRepository.insertOnlySingleRecord(response.body());
            }

            @Override
            public void onFailure(Call<Config> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Error message: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
