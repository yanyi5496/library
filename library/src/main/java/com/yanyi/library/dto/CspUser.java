package com.yanyi.library.dto;

/**
 * csp用户信息
 */
public class CspUser {
    /**
     * 万维CSP用户名
     */
    public String account;
    /**
     * CSP密码 小写md5后使用RSA加密 然后再base64编码
     */
    public String pwd;

}
