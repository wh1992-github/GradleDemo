package com.example.wh.myapplication;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "whdemo--MainActivity";
    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                Log.i(TAG, "onClick: btn");
                try {
                    PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), 0);
                    Log.i(TAG, "onClick: name = " + info.versionName + ", code = " + info.versionCode);
                    Log.i(TAG, "onClick: app name = "+getString(R.string.app_name));
                    Log.i(TAG, "onClick: app name = "+getString(R.string.app_name2));
                    new Test().print();
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

}
