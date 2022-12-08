package com.zungen.wb.module.erp.controller.admin.assets.vo;

import lombok.*;
import io.swagger.annotations.*;

import javax.validation.constraints.NotNull;

@ApiModel("管理后台 - 资产 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpAssetsRespVO extends ErpAssetsBaseVO {
    @ApiModelProperty(value = "唯一标识", required = true)
    @NotNull(message = "唯一标识不能为空")
    private Long id;
}
