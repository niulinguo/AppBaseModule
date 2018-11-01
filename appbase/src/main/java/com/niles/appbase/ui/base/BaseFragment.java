package com.niles.appbase.ui.base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.blankj.utilcode.util.ToastUtils;
import com.niles.appbase.BuildConfig;

import java.util.HashMap;

/**
 * Created by Niles
 * Date 2018/10/29 17:11
 * Email niulinguo@163.com
 */
public class BaseFragment<P extends BasePresenter> extends Fragment implements ActivityCall, BaseView {

    private FragmentCallback mFragmentCallback;
    private P mPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentCallback) {
            mFragmentCallback = (FragmentCallback) context;
        }
        mPresenter = createPresenter();
    }

    protected P getPresenter() {
        return mPresenter;
    }

    protected P createPresenter() {
        return null;
    }

    protected Object fragmentCallback(String method, HashMap<String, Object> params) {
        if (mFragmentCallback != null) {
            return mFragmentCallback.onFragmentCallback(method, params);
        }
        return null;
    }

    @Override
    public Object onActivityCall(String method, HashMap<String, Object> params) {
        return null;
    }

    @Override
    public void toast(String msg) {
        ToastUtils.showShort(msg);
    }

    @Override
    public void log(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.i(tag, msg);
        }
    }
}
