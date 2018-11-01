package com.niles.appbase.ui.loading;

import com.niles.appbase.AppManager;
import com.niles.appbase.ui.base.BasePresenterImpl;
import com.niles.http.HttpManager;

/**
 * Created by Niles
 * Date 2018/11/1 17:36
 * Email niulinguo@163.com
 */
public class BaseLoadingPresenterImpl<V extends BaseLoadingView> extends BasePresenterImpl<V> implements BaseLoadingPresenter<V> {

    public BaseLoadingPresenterImpl(V view) {
        super(view);
    }

    @Override
    public void loadData(boolean reload) {

    }

    @Override
    public HttpManager getHttpManager() {
        return AppManager.getInstance().getHttpManager();
    }
}
