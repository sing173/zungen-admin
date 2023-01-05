package com.zungen.wb.module.erp.controller.admin.assets.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 资产-平板更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpAssetsPadUpdateReqVO extends ErpAssetsPadBaseVO {

    @ApiModelProperty(value = "唯一标识", required = true)
    @NotNull(message = "唯一标识不能为空")
    private String id;

    @ApiModelProperty(value = "关联背夹ID")
    private String backId;

    @ApiModelProperty(value = "关联读取仪ID")
    private String readerId;

    @ApiModelProperty(value = "关联SIM卡ID")
    private String simId;
}
