package com.zungen.wb.module.erp.controller.admin.assets.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 资产-身份证读取仪 Excel VO
 *
 * @author admin
 */
@Data
public class ErpAssetsIdReaderExcelVO {

    @ExcelProperty("唯一标识")
    private String id;

    @ExcelProperty("平板id")
    private String padId;

    @ExcelProperty("身份证读取仪名称")
    private String name;

    @ExcelProperty("资产编号")
    private String code;

    @ExcelProperty("序列号")
    private String sn;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("创建时间")
    private Date createTime;

}
