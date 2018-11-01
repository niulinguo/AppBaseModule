package com.niles.appbase.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.kingja.loadsir.callback.Callback;
import com.niles.appbase.mvp.BaseView;

import java.util.HashMap;

/**
 * Created by Niles
 * Date 2018/10/29 17:11
 * Email niulinguo@163.com
 */
public class BaseFragment extends Fragment implements ActivityCall, BaseView {

    private FragmentCallback mFragmentCallback;
    private BaseView mParentBaseView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentCallback) {
            mFragmentCallback = (FragmentCallback) context;
        }
        if (context instanceof BaseView) {
            mParentBaseView = (BaseView) context;
        }
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
    public void showLoading(Class<? extends Callback> callback) {
        if (mParentBaseView != null) {
            mParentBaseView.showLoading(callback);
        }
    }

    @Override
    public void hideLoading() {
        if (mParentBaseView != null) {
            mParentBaseView.hideLoading();
        }
    }

    @Override
    public void toast(String msg) {
        if (mParentBaseView != null) {
            mParentBaseView.toast(msg);
        }
    }

    @Override
    public void log(String tag, String msg) {
        if (mParentBaseView != null) {
            mParentBaseView.log(tag, msg);
        }
    }
}
