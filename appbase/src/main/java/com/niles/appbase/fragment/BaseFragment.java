package com.niles.appbase.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

import java.util.HashMap;

/**
 * Created by Niles
 * Date 2018/10/29 17:11
 * Email niulinguo@163.com
 */
public abstract class BaseFragment extends Fragment implements ActivityCall {

    private FragmentCallback mFragmentCallback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentCallback) {
            mFragmentCallback = (FragmentCallback) context;
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
}
