package com.zungen.wb.framework.mq.core.interceptor;

import com.zungen.wb.framework.mq.core.message.AbstractRedisMessage;

/**
 * {@link AbstractRedisMessage} 消息拦截器
 * 通过拦截器，作为插件机制，实现拓展。
 * 例如说，多租户场景下的 MQ 消息处理
 *
 * @author admin
 */
public interface RedisMessageInterceptor {

    default void sendMessageBefore(AbstractRedisMessage message) {
    }

    default void sendMessageAfter(AbstractRedisMessage message) {
    }

    default void consumeMessageBefore(AbstractRedisMessage message) {
    }

    default void consumeMessageAfter(AbstractRedisMessage message) {
    }

}
