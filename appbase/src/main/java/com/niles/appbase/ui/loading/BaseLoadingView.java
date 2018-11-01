package com.niles.appbase.ui.loading;

import com.kingja.loadsir.callback.Callback;
import com.niles.appbase.ui.base.BaseView;

/**
 * Created by Niles
 * Date 2018/11/1 17:27
 * Email niulinguo@163.com
 */
public interface BaseLoadingView extends BaseView {

    void showLoading(Class<? extends Callback> callback);

    void hideLoading();

    void onLoadSuccess(Object... obj);

    void onLoadFailure(Object... obj);
}
