package com.niles.appbase.ui.base;

import java.util.HashMap;

/**
 * Created by Niles
 * Date 2018/10/29 17:13
 * Email niulinguo@163.com
 */
public interface FragmentCallback {

    Object onFragmentCallback(String method, HashMap<String, Object> params);
}
