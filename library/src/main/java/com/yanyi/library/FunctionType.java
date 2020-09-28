package com.yanyi.library;

/**
 * 枚举类，提供功能的URL
 */
public enum FunctionType {
    AP_LOGIN("http://mywifi.han-networks.com:8080/echo.fcgi", "post"),
    AP_MODEL("http://mywifi.han-networks.com:8080/echo.fcgi", "post");
    String url;
    String method;

    private FunctionType(String url, String method) {
        this.url = url;
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

}
