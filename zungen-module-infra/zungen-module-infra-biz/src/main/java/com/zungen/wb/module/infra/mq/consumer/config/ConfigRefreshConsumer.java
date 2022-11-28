package com.zungen.wb.module.infra.mq.consumer.config;

import com.zungen.wb.framework.apollo.internals.DBConfigRepository;
import com.zungen.wb.framework.mq.core.pubsub.AbstractChannelMessageListener;
import com.zungen.wb.module.infra.mq.message.config.ConfigRefreshMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 针对 {@link ConfigRefreshMessage} 的消费者
 *
 * @author admin
 */
@Component
@Slf4j
public class ConfigRefreshConsumer extends AbstractChannelMessageListener<ConfigRefreshMessage> {

    @Override
    public void onMessage(ConfigRefreshMessage message) {
        log.info("[onMessage][收到 Config 刷新消息]");
        DBConfigRepository.noticeSync();
    }

}
