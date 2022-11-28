package com.zungen.wb.framework.apilog.core.service;

import cn.hutool.core.bean.BeanUtil;
import com.zungen.wb.module.infra.api.logger.ApiErrorLogApi;
import com.zungen.wb.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;

/**
 * API 错误日志 Framework Service 实现类
 *
 * 基于 {@link ApiErrorLogApi} 服务，记录错误日志
 *
 * @author admin
 */
@RequiredArgsConstructor
public class ApiErrorLogFrameworkServiceImpl implements ApiErrorLogFrameworkService {

    private final ApiErrorLogApi apiErrorLogApi;

    @Override
//    @Async TODO 异步操作会导致DubboFilter在异步线程中启动，无法获取http请求线程中设置的TenantContextHolder.TenantId,暂注释 22.8.25 lmx
    public void createApiErrorLog(ApiErrorLog apiErrorLog) {
        ApiErrorLogCreateReqDTO reqDTO = BeanUtil.copyProperties(apiErrorLog, ApiErrorLogCreateReqDTO.class);
        apiErrorLogApi.createApiErrorLog(reqDTO);
    }

}
