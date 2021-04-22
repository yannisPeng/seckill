package com.net.seckill.test;


import com.net.seckill.util.Md5Util;
import org.springframework.util.DigestUtils;

import java.security.MessageDigest;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Description:
 *
 * @author 10014994
 * @date: 2020/5/11
 */
public class Test extends AbstractQueuedSynchronizer {

//    static {
//        System.out.println("Test static");
//    }

    static final class TestStatic {
        static {
            System.out.println("TestStatic");
        }
    }

    public static void main(String[] args) {
        final String digestAsHex = DigestUtils.md5DigestAsHex("OCS".getBytes());
        final String md5 = Md5Util.getMD5("OCS");
//        System.out.println(digestAsHex.equals(md5));
        System.out.println(Md5Util.getMD5("OCS"));
//        System.out.println(Test.md5("OCS"));

        final byte[] bytes = "OCS".getBytes();
        for(byte b : bytes){
            System.out.println(b);
        }

    }

    /** MD5加密
     *
     * @param jiami
     *            源字符串
     * @return 加密后的字符串 */
    public final static String md5(String jiami) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] btInput = jiami.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
