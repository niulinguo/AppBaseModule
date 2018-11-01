package com.niles.appbasemodule;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.niles.appbase.activity.BaseActivity;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.tv_activity_text);

        showLoading(null);
        getHttpManager().getService(ApiService.class).test().enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(@NonNull Call<JsonObject> call, @NonNull Response<JsonObject> response) {
                hideLoading();
                JsonObject body = response.body();
                if (body != null) {
                    String msg = body.get("msg").getAsString();
                    Toast.makeText(thisActivity(), msg, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<JsonObject> call, @NonNull Throwable t) {
                hideLoading();
            }
        });
    }

    public void callFragment(View view) {
        String text = (String) callFragment(MainFragment.class, "儿子，我是你爸Activity", null);
        mTextView.setText(String.format("%s来自Fragment的返回值:%s\n", mTextView.getText().toString(), text));
    }

    @Override
    public Object onFragmentCallback(String method, HashMap<String, Object> params) {
        mTextView.setText(String.format("%s来自Fragment的回调:%s\n", mTextView.getText().toString(), method));
        return "儿子，我收到了你说的:" + method;
    }
}
