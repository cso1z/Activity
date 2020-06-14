package com.xyz.lifecycle;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.xyz.BaseActivity;

/**
 * created by shenyonghui on 2020/5/27
 */
public class ConfigChangeActivity2 extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setText("配置修改 生命周期(忽略屏幕旋转配置改变)");
    }
}