package com.zungen.wb.framework.apilog.config;

import com.zungen.wb.framework.apilog.core.filter.ApiAccessLogFilter;
import com.zungen.wb.framework.apilog.core.service.ApiAccessLogFrameworkService;
import com.zungen.wb.framework.apilog.core.service.ApiAccessLogFrameworkServiceImpl;
import com.zungen.wb.framework.apilog.core.service.ApiErrorLogFrameworkService;
import com.zungen.wb.framework.apilog.core.service.ApiErrorLogFrameworkServiceImpl;
import com.zungen.wb.framework.common.enums.WebFilterOrderEnum;
import com.zungen.wb.framework.web.config.WebProperties;
import com.zungen.wb.framework.web.config.ZungenWebAutoConfiguration;
import com.zungen.wb.module.infra.api.logger.ApiAccessLogApi;
import com.zungen.wb.module.infra.api.logger.ApiErrorLogApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
@AutoConfigureAfter(ZungenWebAutoConfiguration.class)
public class ZungenApiLogAutoConfiguration {

    @Bean
    public ApiAccessLogFrameworkService apiAccessLogFrameworkService(ApiAccessLogApi apiAccessLogApi) {
        return new ApiAccessLogFrameworkServiceImpl(apiAccessLogApi);
    }

    @Bean
    public ApiErrorLogFrameworkService apiErrorLogFrameworkService(ApiErrorLogApi apiErrorLogApi) {
        return new ApiErrorLogFrameworkServiceImpl(apiErrorLogApi);
    }

    /**
     * 创建 ApiAccessLogFilter Bean，记录 API 请求日志
     */
    @Bean
    @ConditionalOnProperty(prefix = "zungen.access-log", value = "enable", matchIfMissing = true) // 允许使用 zungen.access-log.enable=false 禁用访问日志
    public FilterRegistrationBean<ApiAccessLogFilter> apiAccessLogFilter(WebProperties webProperties,
                                                                         @Value("${spring.application.name}") String applicationName,
                                                                         ApiAccessLogFrameworkService apiAccessLogFrameworkService) {
        ApiAccessLogFilter filter = new ApiAccessLogFilter(webProperties, applicationName, apiAccessLogFrameworkService);
        return createFilterBean(filter, WebFilterOrderEnum.API_ACCESS_LOG_FILTER);
    }

    private static <T extends Filter> FilterRegistrationBean<T> createFilterBean(T filter, Integer order) {
        FilterRegistrationBean<T> bean = new FilterRegistrationBean<>(filter);
        bean.setOrder(order);
        return bean;
    }

}
