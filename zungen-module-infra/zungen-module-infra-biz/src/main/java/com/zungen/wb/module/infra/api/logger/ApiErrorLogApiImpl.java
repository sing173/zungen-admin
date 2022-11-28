package com.zungen.wb.module.infra.api.logger;

import com.zungen.wb.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;
import com.zungen.wb.module.infra.service.logger.ApiErrorLogService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * API 访问日志的 API 接口
 *
 * @author admin
 */
@Service
@Validated
public class ApiErrorLogApiImpl implements ApiErrorLogApi {

    @Resource
    private ApiErrorLogService apiErrorLogService;

    @Override
    public void createApiErrorLog(ApiErrorLogCreateReqDTO createDTO) {
        apiErrorLogService.createApiErrorLog(createDTO);
    }

}
