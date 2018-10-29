package com.niles.appbase.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.niles.appbase.AppManager;
import com.niles.appbase.fragment.ActivityCall;
import com.niles.appbase.fragment.FragmentCallback;
import com.niles.http.HttpManager;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Niles
 * Date 2018/10/29 17:03
 * Email niulinguo@163.com
 */
public abstract class BaseActivity extends AppCompatActivity implements FragmentCallback {

    private BaseActivity mActivity;
    private HttpManager mHttpManager;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        mHttpManager = AppManager.getInstance().getHttpManager();
        mFragmentManager = getSupportFragmentManager();
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

    public HttpManager getHttpManager() {
        return mHttpManager;
    }

    protected BaseActivity thisActivity() {
        return mActivity;
    }

    @Override
    public Object onFragmentCallback(String method, HashMap<String, Object> params) {
        return null;
    }
}
