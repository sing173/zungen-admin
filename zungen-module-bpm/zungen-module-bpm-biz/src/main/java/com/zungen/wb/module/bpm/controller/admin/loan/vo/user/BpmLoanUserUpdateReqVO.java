package com.zungen.wb.module.bpm.controller.admin.loan.vo.user;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 贷款人信息更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BpmLoanUserUpdateReqVO extends BpmLoanUserBaseVO {

    @ApiModelProperty(value = "贷款人主键", required = true)
    @NotNull(message = "贷款人主键不能为空")
    private Long id;

    @ApiModelProperty(value = "申请人的用户编号", required = true)
    @NotNull(message = "申请人的用户编号不能为空")
    private Long userId;

    @ApiModelProperty(value = "身份证编号")
    private String identityCardNumber;

    @ApiModelProperty(value = "身份证正面照片")
    private String identityCardFront;

    @ApiModelProperty(value = "身份证背面照片")
    private String identityCardBack;

    @ApiModelProperty(value = "邮箱地址")
    private String email;

    @ApiModelProperty(value = "联系人家庭地址")
    private String contactAddress;

    @ApiModelProperty(value = "联系人工作单位")
    private String contactWork;

    @ApiModelProperty(value = "联系人工作地址")
    private String contactWorkAddress;

    @ApiModelProperty(value = "是否通过人脸识别", required = true)
    @NotNull(message = "是否通过人脸识别不能为空")
    private Boolean isFace;

    @ApiModelProperty(value = "是否通过三要素验证", required = true)
    @NotNull(message = "是否通过三要素验证不能为空")
    private Boolean isAuth;

}
