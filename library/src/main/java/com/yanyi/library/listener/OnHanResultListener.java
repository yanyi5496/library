package com.yanyi.library.listener;

/**
 * 回调接口
 */
public  interface  OnHanResultListener<T> {
    /**
     * 发生错误的回调方法
     * @param t
     */
    void onError(Throwable t);

    /**
     * 请求成功的回调方法
     * @param t
     */
    void onSuccess(T t);
}
