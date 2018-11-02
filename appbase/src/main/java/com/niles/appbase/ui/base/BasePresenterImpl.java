package com.niles.appbase.ui.base;

/**
 * Created by Niles
 * Date 2018/10/29 18:26
 * Email niulinguo@163.com
 */
public class BasePresenterImpl<V extends BaseView> implements BasePresenter<V> {

    private final V mView;

    public BasePresenterImpl(V view) {
        mView = view;
    }

    @Override
    public V getView() {
        return mView;
    }

    @Override
    public void start() {

    }
}
