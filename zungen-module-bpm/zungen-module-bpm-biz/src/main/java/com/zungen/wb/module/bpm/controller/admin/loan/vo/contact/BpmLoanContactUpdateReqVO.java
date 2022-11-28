package com.zungen.wb.module.bpm.controller.admin.loan.vo.contact;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 联系人信息更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BpmLoanContactUpdateReqVO extends BpmLoanContactBaseVO {

    @ApiModelProperty(value = "联系人主键", required = true)
    @NotNull(message = "联系人主键不能为空")
    private Long id;

    @ApiModelProperty(value = "贷款人的用户编号", required = true)
    @NotNull(message = "贷款人的用户编号不能为空")
    private Long userId;

    @ApiModelProperty(value = "家庭地址")
    private String address;

    @ApiModelProperty(value = "工作电话")
    private String workPhone;

    @ApiModelProperty(value = "工作地址")
    private String workAddress;

}
