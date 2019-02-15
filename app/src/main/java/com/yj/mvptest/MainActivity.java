package com.yj.mvptest;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.ybf.utileslib.crash.CatchCrash;
import com.ybf.utileslib.regerstPermission.Permissions;


public class MainActivity extends Activity {
    int a =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Permissions.requestPermissionAll(this);
        CatchCrash.getInstance().setCustomCrashInfo(this);
        findViewById(R.id.btn_start_server).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int b = 3/0;

            }
        });

    }

    /**
     * 请求权限
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Permissions.changePermissionState(this,permissions[0],true);
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
