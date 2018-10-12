package com.niles.appbase;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.niles.http.HttpConfig;
import com.niles.http.HttpManager;
import com.niles.http.converter.StringConverterFactory;
import com.orhanobut.hawk.Hawk;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Niles
 * Date 2018/10/12 17:20
 * Email niulinguo@163.com
 */
public class AppManager {

    private static final String TAG = "AppManager";

    private static AppManager sInstance;
    private final Application mApp;
    private final boolean mIsDebug;

    private final HttpManager mHttpManager = new HttpManager();

    private AppManager(Application app, final boolean isDebug) {
        mApp = app;
        mIsDebug = isDebug;

        mHttpManager.setHttpConfig(new HttpConfig.Builder()
                .setLogger(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        if (isDebug) {
                            Log.e(TAG, message);
                        }
                    }
                })
                .addConverterFactory(StringConverterFactory.create())
                .build());

        Hawk.init(app).build();

        if (isDebug) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(app);
    }

    public static AppManager getInstance() {
        if (sInstance == null) {
            throw new RuntimeException("Init First");
        }
        return sInstance;
    }

    public static void init(Application app, boolean isDebug) {
        if (sInstance != null) {
            throw new RuntimeException("Init Once");
        }
        sInstance = new AppManager(app, isDebug);
    }

    public boolean isDebug() {
        return mIsDebug;
    }

    public Application app() {
        return mApp;
    }

    public HttpManager getHttpManager() {
        return mHttpManager;
    }

    public <S> S getService(Class<S> service) {
        return ARouter.getInstance().navigation(service);
    }
}
