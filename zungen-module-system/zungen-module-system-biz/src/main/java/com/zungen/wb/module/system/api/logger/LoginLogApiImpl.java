package com.zungen.wb.module.system.api.logger;

import com.zungen.wb.module.system.api.logger.dto.LoginLogCreateReqDTO;
import com.zungen.wb.module.system.service.logger.LoginLogService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * 登录日志的 API 实现类
 *
 * @author admin
 */
@Service
@Validated
public class LoginLogApiImpl implements LoginLogApi {

    @Resource
    private LoginLogService loginLogService;

    @Override
    public void createLoginLog(LoginLogCreateReqDTO reqDTO) {
        loginLogService.createLoginLog(reqDTO);
    }

}
