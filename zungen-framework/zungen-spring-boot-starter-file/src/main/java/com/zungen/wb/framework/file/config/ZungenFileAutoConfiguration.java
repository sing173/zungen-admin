package com.zungen.wb.framework.file.config;

import com.zungen.wb.framework.file.core.client.FileClientFactory;
import com.zungen.wb.framework.file.core.client.FileClientFactoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 文件配置类
 *
 * @author admin
 */
@Configuration
public class ZungenFileAutoConfiguration {

    @Bean
    public FileClientFactory fileClientFactory() {
        return new FileClientFactoryImpl();
    }

}
