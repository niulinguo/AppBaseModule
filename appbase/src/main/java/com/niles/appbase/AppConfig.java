package com.niles.appbase;

import android.app.Application;

import com.niles.appbase.ui.loading.LoadingConfig;
import com.niles.http.HttpConfig;

/**
 * Created by Niles
 * Date 2018/11/1 14:32
 * Email niulinguo@163.com
 */
public class AppConfig {

    private final Application mApp;
    private final boolean mDebug;
    private final HttpConfig mHttpConfig;
    private final LoadingConfig mLoadingConfig;

    private AppConfig(Application app, boolean debug, HttpConfig httpConfig, LoadingConfig loadingConfig) {
        mApp = app;
        mDebug = debug;
        mHttpConfig = httpConfig;
        mLoadingConfig = loadingConfig;
    }

    public Application getApp() {
        return mApp;
    }

    public boolean isDebug() {
        return mDebug;
    }

    public HttpConfig getHttpConfig() {
        return mHttpConfig;
    }

    public LoadingConfig getLoadingConfig() {
        return mLoadingConfig;
    }

    public static final class Builder {
        private Application mApp;
        private boolean mDebug;
        private HttpConfig mHttpConfig;
        private LoadingConfig mLoadingConfig;

        public Application getApp() {
            return mApp;
        }

        public Builder setApp(Application app) {
            mApp = app;
            return this;
        }

        public boolean isDebug() {
            return mDebug;
        }

        public Builder setDebug(boolean debug) {
            mDebug = debug;
            return this;
        }

        public HttpConfig getHttpConfig() {
            return mHttpConfig;
        }

        public Builder setHttpConfig(HttpConfig httpConfig) {
            mHttpConfig = httpConfig;
            return this;
        }

        public LoadingConfig getLoadingConfig() {
            return mLoadingConfig;
        }

        public Builder setLoadingConfig(LoadingConfig loadingConfig) {
            mLoadingConfig = loadingConfig;
            return this;
        }

        public AppConfig build() {
            return new AppConfig(
                    mApp,
                    mDebug,
                    mHttpConfig,
                    mLoadingConfig
            );
        }
    }
}
