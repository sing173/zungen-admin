package com.zungen.wb.module.erp.controller.admin.assets.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 资产-sim卡 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpAssetsSimRespVO extends ErpAssetsSimBaseVO {

    @ApiModelProperty(value = "唯一标识", required = true)
    private String id;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

}
