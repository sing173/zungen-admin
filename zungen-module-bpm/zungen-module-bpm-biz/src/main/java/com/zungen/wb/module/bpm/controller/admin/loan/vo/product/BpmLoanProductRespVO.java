package com.zungen.wb.module.bpm.controller.admin.loan.vo.product;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 贷款产品 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BpmLoanProductRespVO extends BpmLoanProductBaseVO {

    @ApiModelProperty(value = "贷款产品主键", required = true)
    private Long id;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

}
