package com.zungen.wb.module.bpm.controller.admin.loan.vo.identity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ApiModel("管理后台 - 贷款/担保人-认证身份 Request VO")
@Data
@ToString(callSuper = true)
public class BpmLoanIdentityVO {
    @ApiModelProperty(value = "身份认证id", required = true)
    @NotNull(message = "身份认证ID不能为空")
    private Integer id;

    @ApiModelProperty(value = "姓名", required = true)
    @NotNull(message = "姓名不能为空")
    private String name;

    @ApiModelProperty(value = "手机号码", required = true)
    @NotNull(message = "手机号码不能为空")
    private String mobile;

    @ApiModelProperty(value = "身份证编号", required = true)
    @NotNull(message = "身份证编号不能为空")
    private String identityCardNumber;


}
