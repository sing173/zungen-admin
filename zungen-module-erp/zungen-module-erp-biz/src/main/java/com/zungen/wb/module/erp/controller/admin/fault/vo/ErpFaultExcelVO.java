package com.zungen.wb.module.erp.controller.admin.fault.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 故障 Excel VO
 *
 * @author admin
 */
@Data
public class ErpFaultExcelVO {

    @ExcelProperty("唯一标识")
    private Long id;

    @ExcelProperty("故障编号")
    private String code;

    @ExcelProperty("资产编号")
    private String assetCode;

    @ExcelProperty("对应各类资产表id")
    private String assetId;

    @ExcelProperty("资产分类")
    private Integer assetType;

    @ExcelProperty("故障类型")
    private Integer faultType;

    @ExcelProperty("上报人手机号")
    private String mobile;

    @ExcelProperty("上报人姓名")
    private String reportor;

    @ExcelProperty("替换的设备id")
    private String replaceAssetId;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("创建时间")
    private Date createTime;

}
