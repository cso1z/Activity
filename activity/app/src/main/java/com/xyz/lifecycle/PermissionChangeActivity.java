package com.xyz.lifecycle;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.xyz.BaseActivity;

/**
 * created by shenyonghui on 2020/5/27
 */
public class PermissionChangeActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setText("权限改变时生命周期");
        // sd卡权限
        String[] SdCardPermission = {Manifest.permission.READ_EXTERNAL_STORAGE};
        if (ContextCompat.checkSelfPermission(this, SdCardPermission[0]) != PackageManager.PERMISSION_GRANTED) {
            // 如果没有授予该权限，就去提示用户请求
            ActivityCompat.requestPermissions(this, SdCardPermission, 100);
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    .setData(Uri.fromParts("package", getPackageName(), null));
            startActivity(intent);
        } else {
            Log.e("xx", "ex");
        }
    }
}