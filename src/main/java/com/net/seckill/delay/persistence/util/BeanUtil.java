package com.net.seckill.delay.persistence.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Description: bean工具类
 *
 * @author 10014994
 * @since 2020/11/15
 */
public class BeanUtil implements ApplicationContextAware {

    private static final Logger log = LoggerFactory.getLogger(BeanUtil.class);

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static <T> T getInstance(Class<T> clazz){
        if(applicationContext == null){
            return instance(clazz);
        }
        return applicationContext.getBean(clazz);
    }

    private static <Z> Z instance(Class<Z> clazz) {
        try{
            return clazz.getDeclaredConstructor().newInstance();
        }catch (Exception e){
            log.error("无法创建Task实例:{}", clazz, e);
            throw new IllegalStateException(e);
        }
    }

}
