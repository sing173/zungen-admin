package com.zungen.wb.module.erp.controller.admin.assets.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 资产-sim卡 Excel VO
 *
 * @author admin
 */
@Data
public class ErpAssetsSimExcelVO {

    @ExcelProperty("唯一标识")
    private Long id;

    @ExcelProperty("sim名称")
    private String name;

    @ExcelProperty("sim卡资产编号(卡号,也是序列号)")
    private String code;

    @ExcelProperty("平板id")
    private Long padId;

    @ExcelProperty("sim卡iccid号")
    private String iccid;

    @ExcelProperty("sim卡imsi号")
    private String imsi;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("创建时间")
    private Date createTime;

}
