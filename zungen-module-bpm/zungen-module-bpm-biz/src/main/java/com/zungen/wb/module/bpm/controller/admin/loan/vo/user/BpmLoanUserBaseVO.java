package com.zungen.wb.module.bpm.controller.admin.loan.vo.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 借款人信息 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class BpmLoanUserBaseVO {

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "手机号码", required = true)
    @NotNull(message = "手机号码不能为空")
    private String mobile;

    @ApiModelProperty(value = "家庭地址")
    private String address;

    @ApiModelProperty(value = "工作单位")
    private String work;

    @ApiModelProperty(value = "工作电话")
    private String workPhone;

    @ApiModelProperty(value = "家庭地址")
    private String workAddress;

    @ApiModelProperty(value = "状态(正常、失信...）", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "贷款人的身份认证id")
    private Long identityId;

    @ApiModelProperty(value = "贷款人的联系人id")
    private Long contactId;

    @ApiModelProperty(value = "性别")
    private Integer male;

    @ApiModelProperty(value = "年龄")
    private Integer age;

}
