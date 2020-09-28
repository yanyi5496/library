package com.yanyi.library.util;


import com.yanyi.library.util.Constant;

/**
 * @author bonan
 * AP接口集合
 */
public class HanApApi {

    /**
     * AP基础URL
     */
    public static String baseUrl() {
        return Constant.AP.BASE_URL;
    }

    /**
     * AP使用默认用户名密码登录
     */
    public static String login() {
        return Constant.AP.LOGIN;
    }

    /**
     * 给ap设置云服务的IP地址
     */
    public static String setIpAddress() {
        return Constant.AP.SET_IP_ADDRESS;
    }


}
