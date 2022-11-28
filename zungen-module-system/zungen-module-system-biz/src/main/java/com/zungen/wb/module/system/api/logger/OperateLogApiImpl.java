package com.zungen.wb.module.system.api.logger;

import com.zungen.wb.module.system.api.logger.dto.OperateLogCreateReqDTO;
import com.zungen.wb.module.system.service.logger.OperateLogService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * 操作日志 API 实现类
 *
 * @author admin
 */
@Service
@Validated
public class OperateLogApiImpl implements OperateLogApi {

    @Resource
    private OperateLogService operateLogService;

    @Override
    public void createOperateLog(OperateLogCreateReqDTO createReqDTO) {
        operateLogService.createOperateLog(createReqDTO);
    }

}
