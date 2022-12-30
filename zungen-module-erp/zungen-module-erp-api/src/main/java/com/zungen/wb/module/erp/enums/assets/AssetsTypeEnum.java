package com.zungen.wb.module.erp.enums.assets;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Erp资产分类枚举
 *
 * @author admin
 */
@Getter
@AllArgsConstructor
public enum AssetsTypeEnum {

    PAD(0), // 平板
    BACK(1), // 背夹
    READER(2), // 读取仪
    SIM(3), // SIM卡

    ;

    /**
     * 类型
     */
    private final int type;

}
