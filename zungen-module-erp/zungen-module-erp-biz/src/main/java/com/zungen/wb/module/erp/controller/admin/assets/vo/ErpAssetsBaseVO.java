package com.zungen.wb.module.erp.controller.admin.assets.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import static com.zungen.wb.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 资产 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ErpAssetsBaseVO {
    @ApiModelProperty(value = "对应各类资产表id", required = true)
    @NotNull(message = "对应各类资产表id不能为空")
    private String assetId;

    @ApiModelProperty(value = "资产名称", required = true)
    @NotNull(message = "资产名称不能为空")
    private String name;

    @ApiModelProperty(value = "资产编号", required = true)
    @NotNull(message = "资产编号不能为空")
    private String code;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "关联资产")
    private String parent;

    @ApiModelProperty(value = "入库时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date checkInTime;

    @ApiModelProperty(value = "序列号")
    private String sn;

    @ApiModelProperty(value = "使用部门")
    private Long useDept;

}
