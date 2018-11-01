package com.niles.appbase.ui.loading;

import com.kingja.loadsir.callback.Callback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niles
 * Date 2018/11/1 14:35
 * Email niulinguo@163.com
 */
public class LoadingConfig {

    private final List<Callback> mCallbacks;
    private final Class<? extends Callback> mDefaultCallback;

    private LoadingConfig(List<Callback> callbacks, Class<? extends Callback> defaultCallback) {
        mCallbacks = callbacks;
        mDefaultCallback = defaultCallback;
    }

    public List<Callback> getCallbacks() {
        return mCallbacks;
    }

    public Class<? extends Callback> getDefaultCallback() {
        return mDefaultCallback;
    }

    public static final class Builder {
        private List<Callback> mCallbacks = new ArrayList<>();
        private Class<? extends Callback> mDefaultCallback;

        public List<Callback> getCallbacks() {
            return mCallbacks;
        }

        public Builder setCallbacks(List<Callback> callbacks) {
            mCallbacks.addAll(callbacks);
            return this;
        }

        public Builder addCallback(Callback callback) {
            mCallbacks.add(callback);
            return this;
        }

        public Class<? extends Callback> getDefaultCallback() {
            return mDefaultCallback;
        }

        public Builder setDefaultCallback(Class<? extends Callback> defaultCallback) {
            mDefaultCallback = defaultCallback;
            return this;
        }

        public LoadingConfig build() {
            return new LoadingConfig(
                    mCallbacks,
                    mDefaultCallback
            );
        }
    }
}
