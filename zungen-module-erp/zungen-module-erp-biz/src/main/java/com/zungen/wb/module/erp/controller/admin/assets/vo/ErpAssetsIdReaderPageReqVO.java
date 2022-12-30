package com.zungen.wb.module.erp.controller.admin.assets.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import com.zungen.wb.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static com.zungen.wb.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 资产-身份证读取仪分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpAssetsIdReaderPageReqVO extends PageParam {

    @ApiModelProperty(value = "平板id")
    private String padId;

    @ApiModelProperty(value = "身份证读取仪名称")
    private String name;

    @ApiModelProperty(value = "资产编号")
    private String code;

    @ApiModelProperty(value = "序列号")
    private String sn;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
