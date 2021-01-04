/**
 * @(#)Idempotent.java, 2019/8/19.
 * <p/>
 */
package com.net.seckill.po;

import lombok.Data;

@Data
public class Idempotent {

    private long id;

    private String record;

    private String tag;

    private long optTime;

}