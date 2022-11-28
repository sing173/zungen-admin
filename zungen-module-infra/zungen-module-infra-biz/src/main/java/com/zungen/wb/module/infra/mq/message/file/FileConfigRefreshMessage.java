package com.zungen.wb.module.infra.mq.message.file;

import com.zungen.wb.framework.mq.core.pubsub.AbstractChannelMessage;
import lombok.Data;

/**
 * 文件配置数据刷新 Message
 */
@Data
public class FileConfigRefreshMessage extends AbstractChannelMessage {

    @Override
    public String getChannel() {
        return "infra.file-config.refresh";
    }

}
