package com.zungen.wb.module.bpm.controller.admin.loan.vo.identity;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 贷款/担保人-身份要素认证 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class BpmLoanIdentityBaseVO {

    @ApiModelProperty(value = "人脸识别状态", required = true)
    @NotNull(message = "人脸识别状态不能为空")
    private Integer faceStatus;

    @ApiModelProperty(value = "三要素验证状态", required = true)
    @NotNull(message = "三要素验证状态不能为空")
    private Integer authStatus;

    @ApiModelProperty(value = "状态(正常、过期、作废）", required = true)
    @NotNull(message = "状态(正常、过期、作废）不能为空")
    private Integer status;

    @ApiModelProperty(value = "身份证正面照片")
    private String identityCardFront;

    @ApiModelProperty(value = "身份证背面照片")
    private String identityCardBack;

}
