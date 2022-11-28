package com.zungen.wb.module.bpm.controller.admin.loan.vo.identity;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 贷款/担保人-身份要素认证创建 Request VO")
@Data
@ToString(callSuper = true)
public class BpmLoanIdentityCreateReqVO {

    @ApiModelProperty(value = "贷款/担保人的用户编号", required = true)
    @NotNull(message = "贷款/担保人的用户编号不能为空")
    private Long userId;

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
