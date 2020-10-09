package com.yanyi.library.dto;

import com.yanyi.library.util.HanApApi;

import java.io.Serializable;

/**
 * 登录到AP的请求参数实体
 * {
 * "id": 1,
 * "jsonrpc": "2.0",
 * "username": "Administrator",
 * "method": "user.login",
 * "params": {
 * "username": "Administrator",
 * "password": "21232f297a57a5a743894a0e4a801fc3"
 * }
 * }
 */
public class ApUser implements Serializable {
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
     * 通过 HanApApi.login()获取
     */
    public String method = HanApApi.login();
    /**
     * 具体参数信息
     */
    public Param params;

    /**
     * 参数类
     */
    public static class Param {
        /**
         * 用户名
         * Administrator
         */
        public String username;
        /**
         * 管理员密码
         * 对admin进行小写md5
         */
        public String password;

        @Override
        public String toString() {
            return "Param{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ApUser{" +
                "id=" + id +
                ", jsonrpc='" + jsonrpc + '\'' +
                ", username='" + username + '\'' +
                ", method='" + method + '\'' +
                ", params=" + params +
                '}';
    }

    public boolean isValid() {
        return true;
    }
}
