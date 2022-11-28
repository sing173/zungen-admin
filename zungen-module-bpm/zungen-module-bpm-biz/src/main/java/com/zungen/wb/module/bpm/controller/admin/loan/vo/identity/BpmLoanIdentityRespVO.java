package com.zungen.wb.module.bpm.controller.admin.loan.vo.identity;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 贷款/担保人-身份要素认证 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BpmLoanIdentityRespVO extends BpmLoanIdentityBaseVO {

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

}
