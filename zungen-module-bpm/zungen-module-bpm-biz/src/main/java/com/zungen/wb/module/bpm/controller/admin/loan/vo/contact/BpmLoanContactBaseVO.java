package com.zungen.wb.module.bpm.controller.admin.loan.vo.contact;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 联系人信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class BpmLoanContactBaseVO {

    @ApiModelProperty(value = "姓名", required = true)
    @NotNull(message = "姓名不能为空")
    private String name;

    @ApiModelProperty(value = "手机号码", required = true)
    @NotNull(message = "手机号码不能为空")
    private String mobile;

    @ApiModelProperty(value = "工作单位")
    private String work;

    @ApiModelProperty(value = "邮箱地址")
    private String email;

    @ApiModelProperty(value = "关系", required = true)
    @NotNull(message = "关系不能为空")
    private Integer relationship;

    @ApiModelProperty(value = "联系人类型（紧急、工作...）")
    private Integer type;

}
