package com.zungen.wb.module.bpm.controller.admin.loan.vo.identity;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 贷款/担保人-身份要素认证更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BpmLoanIdentityUpdateReqVO extends BpmLoanIdentityBaseVO {

    @ApiModelProperty(value = "身份认证主键", required = true)
    @NotNull(message = "身份认证主键不能为空")
    private Long id;

    @ApiModelProperty(value = "贷款/担保人的用户编号", required = true)
    @NotNull(message = "贷款/担保人的用户编号不能为空")
    private Long userId;

    @ApiModelProperty(value = "身份证正面照片")
    private String identityCardFront;

    @ApiModelProperty(value = "身份证背面照片")
    private String identityCardBack;

}
