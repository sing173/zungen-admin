package com.zungen.wb.module.bpm.controller.admin.loan.vo.product;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 贷款产品 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class BpmLoanProductBaseVO {

    @ApiModelProperty(value = "产品名", required = true)
    @NotNull(message = "产品名不能为空")
    private String name;

    @ApiModelProperty(value = "产品编号", required = true)
    @NotNull(message = "产品编号不能为空")
    private String no;

    @ApiModelProperty(value = "产品利率")
    private String rates;

    @ApiModelProperty(value = "贷款金额")
    private String amount;

    @ApiModelProperty(value = "描述")
    private String remark;

    @ApiModelProperty(value = "状态(正常、过期、作废）", required = true)
    @NotNull(message = "状态(正常、过期、作废）不能为空")
    private Integer status;

}
