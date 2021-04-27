package com.net.seckill.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class PipelineTest {

    private static Jedis jedis;

    static {
        PipelineTest.jedis = new Jedis("127.0.0.1", 6379);
    }


    public static void main(String[] args) {
        final long l1 = System.currentTimeMillis();
        singleInsert();
        final long l2 = System.currentTimeMillis();
        batchInsert();
        final long l3 = System.currentTimeMillis();
        System.out.println((l3 - l2));
        System.out.println(l2 - l1);
    }

    private static void singleInsert() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 20000; j++) {

                jedis.sadd("a:" + String.valueOf(i), "u:" + String.valueOf(j));
                jedis.hset("u:c:" + String.valueOf(j), String.valueOf(i), String.valueOf(1));

            }
            jedis.set("lock:" + i, String.valueOf(1));
        }
    }

    private static void batchInsert() {

        int count = 0;

        final Pipeline pipeline = jedis.pipelined();

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 20000; j++) {
                // 防止宕机，判断是否已经给用户增加次数
//                final Response<String> response = pipeline.hget("u:" + String.valueOf(j), "a:" + String.valueOf(i));
//                if (response != null && Integer.valueOf(response.get()) > 0) {
//                    continue;
//                }

                pipeline.sadd("a:" + String.valueOf(i), "u:" + String.valueOf(j));
                pipeline.hset("u:c:" + String.valueOf(j), String.valueOf(i), String.valueOf(1));

//                if(++count % 10 == 0){
//                    pipeline.sync();
//                }
            }
            pipeline.set("lock:" + i, String.valueOf(1));
        }
        pipeline.sync();
    }
}
