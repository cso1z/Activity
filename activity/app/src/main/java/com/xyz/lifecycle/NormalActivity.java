package com.xyz.lifecycle;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.xyz.BaseActivity;

/**
 * created by shenyonghui on 2020/5/27
 */
public class NormalActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setText("正常声明周期");

    }
}
