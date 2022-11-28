package com.zungen.wb.module.system.api.errorcode.dto;

import lombok.Data;

import java.util.Date;

/**
 * 错误码的 Response DTO
 *
 * @author admin
 */
@Data
public class ErrorCodeRespDTO {

    /**
     * 错误码编码
     */
    private Integer code;
    /**
     * 错误码错误提示
     */
    private String message;
    /**
     * 更新时间
     */
    private Date updateTime;

}
