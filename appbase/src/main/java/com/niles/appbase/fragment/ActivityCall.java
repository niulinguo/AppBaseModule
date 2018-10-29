package com.niles.appbase.fragment;

import java.util.HashMap;

/**
 * Created by Niles
 * Date 2018/10/29 17:19
 * Email niulinguo@163.com
 */
public interface ActivityCall {

    Object onActivityCall(String method, HashMap<String, Object> params);
}
