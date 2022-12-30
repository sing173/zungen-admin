package com.zungen.wb.module.erp.controller.admin.assets.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 资产-sim卡 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ErpAssetsSimBaseVO {

    @ApiModelProperty(value = "sim名称", required = true)
    @NotNull(message = "sim名称不能为空")
    private String name;

    @ApiModelProperty(value = "sim卡资产编号(卡号,也是序列号)", required = true)
    @NotNull(message = "sim卡资产编号(卡号,也是序列号)不能为空")
    private String code;

    @ApiModelProperty(value = "平板id")
    private String padId;

    @ApiModelProperty(value = "sim卡iccid号", required = true)
    @NotNull(message = "sim卡iccid号不能为空")
    private String iccid;

    @ApiModelProperty(value = "sim卡imsi号", required = true)
    @NotNull(message = "sim卡imsi号不能为空")
    private String imsi;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "备注")
    private String remark;

}
