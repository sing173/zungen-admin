package com.zungen.wb.framework.dict.config;

import com.zungen.wb.framework.dict.core.util.DictFrameworkUtils;
import com.zungen.wb.module.system.api.dict.DictDataApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZungenDictAutoConfiguration {

    @Bean
    @SuppressWarnings("InstantiationOfUtilityClass")
    public DictFrameworkUtils dictUtils(DictDataApi dictDataApi) {
        DictFrameworkUtils.init(dictDataApi);
        return new DictFrameworkUtils();
    }

}
