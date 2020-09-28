package com.yanyi.library.util;

/**
 * @author bonan
 */
public final class Constant {

    /**
     * AP相关URL
     */
    public static final class AP {

        public static String BASE_URL = "http://mywifi.han-networks.com:8080/echo.fcgi";

        /**
         * AP登录
         */
        public static String LOGIN = "user.login";

        /**
         * 设置云服务地址
         */
        public static String SET_IP_ADDRESS = "expressmessage.call";
    }

    /**
     * 中电万维相关URL
     */
    public static final class WANWEI {

        public static String BASE_URL = "https://" + HanWanWeiApi.urlAddress + "/apiv1/wanwei/csp/";

        /**
         * 创建CSP用户
         */
        public static String CREATE_CSP_USER = BASE_URL + "user/add";

        /**
         * 万维用户查询自己所创建的CSP用户
         */
        public static String SEARCH_CSP_USER = BASE_URL + "user/list";

        /**
         * 根据CSP用户ID查询所有owner权限的场所
         */
        public static String SEARCH_CSP_SITE = BASE_URL + "user/sites";

        /**
         * 创建CSP集团
         */
        public static String CREATE_CSP_CORP = BASE_URL + "corp/add";

        /**
         * 创建CSP场所
         */
        public static String CREATE_CSP_SITE = BASE_URL + "site/add";

        /**
         * 创建场所SSID
         */
        public static String CREATE_CSP_SITE_SSID = BASE_URL + "ssid/add";

        /**
         * 分配AP到场所
         */
        public static String AP_DISTRIBUTE = BASE_URL + "ap/distribute";

        /**
         * 整体配置（包含上述功能）
         */
        public static String CSP_ALL = BASE_URL + "all";

        /**
         * 查询AP注册状态
         */
        public static String SEARCH_AP_STATUS = BASE_URL + "account/aps";

        /**
         * CSP系统鉴权
         */
        public static String LOGIN = BASE_URL + "login";
    }

}
