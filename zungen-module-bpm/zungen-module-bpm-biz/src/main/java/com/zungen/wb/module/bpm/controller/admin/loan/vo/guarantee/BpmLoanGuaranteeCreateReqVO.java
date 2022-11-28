package com.zungen.wb.module.bpm.controller.admin.loan.vo.guarantee;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 担保信息创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BpmLoanGuaranteeCreateReqVO extends BpmLoanGuaranteeBaseVO {

    @ApiModelProperty(value = "担保人的用户编号", required = true)
    @NotNull(message = "担保人的用户编号不能为空")
    private Long userId;

    @ApiModelProperty(value = "担保人的家庭地址")
    private String address;

    @ApiModelProperty(value = "担保人的工作单位")
    private String work;

    @ApiModelProperty(value = "担保人的工作电话")
    private String workPhone;

    @ApiModelProperty(value = "担保人的家庭地址")
    private String workAddress;

    @ApiModelProperty(value = "担保人的邮箱地址")
    private String email;

}
