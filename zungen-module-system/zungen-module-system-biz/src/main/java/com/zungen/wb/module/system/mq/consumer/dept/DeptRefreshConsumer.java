package com.zungen.wb.module.system.mq.consumer.dept;

import com.zungen.wb.framework.mq.core.pubsub.AbstractChannelMessageListener;
import com.zungen.wb.module.system.mq.message.dept.DeptRefreshMessage;
import com.zungen.wb.module.system.service.dept.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 针对 {@link DeptRefreshMessage} 的消费者
 *
 * @author admin
 */
@Component
@Slf4j
public class DeptRefreshConsumer extends AbstractChannelMessageListener<DeptRefreshMessage> {

    @Resource
    private DeptService deptService;

    @Override
    public void onMessage(DeptRefreshMessage message) {
        log.info("[onMessage][收到 Dept 刷新消息]");
        deptService.initLocalCache();
    }

}
