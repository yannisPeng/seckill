///**
// * @(#)RedissonConfig.java, 2019/8/15.
// * <p/>
// */
//
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
////import com.netease.dedis.config.RedisConfig;
//
////@Configuration
//public class RedissonConfig {
//
//    @Autowired
//    private RedisConfig redisConfig;
//
//    @Bean
//    public RedissonClient getRedisson() {
//
//        Config config = new Config();
//        config
//            .useSingleServer().setAddress("redis://" + redisConfig.getHost()
//                + ":" + redisConfig.getPort())
//            .setPassword(redisConfig.getPassword());
//        //添加主从配置
//        //        config.useMasterSlaveServers().setMasterAddress("").setPassword("").addSlaveAddress(new String[]{"",""});
//        return Redisson.create(config);
//    }
//
//}
