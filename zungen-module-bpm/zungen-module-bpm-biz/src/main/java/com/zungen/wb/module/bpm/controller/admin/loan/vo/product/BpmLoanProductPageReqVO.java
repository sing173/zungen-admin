package com.zungen.wb.module.bpm.controller.admin.loan.vo.product;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import com.zungen.wb.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static com.zungen.wb.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 贷款产品分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BpmLoanProductPageReqVO extends PageParam {

    @ApiModelProperty(value = "产品名")
    private String name;

    @ApiModelProperty(value = "产品编号")
    private String no;

    @ApiModelProperty(value = "产品利率")
    private String rates;

    @ApiModelProperty(value = "贷款金额")
    private String amount;

    @ApiModelProperty(value = "状态(正常、过期、作废）")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
