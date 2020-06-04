package com.xyz.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * 配置修改時生命周期(旋轉）
 * created by shenyonghui on 2020/5/27
 */
public class ConfigChangeActivity1 extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setText("配置修改 生命周期");
    }
}