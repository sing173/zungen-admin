package com.zungen.wb.framework.idempotent.config;

import com.zungen.wb.framework.idempotent.core.aop.IdempotentAspect;
import com.zungen.wb.framework.idempotent.core.keyresolver.impl.DefaultIdempotentKeyResolver;
import com.zungen.wb.framework.idempotent.core.keyresolver.impl.ExpressionIdempotentKeyResolver;
import com.zungen.wb.framework.idempotent.core.keyresolver.IdempotentKeyResolver;
import com.zungen.wb.framework.idempotent.core.redis.IdempotentRedisDAO;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import com.zungen.wb.framework.redis.config.ZungenRedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(ZungenRedisAutoConfiguration.class)
public class ZungenIdempotentConfiguration {

    @Bean
    public IdempotentAspect idempotentAspect(List<IdempotentKeyResolver> keyResolvers, IdempotentRedisDAO idempotentRedisDAO) {
        return new IdempotentAspect(keyResolvers, idempotentRedisDAO);
    }

    @Bean
    public IdempotentRedisDAO idempotentRedisDAO(StringRedisTemplate stringRedisTemplate) {
        return new IdempotentRedisDAO(stringRedisTemplate);
    }

    // ========== 各种 IdempotentKeyResolver Bean ==========

    @Bean
    public DefaultIdempotentKeyResolver defaultIdempotentKeyResolver() {
        return new DefaultIdempotentKeyResolver();
    }

    @Bean
    public ExpressionIdempotentKeyResolver expressionIdempotentKeyResolver() {
        return new ExpressionIdempotentKeyResolver();
    }

}
