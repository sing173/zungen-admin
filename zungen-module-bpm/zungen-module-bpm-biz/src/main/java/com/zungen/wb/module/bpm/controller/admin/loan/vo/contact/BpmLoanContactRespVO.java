package com.zungen.wb.module.bpm.controller.admin.loan.vo.contact;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 联系人信息 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BpmLoanContactRespVO extends BpmLoanContactBaseVO {

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

}
