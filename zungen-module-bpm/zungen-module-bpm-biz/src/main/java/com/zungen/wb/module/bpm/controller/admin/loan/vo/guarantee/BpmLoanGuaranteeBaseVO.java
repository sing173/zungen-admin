package com.zungen.wb.module.bpm.controller.admin.loan.vo.guarantee;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 担保信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class BpmLoanGuaranteeBaseVO {

    @ApiModelProperty(value = "姓名", required = true)
    @NotNull(message = "姓名不能为空")
    private String name;

    @ApiModelProperty(value = "手机号码", required = true)
    @NotNull(message = "手机号码不能为空")
    private String mobile;

    @ApiModelProperty(value = "与贷款人关系")
    private Integer relationship;

    @ApiModelProperty(value = "状态(已注册、接收担保、验证通过）", required = true)
    @NotNull(message = "状态(已注册、接收担保、验证通过）不能为空")
    private Integer status;

}
