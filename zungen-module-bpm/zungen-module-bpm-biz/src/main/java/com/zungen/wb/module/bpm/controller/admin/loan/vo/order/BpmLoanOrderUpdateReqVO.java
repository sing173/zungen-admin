package com.zungen.wb.module.bpm.controller.admin.loan.vo.order;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 贷款工单更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BpmLoanOrderUpdateReqVO extends BpmLoanOrderBaseVO {

    @ApiModelProperty(value = "贷款表单主键", required = true)
    @NotNull(message = "贷款表单主键不能为空")
    private Long id;

    @ApiModelProperty(value = "贷款编号", required = true)
    @NotNull(message = "贷款编号不能为空")
    private String orderNo;

    @ApiModelProperty(value = "贷款人编号", required = true)
    @NotNull(message = "贷款人编号不能为空")
    private Long loanUserId;

    @ApiModelProperty(value = "贷款产品编号")
    private Long productId;

    @ApiModelProperty(value = "担保信息编号")
    private Long guaranteeId;

    @ApiModelProperty(value = "流程实例的编号")
    private String processInstanceId;

}
