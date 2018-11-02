package com.niles.appbase.ui.loading;

import com.niles.appbase.ui.base.BasePresenter;
import com.niles.http.HttpManager;

/**
 * Created by Niles
 * Date 2018/11/1 17:36
 * Email niulinguo@163.com
 */
public interface BaseLoadingPresenter<V extends BaseLoadingView> extends BasePresenter<V> {

    void loadData(boolean reload);

    HttpManager getHttpManager();

    LoaderProvider getLoaderProvider();
}
