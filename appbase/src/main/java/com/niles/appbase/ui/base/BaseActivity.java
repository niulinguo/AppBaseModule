package com.niles.appbase.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.blankj.utilcode.util.ToastUtils;
import com.niles.appbase.BuildConfig;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Niles
 * Date 2018/10/29 17:03
 * Email niulinguo@163.com
 */
public class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements FragmentCallback, BaseView {

    private BaseActivity mActivity;
    private FragmentManager mFragmentManager;
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        mFragmentManager = getSupportFragmentManager();
        mPresenter = createPresenter();
    }

    protected P createPresenter() {
        return null;
    }

    protected P getPresenter() {
        return mPresenter;
    }

    protected Object callFragment(String method, HashMap<String, Object> params) {
        return callFragment(null, method, params);
    }

    protected Object callFragment(Class<? extends Fragment> fragmentClass, String method, HashMap<String, Object> params) {
        Object result = null;
        List<Fragment> fragments = mFragmentManager.getFragments();
        for (Fragment fragment : fragments) {
            if (fragmentClass == null || fragment.getClass() == fragmentClass) {
                if (fragment instanceof ActivityCall) {
                    result = ((ActivityCall) fragment).onActivityCall(method, params);
                }
            }
        }
        return result;
    }

    protected BaseActivity thisActivity() {
        return mActivity;
    }

    @Override
    public Object onFragmentCallback(String method, HashMap<String, Object> params) {
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
