package com.niles.appbase.mvp;

import com.niles.appbase.AppManager;
import com.niles.http.HttpManager;

/**
 * Created by Niles
 * Date 2018/10/29 18:26
 * Email niulinguo@163.com
 */
public abstract class BasePresenterImpl implements BasePresenter {

    private final BaseView mView;

    public BasePresenterImpl(BaseView view) {
        mView = view;
    }

    @Override
    public HttpManager getHttpManager() {
        return AppManager.getInstance().getHttpManager();
    }
}
