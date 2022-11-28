package com.zungen.wb.module.bpm.controller.admin.loan.vo.order;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 贷款工单 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BpmLoanOrderRespVO extends BpmLoanOrderBaseVO {

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

}
