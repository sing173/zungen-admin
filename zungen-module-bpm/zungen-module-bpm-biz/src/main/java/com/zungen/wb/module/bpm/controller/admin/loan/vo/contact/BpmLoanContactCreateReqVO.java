package com.zungen.wb.module.bpm.controller.admin.loan.vo.contact;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 联系人信息创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BpmLoanContactCreateReqVO extends BpmLoanContactBaseVO {

    @ApiModelProperty(value = "贷款/担保人的用户编号", required = true)
    @NotNull(message = "贷款/担保人的用户编号不能为空")
    private Long userId;

    @ApiModelProperty(value = "家庭地址")
    private String address;

    @ApiModelProperty(value = "工作电话")
    private String workPhone;

    @ApiModelProperty(value = "工作地址")
    private String workAddress;

}
