package com.xyz.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

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
