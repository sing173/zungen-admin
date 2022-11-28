package com.zungen.wb.framework.operatelog.config;

import com.zungen.wb.framework.operatelog.core.aop.OperateLogAspect;
import com.zungen.wb.framework.operatelog.core.service.OperateLogFrameworkService;
import com.zungen.wb.framework.operatelog.core.service.OperateLogFrameworkServiceImpl;
import com.zungen.wb.module.system.api.logger.OperateLogApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZungenOperateLogAutoConfiguration {

    @Bean
    public OperateLogAspect operateLogAspect() {
        return new OperateLogAspect();
    }

    @Bean
    public OperateLogFrameworkService operateLogFrameworkService(OperateLogApi operateLogApi) {
        return new OperateLogFrameworkServiceImpl(operateLogApi);
    }

}
