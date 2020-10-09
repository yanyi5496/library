package com.chen;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.yanyi.aartest.R;
import com.yanyi.library.util.FunctionType;
import com.yanyi.library.dto.ApCloud;
import com.yanyi.library.dto.ApUser;
import com.yanyi.library.listener.OnHanResultListener;
import com.yanyi.library.service.HanFunction;
import com.yanyi.library.util.EncryptUtils;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "哈哈哈哈哈";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        HanFunction function = HanFunction.getInstance();
        final TextView textView = (TextView) findViewById(R.id.textView);
        String username = "Administrator";
        String password = "admin";
        ApUser apUser = new ApUser();
        ApUser.Param param = new ApUser.Param();
        param.username = username;
        param.password = EncryptUtils.md5(password);
        apUser.params = param;
        ApCloud cloud = new ApCloud("123", "FF:FF:FF:FF:FF:FF", "192.168.1.1");
        Log.d(TAG, cloud.toString());
        final String mac = "";
        function.execute(apUser, FunctionType.AP_LOGIN, new OnHanResultListener<String>() {
            @Override
            public void onError(Throwable t) {
                Log.d(TAG, "onError: " + t.getMessage());
            }

            @Override
            public void onSuccess(String str) {
                Log.d(TAG, "onSuccess: " + str);
                textView.setText(str);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}