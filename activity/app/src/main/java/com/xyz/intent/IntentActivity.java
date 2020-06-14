package com.xyz.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.xyz.BaseActivity;
import com.xyz.ClickItemView;
import com.xyz.lifecycle.R;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * created by john on 2020/6/7
 */
public class IntentActivity extends BaseActivity implements View.OnClickListener {
    private static Map<String, String> map;

    static {
        map = new LinkedHashMap<>();
        map.put("查看图片", Intent.ACTION_VIEW);
        map.put("分享信息", Intent.ACTION_SEND);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout container = new LinearLayout(this);
        container.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        container.setOrientation(LinearLayout.VERTICAL);
        setContentView(container);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String title = entry.getKey();
            String value = entry.getValue();
            ClickItemView itemView = new ClickItemView(this);
            itemView.setData(title, null);
            itemView.setTag(value);
            itemView.setOnClickListener(this);
            container.addView(itemView);
        }
    }

    @Override
    public void onClick(View v) {
        String value = (String) v.getTag();
        if (Intent.ACTION_VIEW.equals(value)) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); //注意加上这句话
            intent.setDataAndType(Uri.parse("http://img3.imgtn.bdimg.com/it/u=2534506313,1688529724&fm=26&gp=0.jpg"), ".jpg");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(IntentActivity.this, "暂无查看图片应用", Toast.LENGTH_SHORT).show();
            }
        } else if (Intent.ACTION_SEND.equals(value)) {
            //            Intent sendIntent = new Intent();
            //            sendIntent.setAction(Intent.ACTION_SEND);
            //            sendIntent.putExtra(Intent.EXTRA_TEXT, "分享信息");
            //            sendIntent.setType("text/plain");
            //            if (sendIntent.resolveActivity(getPackageManager()) != null) {
            //                startActivity(sendIntent);
            //            }

            Intent sendIntent = new Intent(Intent.ACTION_SEND);

            sendIntent.putExtra(Intent.EXTRA_TEXT, "分享信息");
            sendIntent.setType("text/plain");

            // Always use string resources for UI text.
            // This says something like "Share this photo with"
            String title = "Select title";
            // Create intent to show the chooser dialog
            Intent chooser = Intent.createChooser(sendIntent, title);


            // Verify the original intent will resolve to at least one activity
            if (sendIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(chooser);
            }
        }
    }
}
