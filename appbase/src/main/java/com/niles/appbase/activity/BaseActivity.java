package com.niles.appbase.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.blankj.utilcode.util.ToastUtils;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;
import com.niles.appbase.AppManager;
import com.niles.appbase.BuildConfig;
import com.niles.appbase.fragment.ActivityCall;
import com.niles.appbase.fragment.FragmentCallback;
import com.niles.appbase.mvp.BaseView;
import com.niles.http.HttpManager;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Niles
 * Date 2018/10/29 17:03
 * Email niulinguo@163.com
 */
public class BaseActivity extends AppCompatActivity implements FragmentCallback, BaseView {

    private BaseActivity mActivity;
    private HttpManager mHttpManager;
    private FragmentManager mFragmentManager;
    private LoadSir mLoadSir;
    private LoadService mLoadService;

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

    @Override
    public void showLoading(Class<? extends Callback> callback) {
        if (mLoadService == null) {
            mLoadService = getLoadSir().register(this);
        } else {
            if (callback == null) {
                Class<? extends Callback> defaultCallback = AppManager.getInstance().getAppConfig().getLoadingConfig().getDefaultCallback();
                mLoadService.showCallback(defaultCallback);
            } else {
                mLoadService.showCallback(callback);
            }
        }
    }

    @Override
    public void hideLoading() {
        if (mLoadService != null) {
            mLoadService.showSuccess();
        }
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

    protected final LoadSir getLoadSir() {
        if (mLoadSir == null) {
            mLoadSir = createLoadSir();
        }
        return mLoadSir;
    }

    protected LoadSir createLoadSir() {
        return LoadSir.getDefault();
    }
}
