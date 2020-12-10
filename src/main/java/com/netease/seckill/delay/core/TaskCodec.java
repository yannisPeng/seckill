package com.netease.seckill.delay.core;

/**
 * Description: 编码
 *
 * @author 10014994
 * @since 2020/11/23
 */
public interface TaskCodec {

    /**
     * task codec to encode
     * @param value
     * @return
     */
    String encode(Object value);

    /**
     * task codec to decode
     * @param date
     * @return
     */
    <T> T decode(String date);

}
