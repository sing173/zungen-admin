package com.zungen.wb.module.system.api.logger;

import com.zungen.wb.module.system.api.logger.dto.OperateLogCreateReqDTO;

import javax.validation.Valid;

/**
 * 操作日志 API 接口
 *
 * @author admin
 */
public interface OperateLogApi {

    /**
     * 创建操作日志
     *
     * @param createReqDTO 请求
     */
    void createOperateLog(@Valid OperateLogCreateReqDTO createReqDTO);

}
