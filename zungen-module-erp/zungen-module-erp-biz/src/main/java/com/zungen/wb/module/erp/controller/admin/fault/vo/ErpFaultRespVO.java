package com.zungen.wb.module.erp.controller.admin.fault.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import javax.validation.constraints.NotNull;

@ApiModel("管理后台 - 故障 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpFaultRespVO extends ErpFaultBaseVO {

    @ApiModelProperty(value = "唯一标识", required = true)
    private Long id;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

    @ApiModelProperty(value = "故障检查结果", required = true)
    @NotNull(message = "故障检查结果不能为空")
    private String faultResult;


    @ApiModelProperty(value = "故障处理方式", required = true)
    @NotNull(message = "故障处理方式不能为空")
    private String faultHandle;

    @ApiModelProperty(value = "状态")
    private Integer status;

}
