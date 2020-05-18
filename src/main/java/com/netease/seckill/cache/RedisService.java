///**
// * @(#)RedisService.java, 2019/8/15.
// * <p/>
// * Copyright 2019 Netease, Inc. All rights reserved.
// * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
// */
//package com.netease.seckill.cache;
//
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.alibaba.fastjson.JSON;
//
///**
// * @author 彭羽(pengyu @ .corp.netease.com)
// */
//@Service
//public class RedisService {
//
//    @Autowired
//    JedisPool jedisPool;
//
//    /**
//     * 获取当个对象
//     */
//    public <T> T get(String key, Class<T> clazz) {
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            //生成真正的key
//            String realKey = key;
//            String str = jedis.get(realKey);
//            T t = stringToBean(str, clazz);
//            return t;
//        } finally {
//            returnToPool(jedis);
//        }
//    }
//
//
//    /**
//     * 设置对象
//     */
//    public <T> boolean set(String key, T value) {
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            String str = beanToString(value);
//            if (str == null || str.length() <= 0) {
//                return false;
//            }
//            //生成真正的key
//            String realKey = key;
//            int seconds = 0;
//            if (seconds <= 0) {
//                jedis.set(realKey, str);
//            } else {
//                jedis.setex(realKey, seconds, str);
//            }
//            return true;
//        } finally {
//            returnToPool(jedis);
//        }
//    }
//
//    /**
//     * 判断key是否存在
//     */
//    public <T> boolean exists(String key) {
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            //生成真正的key
//            String realKey = key;
//            return jedis.exists(realKey);
//        } finally {
//            returnToPool(jedis);
//        }
//    }
//
//    /**
//     * 增加值
//     */
//    public <T> Long incr(String key) {
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            //生成真正的key
//            String realKey = key;
//            return jedis.incr(realKey);
//        } finally {
//            returnToPool(jedis);
//        }
//    }
//
//    /**
//     * 减少值
//     */
//    public <T> Long decr(String key) {
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            //生成真正的key
//            String realKey = key;
//            return jedis.decr(realKey);
//        } finally {
//            returnToPool(jedis);
//        }
//    }
//
//    private <T> String beanToString(T value) {
//        if (value == null) {
//            return null;
//        }
//        Class<?> clazz = value.getClass();
//        if (clazz == int.class || clazz == Integer.class) {
//            return "" + value;
//        } else if (clazz == String.class) {
//            return (String) value;
//        } else if (clazz == long.class || clazz == Long.class) {
//            return "" + value;
//        } else {
//            return JSON.toJSONString(value);
//        }
//    }
//
//    @SuppressWarnings("unchecked")
//    private <T> T stringToBean(String str, Class<T> clazz) {
//        if (str == null || str.length() <= 0 || clazz == null) {
//            return null;
//        }
//        if (clazz == int.class || clazz == Integer.class) {
//            return (T) Integer.valueOf(str);
//        } else if (clazz == String.class) {
//            return (T) str;
//        } else if (clazz == long.class || clazz == Long.class) {
//            return (T) Long.valueOf(str);
//        } else {
//            return JSON.toJavaObject(JSON.parseObject(str), clazz);
//        }
//    }
//
//    private void returnToPool(Jedis jedis) {
//        if (jedis != null) {
//            jedis.close();
//        }
//    }
//
//}
