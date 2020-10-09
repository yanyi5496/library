package com.yanyi.library.util;

import android.util.Base64;

import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;


public class EncryptUtils {

    /**
     * 公钥
     */
    private static String RSA_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDaXkCnsOmmMI/Gnz33t4xROpSh\n" +
            "mdR5kjAXShoVZxk0gDPyvkLTVscMicROfzfqIL6G4tGRav+jL1sN4uxBLUvTOYs+\n" +
            "+y6gLyL8iDPTV/ble1ZXKFlnpyUisoia5wUjbeymz/DA9+rHtNCOmo0yydRCSd81\n" +
            "kXzCK3mJASyV7CsjoQIDAQAB";

    /**
     * 小写字母MD5加密
     */
    public static String md5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] b = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < b.length; i++) {
                int v = b[i];
                v = v < 0 ? 0x100 + v : v;
                String cc = Integer.toHexString(v);
                if (cc.length() == 1) {
                    sb.append('0');
                }
                sb.append(cc);
            }
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 使用公钥进行RSA加密 再B64编码
     */
    public static String rsaEncrypt(String str) {
        try {
            //第一种获取PublicKey方式
            //InputStream inputStream = MyApplication.getInstance().getAssets().open("rsa_public_key.pem");
            //PublicKey publicKey1 = getPublicKeyFromIo(inputStream);
            //第二种获取PublicKey方式
            PublicKey publicKey2 = getPublicKeyFromStr(RSA_PUBLIC_KEY);

            //公钥加密字符串
            byte[] bytesMessageRsa = encryptData(str.getBytes(), publicKey2);

            //将加密后的字节码进行base64编码,变成可见字符  设置 Base64.NO_WRAP  略去所有的换行符
            //不进行B64编码会导致  Caused by: java.lang.ArrayIndexOutOfBoundsException: too much data for RSA block
            byte[] bytesB64Encode = Base64.encode(bytesMessageRsa, Base64.NO_WRAP);

            String strB64Encode = new String(bytesB64Encode);
            return strB64Encode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 用公钥加密
     * 每次加密的字节数，不能超过密钥的长度值减去11
     */
    public static byte[] encryptData(byte[] data, PublicKey publicKey) {
        try {
            //android的rsa加密方式是RSA/ECB/NoPadding，而标准jdk是RSA/ECB/PKCS1Padding，所以加密时要设置标准jdk的加密方式
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            //编码前设定编码方式及密钥
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            //传入编码数据并返回编码结果
            return cipher.doFinal(data);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 根据公钥字符串获取公钥对象
     */
    public static PublicKey getPublicKeyFromStr(String publicKeyStr) throws Exception {
        try {
            //勿使用Base64.DEFAULT  当字符串过长（一般超过76）时会自动在中间加一个换行符，字符串最后也会加一个换行符，
            //这样就导致和其他模块对接时结果不一致    使用Base64.NO_WRAP略去所有换行符
            byte[] buffer = Base64.decode(publicKeyStr, Base64.NO_WRAP);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(keySpec);
            return publicKey;
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e) {
            throw new Exception("公钥非法");
        } catch (NullPointerException e) {
            throw new Exception("公钥数据为空");
        }
    }


}
