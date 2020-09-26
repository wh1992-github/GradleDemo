package com.example.wh.myapplication;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mylibrary.A;
import com.example.mylibrary.B;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "whdemo--MainActivity";
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
                    Log.i(TAG, "onClick: pkgName = " + getPackageName());
                    Log.i(TAG, "onClick: name = " + info.versionName + ", code = " + info.versionCode);
                    Log.i(TAG, "onClick: name = " + getString(R.string.app_name) + ", label = " + getString(R.string.label_name));
                    new Test().print();
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn2:
                new A().testA(TAG);
                new B().testB(TAG);
                break;
        }
    }

}
