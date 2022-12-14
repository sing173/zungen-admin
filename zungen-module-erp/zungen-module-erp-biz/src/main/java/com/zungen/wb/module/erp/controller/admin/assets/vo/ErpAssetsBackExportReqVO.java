package com.zungen.wb.module.erp.controller.admin.assets.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import com.zungen.wb.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static com.zungen.wb.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 资产-背夹 Excel 导出 Request VO", description = "参数和 ErpAssetsBackPageReqVO 是一致的")
@Data
public class ErpAssetsBackExportReqVO {

    @ApiModelProperty(value = "背夹名称")
    private String name;

    @ApiModelProperty(value = "背夹资产编号")
    private String code;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "序列号")
    private String sn;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
