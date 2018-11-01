package com.niles.appbase.mvp;

import com.kingja.loadsir.callback.Callback;

/**
 * Created by Niles
 * Date 2018/10/29 18:26
 * Email niulinguo@163.com
 */
public interface BaseView {

    void showLoading(Class<? extends Callback> callback);

    void hideLoading();

    void toast(String msg);

    void log(String tag, String msg);
}
