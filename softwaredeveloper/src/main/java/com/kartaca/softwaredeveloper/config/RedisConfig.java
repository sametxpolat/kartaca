package com.kartaca.softwaredeveloper.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/*
 * REDIS
 */

@Configuration
@EnableCaching
public class RedisConfig {

      @Bean
      public JedisConnectionFactory jedisConnectionFactory() {
            RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("localhost", 6379);
            config.setPassword("01382rR*");
            return new JedisConnectionFactory(config);
      }
      
      @Bean
      public RedisTemplate<Object, Object> redisTemplate() {
            RedisTemplate<Object, Object> template = new RedisTemplate<>();
            template.setConnectionFactory(jedisConnectionFactory());
            template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
            template.setKeySerializer(new StringRedisSerializer());
            template.setHashKeySerializer(new GenericJackson2JsonRedisSerializer());
            template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
            return template;
      }

      @Bean
      public CacheManager cacheManager() {
            RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                  .disableCachingNullValues();
            RedisCacheManager cacheManager = RedisCacheManager.builder(jedisConnectionFactory())
                  .cacheDefaults(cacheConfiguration)
                  .build();
            return cacheManager;
      }

}
