package com.niles.appbase.ui.loading;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.kingja.loadsir.callback.Callback;

/**
 * Created by Niles
 * Date 2018/11/2 13:59
 * Email niulinguo@163.com
 */
public interface LoaderProvider extends IProvider {

    Class<? extends Callback> error();

    Class<? extends Callback> empty();

    Class<? extends Callback> loading();

    Class<? extends Callback> timeout();

    Class<? extends Callback> custom();
}
