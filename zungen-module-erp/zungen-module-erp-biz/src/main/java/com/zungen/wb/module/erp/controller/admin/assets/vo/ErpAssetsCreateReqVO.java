package com.zungen.wb.module.erp.controller.admin.assets.vo;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 资产创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpAssetsCreateReqVO extends ErpAssetsBaseVO {

    @ApiModelProperty(value = "对应各类资产表id", required = true)
    @NotNull(message = "对应各类资产表id不能为空")
    private Long assertId;

    @ApiModelProperty(value = "备注")
    private String remark;

}
