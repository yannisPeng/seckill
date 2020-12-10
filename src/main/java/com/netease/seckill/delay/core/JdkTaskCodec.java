package com.netease.seckill.delay.core;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/11/23
 */
public class JdkTaskCodec implements TaskCodec {

    public static JdkTaskCodec INSTANCE = new JdkTaskCodec();

    @Override
    public String encode(Object value) {
        return null;
    }

    @Override
    public <T> T decode(String date) {
        return null;
    }

}
