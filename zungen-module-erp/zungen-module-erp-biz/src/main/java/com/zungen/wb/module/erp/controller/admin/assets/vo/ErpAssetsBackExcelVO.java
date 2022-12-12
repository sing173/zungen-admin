package com.zungen.wb.module.erp.controller.admin.assets.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 资产-背夹 Excel VO
 *
 * @author admin
 */
@Data
public class ErpAssetsBackExcelVO {

    @ExcelProperty("唯一标识")
    private Long id;

    @ExcelProperty("平板id")
    private Long padId;

    @ExcelProperty("背夹名称")
    private String name;

    @ExcelProperty("背夹资产编号")
    private String code;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("序列号")
    private String sn;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("创建时间")
    private Date createTime;

}