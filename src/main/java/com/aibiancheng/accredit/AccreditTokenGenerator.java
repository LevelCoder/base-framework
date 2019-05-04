package com.aibiancheng.accredit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * 描述:授权token生成器
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/21
 */
public class AccreditTokenGenerator {

    /** 引入日志 */
    private static Logger logger = LoggerFactory.getLogger(AccreditTokenGenerator.class);


    /** 定义十六进制码值 */
    private static final char[] hexCode = "0123456789abcdef".toCharArray();

    /**
     * 生成token
     * @return
     */
    public static String generateValue() throws Exception {
        return generateValue(UUID.randomUUID().toString());
    }


    /**
     * 转换为16进制编码
     * @param data
     * @return
     */
    public static String toHexString(byte[] data) {
        if(data == null) {
            return null;
        }
        StringBuilder r = new StringBuilder(data.length*2);
        for ( byte b : data) {
            r.append(hexCode[(b >> 4) & 0xF]);
            r.append(hexCode[(b & 0xF)]);
        }
        return r.toString();
    }

    /**
     * 生成token
     * @param param
     * @return
     */
    public static String generateValue(String param) throws Exception {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(param.getBytes());
            byte[] messageDigest = algorithm.digest();
            return toHexString(messageDigest);
        } catch (Exception e) {
            logger.error("generate token fail e:{}",e);
            throw new Exception();
        }
    }
}
