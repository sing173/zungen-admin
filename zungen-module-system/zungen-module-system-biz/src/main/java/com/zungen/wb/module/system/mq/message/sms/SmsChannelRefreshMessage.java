package com.zungen.wb.module.system.mq.message.sms;

import com.zungen.wb.framework.mq.core.pubsub.AbstractChannelMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 短信渠道的数据刷新 Message
 *
 * @author admin
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SmsChannelRefreshMessage extends AbstractChannelMessage {

    @Override
    public String getChannel() {
        return "system.sms-channel.refresh";
    }

}
