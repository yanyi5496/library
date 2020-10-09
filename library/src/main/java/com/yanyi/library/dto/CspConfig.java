package com.yanyi.library.dto;

/**
 * AP分配到CSP账户下的配置
 */
public class CspConfig {
    /**
     * CSP用户名称
     * 必须
     */
    public String username;
    /**
     * CSP用户密码 小写md5后使用RSA加密 然后再base64编码
     * 必须
     */
    public String pwd;
    /**
     * CSP用户邮箱
     * 必须
     */
    public String email;
    /**
     * CSP用户手机号
     * 必须
     */
    public String telephone;
    /**
     * 集团名称
     */
    public String corpname;
    /**
     * 集团描述
     */
    public String corpdescribe;
    /**
     * 场所名称
     * 必须
     */
    public String sitename;
    /**
     * 场所描述
     */
    public String sitedescribe;
    /**
     * SSID名称
     */
    public String ssidname;
    /**
     * PSK密码
     */
    public String pskpwd;
    /**
     * 登录到AP之后返回的MAC地址
     * 必须
     */
    public String apmacs;
}
