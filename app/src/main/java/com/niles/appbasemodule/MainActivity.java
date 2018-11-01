package com.niles.appbasemodule;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.niles.appbase.ui.base.BaseActivity;
import com.niles.appbase.ui.base.BasePresenter;

import java.util.HashMap;

public class MainActivity extends BaseActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.tv_activity_text);
    }

    public void callFragment(View view) {
        String text = (String) callFragment(MainFragment.class, "儿子，我是你爸Activity", null);
        mTextView.setText(String.format("%s来自Fragment的返回值:%s\n", mTextView.getText().toString(), text));
    }

    @Override
    public Object onFragmentCallback(String method, HashMap params) {
        mTextView.setText(String.format("%s来自Fragment的回调:%s\n", mTextView.getText().toString(), method));
        return "儿子，我收到了你说的:" + method;
    }
}
