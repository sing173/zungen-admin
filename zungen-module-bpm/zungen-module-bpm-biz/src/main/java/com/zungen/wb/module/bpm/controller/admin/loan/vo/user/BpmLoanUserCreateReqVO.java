package com.zungen.wb.module.bpm.controller.admin.loan.vo.user;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 贷款人信息创建 Request VO")
@Data
@ToString(callSuper = true)
public class BpmLoanUserCreateReqVO {

    @ApiModelProperty(value = "申请人的用户编号", required = true)
    @NotNull(message = "申请人的用户编号不能为空")
    private Long userId;

    @ApiModelProperty(value = "姓名", required = true)
    @NotNull(message = "姓名不能为空")
    private String name;

    @ApiModelProperty(value = "手机号码", required = true)
    @NotNull(message = "手机号码不能为空")
    private String mobile;

    @ApiModelProperty(value = "申请人的身份证号", required = true)
    @NotNull(message = "申请人的身份证号不能为空")
    private String identityCardNumber;
}
