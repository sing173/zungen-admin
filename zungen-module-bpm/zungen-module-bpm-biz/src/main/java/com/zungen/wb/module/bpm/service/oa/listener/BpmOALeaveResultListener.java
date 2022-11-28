package com.zungen.wb.module.bpm.service.oa.listener;

import com.zungen.wb.module.bpm.framework.bpm.core.event.BpmProcessInstanceResultEvent;
import com.zungen.wb.module.bpm.framework.bpm.core.event.BpmProcessInstanceResultEventListener;
import com.zungen.wb.module.bpm.service.oa.BpmOALeaveService;
import com.zungen.wb.module.bpm.service.oa.BpmOALeaveServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * OA 请假单的结果的监听器实现类
 *
 * @author admin
 */
@Component
public class BpmOALeaveResultListener extends BpmProcessInstanceResultEventListener {

    @Resource
    private BpmOALeaveService leaveService;

    @Override
    protected String getProcessDefinitionKey() {
        return BpmOALeaveServiceImpl.PROCESS_KEY;
    }

    @Override
    protected void onEvent(BpmProcessInstanceResultEvent event) {
        leaveService.updateLeaveResult(Long.parseLong(event.getBusinessKey()), event.getResult());
    }

}
