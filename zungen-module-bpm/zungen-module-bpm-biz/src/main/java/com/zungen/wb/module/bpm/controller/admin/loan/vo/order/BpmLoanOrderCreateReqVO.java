package com.zungen.wb.module.bpm.controller.admin.loan.vo.order;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 贷款工单创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BpmLoanOrderCreateReqVO extends BpmLoanOrderBaseVO{

    @ApiModelProperty(value = "贷款人编号", required = true)
    @NotNull(message = "贷款人编号不能为空")
    private Long loanUserId;

    @ApiModelProperty(value = "贷款产品编号", required = true)
    @NotNull(message = "贷款产品编号不能为空")
    private Long productId;

}
