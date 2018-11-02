package com.niles.appbasemodule.loading;

import android.os.Bundle;

import com.niles.appbase.ui.loading.BaseLoadingActivity;
import com.niles.appbasemodule.R;

public class LoadingDemoActivity extends BaseLoadingActivity<LoadingDemoPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_demo);
        getPresenter().start();
    }

    @Override
    protected LoadingDemoPresenter createPresenter() {
        return new LoadingDemoPresenter(this);
    }

    @Override
    public void onLoadSuccess(Object... objs) {

    }

    @Override
    public void onLoadFailure(Object... objs) {

    }
}
