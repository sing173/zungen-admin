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
    // ========== 资产-平板 1-010-000-002 ==========
    ErrorCode ASSETS_PAD_NOT_EXISTS = new ErrorCode(1010000002, "资产-平板不存在");
    // ========== 资产-背夹 1-010-000-003 ==========
    ErrorCode ASSETS_BACK_NOT_EXISTS = new ErrorCode(1010000003, "资产-背夹不存在");
    // ========== 资产-身份证读取仪 1-010-000-004 ==========
    ErrorCode ASSETS_ID_READER_NOT_EXISTS = new ErrorCode(1010000004, "资产-身份证读取仪不存在");
    // ========== 资产-sim卡 1-010-000-005 ==========
    ErrorCode ASSETS_SIM_NOT_EXISTS = new ErrorCode(1010000005, "资产-sim卡不存在");
    // ========== 故障-记录 1-010-001-001 ==========
    ErrorCode FAULT_NOT_EXISTS = new ErrorCode(1010001001, "故障记录不存在");
}
