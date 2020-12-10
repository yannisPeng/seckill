package com.netease.seckill.util;

import lombok.Data;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/11/21
 */
public class ContextUtil {

    private static final ThreadLocal threadLocal = new ThreadLocal();

    public static Object getThreadLocal(){
        return threadLocal.get();
    }

    public static void setThreadLocal(Object value){
        threadLocal.set(value);
    }

}
