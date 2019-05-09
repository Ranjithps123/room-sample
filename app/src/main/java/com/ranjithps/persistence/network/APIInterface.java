package com.ranjithps.persistence.network;

import com.ranjithps.persistence.entity.Config;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("/bins/6dfbm")
    Call<Config> getConfiguration();
}
