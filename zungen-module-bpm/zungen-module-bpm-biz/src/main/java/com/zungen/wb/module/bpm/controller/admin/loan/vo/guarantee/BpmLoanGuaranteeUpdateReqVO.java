package com.zungen.wb.module.bpm.controller.admin.loan.vo.guarantee;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 担保信息更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BpmLoanGuaranteeUpdateReqVO extends BpmLoanGuaranteeBaseVO {

    @ApiModelProperty(value = "担保信息主键", required = true)
    @NotNull(message = "担保信息主键不能为空")
    private Long id;

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

    @ApiModelProperty(value = "担保人的身份认证id")
    private Long identityId;

    @ApiModelProperty(value = "担保人的联系人id")
    private Long contactId;

    @ApiModelProperty(value = "担保人签名")
    private String sign;

    @ApiModelProperty(value = "担保人确认担保视频")
    private String authVideo;

}
