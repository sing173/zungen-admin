package com.zungen.wb.module.bpm.controller.admin.loan.vo.order;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import static com.zungen.wb.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 贷款工单 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class BpmLoanOrderBaseVO {
    @ApiModelProperty(value = "贷款编号")
    private String orderNo;

    @ApiModelProperty(value = "担保信息编号")
    private Long guaranteeId;

    @ApiModelProperty(value = "流程实例的编号")
    private String processInstanceId;

    @ApiModelProperty(value = "期望额度")
    private Long expectedCredit;

    @ApiModelProperty(value = "初始额度")
    private Long initialCredit;

    @ApiModelProperty(value = "还款期数")
    private Integer repaymentPeriods;

    @ApiModelProperty(value = "还款方式")
    private Integer repaymentType;

    @ApiModelProperty(value = "审批时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date auditTime;

    @ApiModelProperty(value = "审批意见")
    private String auditRemark;

    @ApiModelProperty(value = "状态")
    private Integer status;

}
