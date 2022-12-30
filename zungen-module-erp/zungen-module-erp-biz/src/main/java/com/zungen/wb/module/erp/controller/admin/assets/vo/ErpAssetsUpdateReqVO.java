package com.zungen.wb.module.erp.controller.admin.assets.vo;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 资产更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpAssetsUpdateReqVO extends ErpAssetsBaseVO {

    @ApiModelProperty(value = "唯一标识", required = true)
    private Long id;

    @ApiModelProperty(value = "备注")
    private String remark;

}
