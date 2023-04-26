package com.zungen.wb.module.erp.controller.admin.assets.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 资产-平板 Excel VO
 *
 * @author admin
 */
@Data
public class ErpAssetsPadExcelVO {

    @ExcelProperty("唯一标识")
    private String id;

    @ExcelProperty("平板名称")
    private String name;

    @ExcelProperty("平板资产编号(IMEI)")
    private String code;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("MEID")
    private String meid;

    @ExcelProperty("序列号")
    private String sn;

    @ExcelProperty("型号")
    private String modelNo;

    @ExcelProperty("批次号")
    private String batchNo;

    @ExcelProperty("rom版本号")
    private String rom;

    @ExcelProperty("规格")
    private String specs;

    @ExcelProperty("蓝牙mac地址")
    private String blueMac;

    @ExcelProperty("无线mac地址")
    private String mac;

    @ExcelProperty("使用部门")
    private String useDept;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("创建时间")
    private Date createTime;

}
