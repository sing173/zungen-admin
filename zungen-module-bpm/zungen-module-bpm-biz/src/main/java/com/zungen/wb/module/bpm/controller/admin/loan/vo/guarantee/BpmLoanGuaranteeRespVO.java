package com.zungen.wb.module.bpm.controller.admin.loan.vo.guarantee;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 担保信息 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BpmLoanGuaranteeRespVO extends BpmLoanGuaranteeBaseVO {

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

}
