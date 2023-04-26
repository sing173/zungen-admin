package com.zungen.wb.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 项目的启动类
 *
 * @author admin
 */
@SuppressWarnings("SpringComponentScan") // 忽略 IDEA 无法识别 ${zungen.info.base-package}
@SpringBootApplication
@MapperScan({"com.gitee.sunchenbin.mybatis.actable.dao.*"})//固定的
@ComponentScan({"${zungen.info.base-package}.server", "${zungen.info.base-package}.module", "com.gitee.sunchenbin.mybatis.actable.manager.*"})//固定的
public class ZungenServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZungenServerApplication.class, args);
    }

}
