package com.zungen.wb.module.erp.controller.admin.fault.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 故障 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ErpFaultBaseVO {

    @ApiModelProperty(value = "故障编号", required = true)
    @NotNull(message = "故障编号不能为空")
    private String code;

    @ApiModelProperty(value = "资产编号", required = true)
    @NotNull(message = "资产编号不能为空")
    private String assetCode;

    @ApiModelProperty(value = "对应各类资产表id", required = true)
    @NotNull(message = "对应各类资产表id不能为空")
    private String assetId;

    @ApiModelProperty(value = "资产分类", required = true)
    @NotNull(message = "资产分类不能为空")
    private Integer assetType;

    @ApiModelProperty(value = "故障类型", required = true)
    @NotNull(message = "故障类型不能为空")
    private Integer faultType;

    @ApiModelProperty(value = "上报人手机号", required = true)
    @NotNull(message = "上报人手机号不能为空")
    private String mobile;

    @ApiModelProperty(value = "上报人姓名")
    private String reportor;

    @ApiModelProperty(value = "替换的设备id")
    private String replaceAssetId;

    @ApiModelProperty(value = "备注")
    private String remark;

}
