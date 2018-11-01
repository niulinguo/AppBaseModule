package com.niles.appbasemodule;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.niles.appbase.ui.base.BaseFragment;

import java.util.HashMap;

/**
 * Created by Niles
 * Date 2018/10/29 17:43
 * Email niulinguo@163.com
 */
public class MainFragment extends BaseFragment {

    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mTextView = new TextView(getContext());
        mTextView.setText(MainFragment.class.getName());
        return mTextView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = (String) fragmentCallback("Hi，爸爸，我是Fragment", null);
                mTextView.setText(String.format("%s来自Activity的返回值:%s\n", mTextView.getText().toString(), text));
            }
        });
    }

    @Override
    public Object onActivityCall(String method, HashMap params) {
        mTextView.setText(String.format("%s来自Activity的回调:%s\n", mTextView.getText().toString(), method));
        return "爸爸，我收到了你说的:" + method;
    }
}
