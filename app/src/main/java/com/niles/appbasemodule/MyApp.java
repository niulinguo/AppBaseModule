package com.niles.appbasemodule;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import com.niles.appbase.AppConfig;
import com.niles.appbase.AppManager;
import com.niles.appbase.loading.LoadingConfig;
import com.niles.appbasemodule.loading.CustomCallback;
import com.niles.appbasemodule.loading.EmptyCallback;
import com.niles.appbasemodule.loading.ErrorCallback;
import com.niles.appbasemodule.loading.LoadingCallback;
import com.niles.appbasemodule.loading.TimeoutCallback;
import com.niles.http.HttpConfig;
import com.niles.http.converter.StringConverterFactory;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Niles
 * Date 2018/10/12 17:31
 * Email niulinguo@163.com
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppManager.init(new AppConfig.Builder()
                .setApp(this)
                .setDebug(BuildConfig.DEBUG)
                .setHttpConfig(new HttpConfig.Builder()
                        .setBaseUrl("http://www.wanandroid.com")
                        .setLogger(new HttpLoggingInterceptor.Logger() {
                            @SuppressLint("LogNotTimber")
                            @Override
                            public void log(String message) {
                                Log.e("http", message);
                            }
                        })
                        .addConverterFactory(StringConverterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build())
                .setLoadingConfig(new LoadingConfig.Builder()
                        .addCallback(new ErrorCallback())
                        .addCallback(new EmptyCallback())
                        .addCallback(new LoadingCallback())
                        .addCallback(new TimeoutCallback())
                        .addCallback(new CustomCallback())
                        .setDefaultCallback(LoadingCallback.class)
                        .build())
                .build());
    }
}
