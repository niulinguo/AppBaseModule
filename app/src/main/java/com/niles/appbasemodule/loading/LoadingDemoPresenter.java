package com.niles.appbasemodule.loading;

import android.os.Handler;
import android.support.annotation.NonNull;

import com.google.gson.JsonObject;
import com.niles.appbase.ui.loading.BaseLoadingPresenterImpl;
import com.niles.appbase.ui.loading.BaseLoadingView;
import com.niles.appbasemodule.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Niles
 * Date 2018/11/1 18:12
 * Email niulinguo@163.com
 */
class LoadingDemoPresenter extends BaseLoadingPresenterImpl<BaseLoadingView> {
    LoadingDemoPresenter(BaseLoadingView view) {
        super(view);
    }

    @Override
    public void start() {
        super.start();
        getView().showLoading(null);
        loadData(false);
    }

    @Override
    public void loadData(final boolean reload) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (reload) {
                    getHttpManager().getService(ApiService.class).test().enqueue(new Callback<JsonObject>() {
                        @Override
                        public void onResponse(@NonNull Call<JsonObject> call, @NonNull Response<JsonObject> response) {
                            getView().hideLoading();
                            JsonObject body = response.body();
                            if (body != null) {
                                String msg = body.get("msg").getAsString();
                                getView().toast(msg);
                            }
                        }

                        @Override
                        public void onFailure(@NonNull Call<JsonObject> call, @NonNull Throwable t) {
                            getView().showLoading(getLoaderProvider().error());
                        }
                    });
                } else {
                    getView().showLoading(getLoaderProvider().timeout());
                }
            }
        }, 3000);
    }
}
