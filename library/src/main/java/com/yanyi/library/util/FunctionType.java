package com.yanyi.library.util;

import com.yanyi.library.util.HanWanWeiApi;

/**
 * 枚举类，提供功能的URL
 */
public enum FunctionType {
    AP_LOGIN("http://mywifi.han-networks.com:8080/echo.fcgi"),
    AP_MODEL("http://mywifi.han-networks.com:8080/echo.fcgi"),
    CSP_LOGIN(HanWanWeiApi.login()),
    CSP_ASSIGNAP(HanWanWeiApi.cspAll()),
    CSP_SEARCHAP(HanWanWeiApi.searchApStatus());
    String url;


    FunctionType(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
