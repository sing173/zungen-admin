package com.zungen.wb.framework.apilog.core.service;

/**
 * API 错误日志 Framework Service 接口
 *
 * @author admin
 */
public interface ApiErrorLogFrameworkService {

    /**
     * 创建 API 错误日志
     *
     * @param apiErrorLog API 错误日志
     */
    void createApiErrorLog(ApiErrorLog apiErrorLog);

}
