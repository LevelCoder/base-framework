package com.aibiancheng.utils.message;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;

/**
 * 描述:
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/7/5
 */
public class RSAUtil {
    public static String KEY_PAIRGENO = "RSA";
    public static String PUBLIC_KEY = "PUBLIC_KEY";
    public static String PRIVATE_KEY = "PRIVATE_KEY";

    public static HashMap<String, Object> keyMap;

    public static HashMap<String, Object> initKey() throws Exception {
        KeyPairGenerator keyPairGeno = KeyPairGenerator.getInstance("RSA");
        keyPairGeno.initialize(1024);
        KeyPair keyPair = keyPairGeno.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        keyMap = new HashMap<String, Object>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }

    public static String getPublicKey() {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        byte[] bytes = key.getEncoded();
        return Base64.encode(bytes);
    }

    public static String getPrivateKey() {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        byte[] bytes = key.getEncoded();

        return Base64.encode(bytes);
    }

    // 通过公钥byte[]将公钥还原，适用于RSA算法

    public static PublicKey getPublicKey(byte[] keyBytes) throws Exception {

        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        return publicKey;

    }

    // 通过私钥byte[]将公钥还原，适用于RSA算法

    public static PrivateKey getPrivateKey(byte[] keyBytes) throws Exception {

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;

    }

    /**
     * 公钥加密
     *
     * @param data
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static String encryptByPublicKey(String data, RSAPublicKey publicKey)
            throws Exception {
        Cipher cipher = Cipher.getInstance(KEY_PAIRGENO);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        // 模长
        int key_len = publicKey.getModulus().bitLength() / 8;
        // 加密数据长度 <= 模长-11
        String[] datas = splitString(data, key_len - 11);
        String mi = "";
        // 如果明文长度大于模长-11则要分组加密
        for (String s : datas) {
            mi += bcd2Str(cipher.doFinal(s.getBytes()));
        }
        return mi;
    }
    /**
     * 私钥解密
     *
     * @param data
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static String decryptByPrivateKey(String data,
                                             RSAPrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance(KEY_PAIRGENO);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        // 模长
        int key_len = privateKey.getModulus().bitLength() / 8;
        byte[] bytes = data.getBytes();
        byte[] bcd = ASCII_To_BCD(bytes, bytes.length);
        // 如果密文长度大于模长则要分组解密
        String ming = "";
        byte[][] arrays = splitArray(bcd, key_len);
        for (byte[] arr : arrays) {
            ming += new String(cipher.doFinal(arr));
        }
        return ming;
    }
    /**
     * ASCII码转BCD码
     *
     */
    public static byte[] ASCII_To_BCD(byte[] ascii, int asc_len) {
        byte[] bcd = new byte[asc_len / 2];
        int j = 0;
        for (int i = 0; i < (asc_len + 1) / 2; i++) {
            bcd[i] = asc_to_bcd(ascii[j++]);
            bcd[i] = (byte) (((j >= asc_len) ? 0x00 : asc_to_bcd(ascii[j++])) + (bcd[i] << 4));
        }
        return bcd;
    }
    public static byte asc_to_bcd(byte asc) {
        byte bcd;
        if ((asc >= '0') && (asc <= '9'))
            bcd = (byte) (asc - '0');
        else if ((asc >= 'A') && (asc <= 'F'))
            bcd = (byte) (asc - 'A' + 10);
        else if ((asc >= 'a') && (asc <= 'f'))
            bcd = (byte) (asc - 'a' + 10);
        else
            bcd = (byte) (asc - 48);
        return bcd;
    }
    /**
     * BCD转字符串
     */
    public static String bcd2Str(byte[] bytes) {
        char temp[] = new char[bytes.length * 2], val;
        for (int i = 0; i < bytes.length; i++) {
            val = (char) (((bytes[i] & 0xf0) >> 4) & 0x0f);
            temp[i * 2] = (char) (val > 9 ? val + 'A' - 10 : val + '0');

            val = (char) (bytes[i] & 0x0f);
            temp[i * 2 + 1] = (char) (val > 9 ? val + 'A' - 10 : val + '0');
        }
        return new String(temp);
    }

