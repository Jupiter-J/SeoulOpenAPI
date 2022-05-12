package com.example.air.application.redis;

import java.util.Map.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.cache.RedisCacheManager;

//
//@Configuration
//@EnableCaching
//@EnableConfigurationProperties(CacheRedisProperties.class)
//public class CustomRedisCacheConfiguration {
//    private Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Autowired
//    private CacheRedisProperties cacheRedisProperties;
//
//    @Bean
//    public CacheManagerCustomizer<RedisCacheManager> cacheManagerCustomizer() {
//
//        return new CacheManagerCustomizer<RedisCacheManager>() {
//            @Override
//            public void customize(RedisCacheManager cacheManager) {
//                cacheManager.setDefaultExpiration(cacheRedisProperties.getDefaultExpireTime());
//                cacheManager.setExpires(cacheRedisProperties.getExpireTime());
//            }
//        };
//    }
//}