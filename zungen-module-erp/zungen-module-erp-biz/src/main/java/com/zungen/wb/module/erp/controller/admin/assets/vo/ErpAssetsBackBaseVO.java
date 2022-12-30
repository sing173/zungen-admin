package com.zungen.wb.module.erp.controller.admin.assets.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 资产-背夹 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ErpAssetsBackBaseVO {

    @ApiModelProperty(value = "平板id")
    private String padId;

    @ApiModelProperty(value = "背夹名称", required = true)
    @NotNull(message = "背夹名称不能为空")
    private String name;

    @ApiModelProperty(value = "背夹资产编号", required = true)
    @NotNull(message = "背夹资产编号不能为空")
    private String code;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "序列号")
    private String sn;

    @ApiModelProperty(value = "备注")
    private String remark;

}
