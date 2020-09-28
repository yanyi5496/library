package com.chen;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.yanyi.aartest.R;
import com.yanyi.library.FunctionType;
import com.yanyi.library.dto.ApInfo;
import com.yanyi.library.listener.OnHanResultListener;
import com.yanyi.library.service.HanFunction;
import com.yanyi.library.util.EncryptUtils;
import com.yanyi.library.util.HanApApi;

import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        HanFunction function = HanFunction.getInstance();
        String username = "Administrator";
        String password = "admin";
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", 1);
        params.put("jsonrpc", "2.0");
        params.put("username", username);
        params.put("method", HanApApi.login());
        HashMap<String, Object> params2 = new HashMap<>();
        params2.put("username", username);
        params2.put("password", EncryptUtils.md5(password));
        params.put("params", params2);
        JSONObject jsonObject = new JSONObject(params);
        function.execute(jsonObject.toString(), ApInfo.class, FunctionType.AP_LOGIN, new OnHanResultListener<ApInfo>() {
            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onSuccess(ApInfo apInfo) {
                Log.d(TAG, apInfo.toString());
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