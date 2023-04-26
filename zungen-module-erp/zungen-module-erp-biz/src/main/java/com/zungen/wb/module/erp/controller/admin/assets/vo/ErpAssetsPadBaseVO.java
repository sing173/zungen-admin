package com.zungen.wb.module.erp.controller.admin.assets.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 资产-平板 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ErpAssetsPadBaseVO {

    @ApiModelProperty(value = "平板名称", required = true)
    @NotNull(message = "平板名称不能为空")
    private String name;

    @ApiModelProperty(value = "平板资产编号(IMEI)", required = true)
    @NotNull(message = "平板资产编号(IMEI)不能为空")
    private String code;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "MEID")
    private String meid;

    @ApiModelProperty(value = "序列号")
    private String sn;

    @ApiModelProperty(value = "型号")
    private String modelNo;

    @ApiModelProperty(value = "批次号")
    private String batchNo;

    @ApiModelProperty(value = "rom版本号")
    private String rom;

    @ApiModelProperty(value = "规格")
    private String specs;

    @ApiModelProperty(value = "蓝牙mac地址")
    private String blueMac;

    @ApiModelProperty(value = "无线mac地址")
    private String mac;

    @ApiModelProperty(value = "使用部门")
    private String useDept;

    @ApiModelProperty(value = "备注")
    private String remark;

}
