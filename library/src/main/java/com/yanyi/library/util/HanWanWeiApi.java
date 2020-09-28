package com.yanyi.library.util;


import com.yanyi.library.util.Constant;

/**
 * @author bonan
 * 中电万维接口地址集合
 */
public class HanWanWeiApi {

    /**
     * 设置url的基础域名或IP
     */
    public static String urlAddress;

    /**
     * 创建CSP用户接口
     */
    public static String createCspUserUrl() {
        return Constant.WANWEI.CREATE_CSP_USER;
    }

    /**
     * 万维用户查询自己所创建的CSP用户
     */
    public static String searchCspUser() {
        return Constant.WANWEI.SEARCH_CSP_USER;
    }

    /**
     * 根据CSP用户ID查询所有owner权限的场所
     */
    public static String searchCspSite() {
        return Constant.WANWEI.SEARCH_CSP_SITE;
    }

    /**
     * 创建CSP集团
     */
    public static String createCspCorp() {
        return Constant.WANWEI.CREATE_CSP_CORP;
    }

    /**
     * 创建CSP场所
     */
    public static String createCspSite() {
        return Constant.WANWEI.CREATE_CSP_SITE;
    }

    /**
     * 创建场所SSID
     */
    public static String createCspSiteSsid() {
        return Constant.WANWEI.CREATE_CSP_SITE_SSID;
    }

    /**
     * 分配AP到场所
     */
    public static String apDistribute() {
        return Constant.WANWEI.AP_DISTRIBUTE;
    }

    /**
     * 整体配置（包含上述功能）
     */
    public static String cspAll() {
        return Constant.WANWEI.CSP_ALL;
    }

    /**
     * 查询AP注册状态
     */
    public static String searchApStatus() {
        return Constant.WANWEI.SEARCH_AP_STATUS;
    }

    /**
     * CSP系统鉴权(登录)
     */
    public static String login() {
        return Constant.WANWEI.LOGIN;
    }


}
