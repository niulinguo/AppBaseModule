package com.niles.appbasemodule;

import android.app.Application;
import android.util.Log;

import com.niles.appbase.AppManager;
import com.niles.http.HttpManager;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Niles
 * Date 2018/10/12 17:31
 * Email niulinguo@163.com
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppManager appManager = AppManager.init(this, BuildConfig.DEBUG);
        HttpManager httpManager = appManager.getHttpManager();
        httpManager.setHttpConfig(httpManager.getHttpConfig()
                .newBuilder()
                .setBaseUrl("http://www.wanandroid.com")
                .setLogger(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        Log.e("http", message);
                    }
                })
                .build());
    }
}
