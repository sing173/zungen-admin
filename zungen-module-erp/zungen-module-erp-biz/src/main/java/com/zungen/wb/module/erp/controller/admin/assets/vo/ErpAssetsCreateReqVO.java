package com.zungen.wb.module.erp.controller.admin.assets.vo;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 资产创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpAssetsCreateReqVO extends ErpAssetsBaseVO {
    @ApiModelProperty(value = "资产分类", required = true)
    @NotNull(message = "资产分类不能为空")
    private Integer type;


    @ApiModelProperty(value = "备注")
    private String remark;

}
