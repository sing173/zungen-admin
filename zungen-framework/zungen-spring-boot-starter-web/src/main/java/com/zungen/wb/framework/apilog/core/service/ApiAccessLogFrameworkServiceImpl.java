package com.zungen.wb.framework.apilog.core.service;

import cn.hutool.core.bean.BeanUtil;
import com.zungen.wb.module.infra.api.logger.ApiAccessLogApi;
import com.zungen.wb.module.infra.api.logger.dto.ApiAccessLogCreateReqDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;

/**
 * API 访问日志 Framework Service 实现类
 *
 * 基于 {@link ApiAccessLogApi} 服务，记录访问日志
 *
 * @author admin
 */
@RequiredArgsConstructor
public class ApiAccessLogFrameworkServiceImpl implements ApiAccessLogFrameworkService {

    private final ApiAccessLogApi apiAccessLogApi;

    @Override
//    @Async TODO 异步操作会导致DubboFilter在异步线程中启动，无法获取http请求线程中设置的TenantContextHolder.TenantId,暂注释 22.8.24 lmx
    public void createApiAccessLog(ApiAccessLog apiAccessLog) {
        ApiAccessLogCreateReqDTO reqDTO = BeanUtil.copyProperties(apiAccessLog, ApiAccessLogCreateReqDTO.class);
        apiAccessLogApi.createApiAccessLog(reqDTO);
    }

}
