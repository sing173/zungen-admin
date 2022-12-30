package com.zungen.wb.module.erp.controller.admin.assets.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 资产-身份证读取仪更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpAssetsIdReaderUpdateReqVO extends ErpAssetsIdReaderBaseVO {

    @ApiModelProperty(value = "唯一标识", required = true)
    @NotNull(message = "唯一标识不能为空")
    private String id;

}
