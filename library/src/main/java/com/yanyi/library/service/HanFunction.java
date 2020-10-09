package com.yanyi.library.service;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.yanyi.library.util.FunctionType;
import com.yanyi.library.listener.OnHanResultListener;

import java.lang.reflect.Method;

/**
 * 为外部提供接口服务
 */
public class HanFunction {

    private static HanFunction hanFunction;

    private HanFunction() {
    }

    public static HanFunction getInstance() {
        if (hanFunction == null) {
            hanFunction = new HanFunction();
        }
        return hanFunction;
    }


    /**
     * 回调结果为返回的字符串，需自处理
     *
     * @param json     请求参数json串
     * @param type     请求的具体操作
     * @param listener 回调监听
     */
    public void execute(String json, FunctionType type, OnHanResultListener<String> listener) {

        String url = type.getUrl();
        OkGo.<String>post(url)
                .upJson(json)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        listener.onSuccess(response.body());
                    }

                    @Override
                    public void onError(Response<String> response) {
                        listener.onError(response.getException());
                    }
                });
    }

    /**
     * 返回结果的对象
     *
     * @param json     请求参数json串
     * @param tClass   返回结果类
     * @param type     请求的具体操作
     * @param listener 回调监听
     * @param <T>      结果类
     */
    @Deprecated
    public <T> void execute(String json, Class<T> tClass, FunctionType type, OnHanResultListener<T> listener) {
        String url = type.getUrl();
        OkGo.<String>post(url)
                .upJson(json)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        try {
                            T t = gson.fromJson(response.body(), tClass);
                            listener.onSuccess(t);
                        } catch (Exception e) {
                            listener.onError(e);
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        listener.onError(response.getException());
                    }
                });
    }

    /**
     * @param t
     * @param type
     * @param listener
     * @param <T>
     */
    @SuppressWarnings("ConstantConditions")
    public <T> void execute(T t, FunctionType type, OnHanResultListener<String> listener) {
        String url = type.getUrl();
        Class<?> aClass = t.getClass();
        boolean flag = false;
        try {
            Method isValid = aClass.getMethod("isValid");
            flag = (Boolean) isValid.invoke(t);
        } catch (Exception e) {
            listener.onError(e);
        }

        if (flag) {
            OkGo.<String>post(url)
                    .upJson(new Gson().toJson(t))
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            listener.onSuccess(response.body());
                        }
                    });
        } else {
            listener.onError(new Exception("验证失败"));
        }

    }
}
