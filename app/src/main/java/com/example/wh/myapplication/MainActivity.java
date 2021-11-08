package com.example.wh.myapplication;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.mylibrary.Common;
import com.example.mylibrary.Normal;
import com.example.mylibrary.TestLib;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button mBtn1, mBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn1 = findViewById(R.id.btn1);
        mBtn2 = findViewById(R.id.btn2);
        mBtn1.setOnClickListener(this::onClick);
        mBtn2.setOnClickListener(this::onClick);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                try {
                    PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), 0);
                    LogUtil.i(TAG, "onClick: pkgName = " + getPackageName());
                    LogUtil.i(TAG, "onClick: name = " + info.versionName + ", code = " + info.versionCode);
                    LogUtil.i(TAG, "onClick: name = " + getString(R.string.app_name) + ", label = " + getString(R.string.label_name));
                    new TestApp().print();
                } catch (PackageManager.NameNotFoundException e) {
                    LogUtil.e(TAG, "onClick: e = " + e.getMessage());
                }
                break;
            case R.id.btn2:
                new Common().testCommon();
                new Normal().testNormal();
                new TestLib().print();
                break;
        }
    }
}
