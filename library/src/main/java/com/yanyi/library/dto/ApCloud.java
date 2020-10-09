package com.yanyi.library.dto;

import com.yanyi.library.util.HanApApi;

/**
 * 给ap设置云服务的IP地址请求参数
 * 可直接使用提供的有参构造方法
 */
public class ApCloud {
    /**
     * 固定参数
     * 1
     */
    public int id = 1;
    /**
     * 固定参数
     * 2.0
     */
    public String jsonrpc = "2.0";
    /**
     * 用户名
     * Administrator
     */
    public String username = "Administrator";
    /**
     * 请求方法
     * 通过HanApApi.setIpAddress()获取
     */
    public String method = HanApApi.setIpAddress();
    /**
     * Session值
     * AP登录之后返回的sessinId值
     */
    public String session;
    /**
     * 固定值
     */
    public String topic = "WMA/TEST";
    /**
     * 具体参数信息
     */
    public Param param;

    /**
     * 参数类
     */
    public static class Param {
        /**
         * 固定参数
         */
        public String version = "3.0";
        /**
         * 固定参数
         */
        public int messageID = 2;
        /**
         * 第一步登陆时传回的AP的MAC地址
         */
        public String macAddress;
        /**
         * 固定参数
         */
        public String option = "select";
        /**
         * 固定参数
         */
        public String method = "ap_manage.cfg_manage";
        public Contents contents;
    }

    public static class Contents {
        /**
         * 固定参数
         */
        public int config_type = 1;
        public Content content;
    }

    public static class Content {
        public ApMgr ap_mgr;
    }

    public static class ApMgr {
        /**
         * AP模式 固定参数
         */
        public String mgr_mode = "CLOUD";
        /**
         * 指向的云服务的IP地址
         */
        public String mgr_addr;
    }

    public ApCloud() {
    }

    public ApCloud(String session, String macAddress, String mgr_addr) {
        ApMgr apMgr = new ApMgr();
        apMgr.mgr_addr = mgr_addr;

        Content content = new Content();
        content.ap_mgr = apMgr;

        Contents contents = new Contents();
        contents.content = content;

        Param param = new Param();
        param.macAddress = macAddress;
        param.contents = contents;

        this.session = session;
        this.param = param;
    }

    @Override
    public String toString() {
        return "ApCloud{" +
                "id=" + id +
                ", jsonrpc='" + jsonrpc + '\'' +
                ", username='" + username + '\'' +
                ", method='" + method + '\'' +
                ", session='" + session + '\'' +
                ", topic='" + topic + '\'' +
                ", param=" + param +
                '}';
    }
}
