package com.xyz;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.xyz.lifecycle.R;

/**
 * created by shenyonghui on 2020/5/27
 */
public class BaseActivity extends Activity {

    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        Log.e("xx", String.format("the Activity of %d is created", hashCode()));
        Log.e("xx", getClass().getSimpleName() + " onCreate");
    }

    public void setText(String text) {
        textView.setText(text);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("xx", getClass().getSimpleName() + " onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("xx", getClass().getSimpleName() + " onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("xx", getClass().getSimpleName() + " onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("xx", getClass().getSimpleName() + " onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("xx", getClass().getSimpleName() + " onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("xx", getClass().getSimpleName() + " onDestroy");
        Log.e("xx", String.format("the Activity of %d is finished", hashCode()));
        Log.e("xx", "\n");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("xx", getClass().getSimpleName() + " onSaveInstanceState");
        outState.putString("key", "hello world!");
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e("xx", getClass().getSimpleName() + " onConfigurationChanged");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e("xx", getClass().getSimpleName() + " onRestoreInstanceState");
        Log.e("xx", "key get :" + savedInstanceState.getString("key"));
    }
}
