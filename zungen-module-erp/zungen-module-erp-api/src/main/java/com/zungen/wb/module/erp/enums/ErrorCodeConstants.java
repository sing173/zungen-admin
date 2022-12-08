package com.zungen.wb.module.erp.enums;


import com.zungen.wb.framework.common.exception.ErrorCode;

/**
 * pda模块 错误码枚举类
 *
 * pda，使用 1-010-000-000 段
 */
public interface ErrorCodeConstants {
    // ========== 资产总表 1-010-000-001 ==========
    ErrorCode ASSETS_NOT_EXISTS = new ErrorCode(1010000001, "资产不存在");


}
