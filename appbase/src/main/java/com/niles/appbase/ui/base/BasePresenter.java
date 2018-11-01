package com.niles.appbase.ui.base;

/**
 * Created by Niles
 * Date 2018/10/29 18:26
 * Email niulinguo@163.com
 */
public interface BasePresenter<V extends BaseView> {

    V getView();
}
