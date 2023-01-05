package com.zungen.wb.module.erp.controller.admin.fault.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 故障 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpFaultRespVO extends ErpFaultBaseVO {

    @ApiModelProperty(value = "唯一标识", required = true)
    private Long id;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

}
