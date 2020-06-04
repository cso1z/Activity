package com.xyz.activity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainActivity extends BaseActivity {
    private static Map<String, Class> map;

    static {
        map = new LinkedHashMap<>();
        map.put("正常生命周期", NormalActivity.class);
        map.put("配置修改", ConfigChangeActivity1.class);
        map.put("配置修改(在配置文件中忽略相关配置)", ConfigChangeActivity2.class);
        map.put("权限修改生命周期", PermissionChangeActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout container = new LinearLayout(this);
        container.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        container.setOrientation(LinearLayout.VERTICAL);
        setContentView(container);
        for (Map.Entry<String, Class> entry : map.entrySet()) {
            String title = entry.getKey();
            Class clazz = entry.getValue();
            ClickItemView itemView = new ClickItemView(this);
            itemView.setData(title, clazz);
            itemView.requestLayout();
            container.addView(itemView);
        }
    }
}
