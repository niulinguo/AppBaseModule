package com.niles.appbase.ui.loading;

import android.view.View;

import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;
import com.niles.appbase.AppManager;
import com.niles.appbase.ui.base.BaseFragment;

/**
 * Created by Niles
 * Date 2018/11/1 17:30
 * Email niulinguo@163.com
 */
public abstract class BaseLoadingFragment<P extends BaseLoadingPresenter> extends BaseFragment<P> implements BaseLoadingView, Callback.OnReloadListener {

    private LoadSir mLoadSir;
    private LoadService mLoadService;

    @Override
    public void showLoading(Class<? extends Callback> callback) {
        if (mLoadService == null) {
            mLoadService = getLoadSir().register(this, this);
        } else {
            if (callback == null) {
                Class<? extends Callback> defaultCallback = AppManager.getInstance().getAppConfig().getLoadingConfig().getDefaultCallback();
                mLoadService.showCallback(defaultCallback);
            } else {
                mLoadService.showCallback(callback);
            }
        }
    }

    @Override
    public void hideLoading() {
        if (mLoadService != null) {
            mLoadService.showSuccess();
        }
    }

    protected final LoadSir getLoadSir() {
        if (mLoadSir == null) {
            mLoadSir = createLoadSir();
        }
        return mLoadSir;
    }

    protected LoadSir createLoadSir() {
        return LoadSir.getDefault();
    }

    @Override
    public void onReload(View v) {
        showLoading(null);
        getPresenter().loadData(true);
    }
}
