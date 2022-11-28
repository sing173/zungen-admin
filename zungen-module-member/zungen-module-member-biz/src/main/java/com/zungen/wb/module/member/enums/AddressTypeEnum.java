package com.zungen.wb.module.member.enums;

import com.zungen.wb.framework.common.core.IntArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 用户收件地址的类型枚举
 */
@Getter
@AllArgsConstructor
public enum AddressTypeEnum implements IntArrayValuable {

    DEFAULT(1, "默认收件地址"),
    NORMAL(2, "普通收件地址"), // 即非默认收件地址

    ;

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(AddressTypeEnum::getType).toArray();

    private final Integer type;
    private final String desc;

    @Override
    public int[] array() {
        return ARRAYS;
    }
}
