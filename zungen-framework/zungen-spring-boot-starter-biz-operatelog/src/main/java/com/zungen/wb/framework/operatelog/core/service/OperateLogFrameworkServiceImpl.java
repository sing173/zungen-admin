package com.zungen.wb.framework.operatelog.core.service;

import cn.hutool.core.bean.BeanUtil;
import com.zungen.wb.module.system.api.logger.OperateLogApi;
import com.zungen.wb.module.system.api.logger.dto.OperateLogCreateReqDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;

/**
 * 操作日志 Framework Service 实现类
 *
 * 基于 {@link OperateLogApi} 实现，记录操作日志
 *
 * @author admin
 */
@RequiredArgsConstructor
public class OperateLogFrameworkServiceImpl implements OperateLogFrameworkService {

    private final OperateLogApi operateLogApi;

    @Override
//    @Async TODO 异步操作会导致DubboFilter在异步线程中启动，无法获取http请求线程中设置的TenantContextHolder.TenantId,暂注释 22.8.25 lmx
    public void createOperateLog(OperateLog operateLog) {
        OperateLogCreateReqDTO reqDTO = BeanUtil.copyProperties(operateLog, OperateLogCreateReqDTO.class);
        operateLogApi.createOperateLog(reqDTO);
    }

}
