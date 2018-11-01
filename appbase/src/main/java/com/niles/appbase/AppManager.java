package com.niles.appbase;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.Utils;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadSir;
import com.niles.appbase.loading.LoadingConfig;
import com.niles.http.HttpManager;
import com.orhanobut.hawk.Hawk;

import java.util.List;

/**
 * Created by Niles
 * Date 2018/10/12 17:20
 * Email niulinguo@163.com
 */
public class AppManager {

    private static AppManager sInstance;
    private final AppConfig mAppConfig;

    private final HttpManager mHttpManager = new HttpManager();

    private AppManager(AppConfig appConfig) {
        mAppConfig = appConfig;
        mHttpManager.setHttpConfig(appConfig.getHttpConfig());
        Hawk.init(mAppConfig.getApp()).build();
        if (mAppConfig.isDebug()) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(mAppConfig.getApp());
        Utils.init(mAppConfig.getApp());
        initLoading(appConfig.getLoadingConfig());
    }

    public static AppManager getInstance() {
        if (sInstance == null) {
            throw new RuntimeException("Init First");
        }
        return sInstance;
    }

    public static AppManager init(AppConfig appConfig) {
        if (sInstance != null) {
            throw new RuntimeException("Init Once");
        }
        return sInstance = new AppManager(appConfig);
    }

    private void initLoading(LoadingConfig loadingConfig) {
        List<Callback> callbacks = loadingConfig.getCallbacks();
        LoadSir.Builder builder = LoadSir.beginBuilder();
        for (Callback callback : callbacks) {
            builder.addCallback(callback);
        }
        builder.setDefaultCallback(loadingConfig.getDefaultCallback());
        builder.commit();
    }

    public AppConfig getAppConfig() {
        return mAppConfig;
    }

    public HttpManager getHttpManager() {
        return mHttpManager;
    }

    public <S> S getService(Class<S> service) {
        return ARouter.getInstance().navigation(service);
    }
}
