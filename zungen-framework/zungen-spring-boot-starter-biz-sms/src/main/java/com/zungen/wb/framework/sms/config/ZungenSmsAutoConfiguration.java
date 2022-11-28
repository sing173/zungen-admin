package com.zungen.wb.framework.sms.config;

import com.zungen.wb.framework.sms.core.client.SmsClientFactory;
import com.zungen.wb.framework.sms.core.client.impl.SmsClientFactoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 短信配置类
 *
 * @author admin
 */
@Configuration
public class ZungenSmsAutoConfiguration {

    @Bean
    public SmsClientFactory smsClientFactory() {
        return new SmsClientFactoryImpl();
    }

}
