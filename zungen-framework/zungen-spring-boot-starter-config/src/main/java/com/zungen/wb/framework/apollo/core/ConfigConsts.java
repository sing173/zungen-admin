package com.zungen.wb.framework.apollo.core;

import com.zungen.wb.framework.apollo.internals.ConfigFrameworkDAO;

/**
 * 针对 {@link com.ctrip.framework.apollo.core.ConfigConsts} 的补充，主要增加：
 *
 * 1. apollo.jdbc.* 配置项的枚举
 *
 * @author admin
 */
public class ConfigConsts {

    /**
     * {@link ConfigFrameworkDAO} 的实现类
     */
    public static final String APOLLO_JDBC_DAO = "apollo.jdbc.dao";
    public static final String APOLLO_JDBC_URL = "apollo.jdbc.url";
    public static final String APOLLO_JDBC_USERNAME = "apollo.jdbc.username";
    public static final String APOLLO_JDBC_PASSWORD = "apollo.jdbc.password";

}
