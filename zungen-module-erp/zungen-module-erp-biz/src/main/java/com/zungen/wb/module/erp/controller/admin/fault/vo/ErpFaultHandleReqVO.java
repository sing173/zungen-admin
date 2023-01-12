package com.zungen.wb.module.erp.controller.admin.fault.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ApiModel("管理后台 - 故障处理 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpFaultHandleReqVO extends ErpFaultBaseVO {
    @ApiModelProperty(value = "唯一标识", required = true)
    @NotNull(message = "唯一标识不能为空")
    private Long id;

    @ApiModelProperty(value = "故障检查结果", required = true)
    @NotNull(message = "故障检查结果不能为空")
    private String faultResult;


    @ApiModelProperty(value = "故障处理方式", required = true)
    @NotNull(message = "故障处理方式不能为空")
    private String faultHandle;

    @ApiModelProperty(value = "状态")
    private Integer status;
}
