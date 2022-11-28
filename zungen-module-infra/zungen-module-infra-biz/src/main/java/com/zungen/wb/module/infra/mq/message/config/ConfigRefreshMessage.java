package com.zungen.wb.module.infra.mq.message.config;

import com.zungen.wb.framework.mq.core.pubsub.AbstractChannelMessage;
import lombok.Data;

/**
 * 配置数据刷新 Message
 */
@Data
public class ConfigRefreshMessage extends AbstractChannelMessage {

    @Override
    public String getChannel() {
        return "infra.config.refresh";
    }

}
