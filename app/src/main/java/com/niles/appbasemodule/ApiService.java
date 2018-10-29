package com.niles.appbasemodule;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Niles
 * Date 2018/10/29 17:33
 * Email niulinguo@163.com
 */
public interface ApiService {

    @GET("/tools/mockapi/2793/test_message")
    Call<JsonObject> test();
}
