package com.zungen.wb.module.bpm.controller.admin.loan.vo.product;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 贷款产品更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BpmLoanProductUpdateReqVO extends BpmLoanProductBaseVO {

    @ApiModelProperty(value = "贷款产品主键", required = true)
    @NotNull(message = "贷款产品主键不能为空")
    private Long id;

}