    /**
     * 拆分字符串
     */
    public static String[] splitString(String string, int len) {
        int x = string.length() / len;
        int y = string.length() % len;
        int z = 0;
        if (y != 0) {
            z = 1;
        }
        String[] strings = new String[x + z];
        String str = "";
        for (int i = 0; i < x + z; i++) {
            if (i == x + z - 1 && y != 0) {
                str = string.substring(i * len, i * len + y);
            } else {
                str = string.substring(i * len, i * len + len);
            }
            strings[i] = str;
        }
        return strings;
    }
    /**
     *拆分数组
     */
    public static byte[][] splitArray(byte[] data, int len) {
        int x = data.length / len;
        int y = data.length % len;
        int z = 0;
        if (y != 0) {
            z = 1;
        }
        byte[][] arrays = new byte[x + z][];
        byte[] arr;
        for (int i = 0; i < x + z; i++) {
            arr = new byte[len];
            if (i == x + z - 1 && y != 0) {
                System.arraycopy(data, i * len, arr, 0, y);
            } else {
                System.arraycopy(data, i * len, arr, 0, len);
            }
            arrays[i] = arr;
        }
        return arrays;
    }


    public static void main(String[] args) throws Exception {
        try {
            RSAUtil.initKey();//执行完后可通过getPublicKey()或getPrivateKey()方法获取这这一对密钥(随机生成)
        } catch (Exception e) {
            e.printStackTrace();
        }
        String pubKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDPlQvtX35lWpNkuFpB5/+TkBuruYIOjt7xWsAJ"
                + "QL2nUI5Opn6Ug2NpwvwBV/kXIaNRGj8ih96tKIjSTe8qdXeLyjhRNdk0Sb300/Zv8NvVhxLiNEsc"
                + "3uR2BvV03in/blhYfCoU0D6Wwyl6tz3ucjRKr0hUcgUX+AqJHuiPIbwzYwIDAQAB";

        String priKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAM+VC+1ffmVak2S4WkHn/5OQG6u5"
                + "gg6O3vFawAlAvadQjk6mfpSDY2nC/AFX+Rcho1EaPyKH3q0oiNJN7yp1d4vKOFE12TRJvfTT9m/w"
                + "29WHEuI0Sxze5HYG9XTeKf9uWFh8KhTQPpbDKXq3Pe5yNEqvSFRyBRf4Coke6I8hvDNjAgMBAAEC"
                + "gYEAtv2QNyAgf16aYoa1YjYPMlkuW3K8OPMvi5pRgZal2ZIE8UaKfYdZosk1eEXCGucXXo6Bq4IV"
                + "BZafDq2PMWG+EFDtH9yVylQvvdOF0wB82vSYIdohmRiv9/Nz0lGiEpgkNOPl3llWl9CIoU6IPI4F"
                + "mRpB8/qpR38R0TLTXy8mnkkCQQD1NrFaXdGLJJtmtWboZ3rJRfyeugeBE+sgtZ7lR1nhGCT3jdtm"
                + "c+lFZyuVaRexW142ujRs5s8t2gUTpZeRnnKtAkEA2LaXzGQdIIbc0VCoOqND0lMz2srYw9Y4cERW"
                + "wJYFwVSvrY83wU1uVEt/bknKGe0BTELkZ7tpZaDAN0ltdtwQTwJBAI0umTxDShNH12VySjbC5ZIf"
                + "BozI5OsvcbAagcrWouwTv6z8cvbxA7ze4twabvbBeWQfH3IYDe8DWOrv621/Ad0CQAFm7QR9gVK8"
                + "jKEuDGiUtdOehi9cMJrTv/m593W3gsIFcj2FN68geR5CfsiP4abZSbDcne2t4LivmY7CAttKATEC"
                + "QQDxsduPOS2bxut5XDXkdxtklUF77unjj3fRdu3S00SEc9CBRdcQwmIqolUvIgrsOr3o7xTheIEb"
                + "s8Zqt9218PZU";
        String ming = "abc";
        //用公钥加密
        String mi = RSAUtil.encryptByPublicKey(ming, (RSAPublicKey) RSAUtil.getPublicKey(Base64.decode(pubKey)));
        System.out.println("mi : " + mi);
        //用私钥解密
        System.out.println("ming : " + RSAUtil.decryptByPrivateKey(mi, (RSAPrivateKey) RSAUtil.getPrivateKey(Base64.decode(priKey))));
    }
}
