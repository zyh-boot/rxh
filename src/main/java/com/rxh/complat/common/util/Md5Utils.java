package com.rxh.complat.common.util;

import com.alibaba.fastjson.JSONObject;
import com.rxh.complat.common.exception.GlobalException;
import com.rxh.complat.common.exception.MyException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.crypto.dsig.DigestMethod;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 *
 * @Description: MD5加密
 * @Author Zhang YuHui 
 * @Date 2021/1/6 18:34
 *
 */
public class Md5Utils {

    private static final String SALT = "zyh";


    /**
     * @Description MD5加密
     * @author Zhang YuHui
     * @date 2021/1/6 18:39
     *
     * @params str  原字符串
     * @params salt 加盐
     * @return java.lang.String
     */
    public static String md5Encode(String str, String salt) {
        if (StringUtils.isEmpty(salt)) {
            salt = SALT;
        }
        return DigestUtils.md5DigestAsHex((str + salt).getBytes());
    }

    /**
     * @Description generateKey 生成随机密钥对
     * @author Zhang YuHui
     * @date 2021/1/7 15:06
     *
     * @params
     * @return com.alibaba.fastjson.JSONObject
     */
    private static JSONObject rsaGenerateKey() throws NoSuchAlgorithmException {
        String privateKey;
        String publicKey;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为512-16384位 超出范围会报错 密钥越大生成速度会越慢
        keyPairGenerator.initialize(1024, new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        //私钥
        RSAPrivateKey aPrivate = (RSAPrivateKey) keyPair.getPrivate();
        //公钥
        RSAPublicKey aPublic = (RSAPublicKey) keyPair.getPublic();

        privateKey = new String(Base64.getEncoder().encode(aPrivate.getEncoded()));
        publicKey = new String(Base64.getEncoder().encode(aPublic.getEncoded()));

//        System.out.println("生成私钥: " + privateKey);
//        System.out.println("生成公钥: " + publicKey);

        JSONObject object = new JSONObject();
        object.put("publicKey", publicKey);
        object.put("privateKey", privateKey);
        object.put("publicObj", aPublic);
        object.put("privateObj", aPrivate);
        return object;
    }

    /**
     * @Description encryption 加密
     * @author Zhang YuHui
     * @date 2021/1/7 11:09
     *
     * @params str  源字符串
     * @params publicKey 公钥
     * @return java.lang.String
     */
    private static String rsaEncryption(String str, String publicKey) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        byte[] decode = Base64.getDecoder().decode(publicKey);
        RSAPublicKey rsa = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decode));

        Cipher rsa1 = Cipher.getInstance("RSA");
        rsa1.init(Cipher.ENCRYPT_MODE, rsa);
        String s = Base64.getEncoder().encodeToString(rsa1.doFinal(str.getBytes("UTF-8")));
        System.out.println("加密后的字符: " + s);
        return s;
    }


    /**
     * @Description decrypt RSA解密
     * @author Zhang YuHui
     * @date 2021/1/7 10:52
     *
     * @params str  加密字符串
     * @params privateKey  私钥
     * @return java.lang.String
     */
    public static String rsaDecrypt(String str, String privateKey) throws Exception {
        byte[] strDecode = Base64.getDecoder().decode(str.getBytes("UTF-8"));


        byte[] decode = Base64.getDecoder().decode(privateKey);
        RSAPrivateKey rsa = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decode));

        Cipher rsa1 = Cipher.getInstance("RSA");
        rsa1.init(Cipher.DECRYPT_MODE, rsa);
        String s = new String(rsa1.doFinal(strDecode));
        System.out.println("解密后的字符: " + s);
        return s;
    }

    /**
     * @Description digitalSignature 数字签名
     * @author Zhang YuHui
     * @date 2021/1/7 15:51
     *
     * @params str 元素据
     * @params privateKey 个人的私钥
     * @return 数字签名
     */
    public static String rsaDigitalSignature(String str, RSAPrivateKey privateKey) throws Exception {

        RSAPrivateKey rsa = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(privateKey.getEncoded()));
        //签名
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initSign(rsa);
        signature.update(str.getBytes());
        byte[] sign = signature.sign();
//        String s = new String(sign);
//        Integer.toString(s.hashCode());
        return Hex.encodeHexString(sign);
    }

    /**
     * @Description digitalVerification 数字签名验签
     * @author Zhang YuHui
     * @date 2021/1/7 15:55
     *
     * @params str 接收的数据
     * @params sign 数字签名
     * @params publicKey 公钥
     * @return boolean 是否通过
     */
    public static boolean rsaDigitalVerification(String str, String sign, RSAPublicKey publicKey) throws Exception {

        byte[] bytes = Hex.decodeHex(sign.toCharArray());
        PublicKey rsa = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(publicKey.getEncoded()));

        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(rsa);
        signature.update(str.getBytes());
        boolean verify = signature.verify(bytes);

        return verify;
    }


    /**
     * @Description base64Encryption base64加密
     * @author Zhang YuHui
     * @date 2021/1/7 14:59
     *
     * @params str 原字符串
     * @params encoding 编码字符集
     * @return 加密后的字符
     */
    public static String base64Encryption(String str, String encoding) {
        String encodeStr = "";
        try {
            encodeStr = Base64.getEncoder().encodeToString(str.getBytes(encoding));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println();
            new MyException("不支持该字符集");
        }
        return encodeStr;
    }

    /**
     * @Description base64Decrypt base64解密
     * @author Zhang YuHui
     * @date 2021/1/7 15:00
     *
     * @params str 加密后的字符
     * @params encoding 编码字符集
     * @return 解密后的字符
     */
    public static String base64Decrypt(String str, String encoding) {
        byte[] decode = new byte[0];
        try {
            decode = Base64.getDecoder().decode(str.getBytes(encoding));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            new MyException("不支持该字符集");
        }

        return new String(decode);
    }


}
