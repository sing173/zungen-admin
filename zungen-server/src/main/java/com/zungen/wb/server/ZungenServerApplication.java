package com.zungen.wb.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目的启动类
 *
 * @author admin
 */
@SuppressWarnings("SpringComponentScan") // 忽略 IDEA 无法识别 ${zungen.info.base-package}
@SpringBootApplication(scanBasePackages = {"${zungen.info.base-package}.server", "${zungen.info.base-package}.module"})
public class ZungenServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZungenServerApplication.class, args);
    }

}
