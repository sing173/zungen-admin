package com.zungen.wb.module.erp.controller.admin.fault.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import com.zungen.wb.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static com.zungen.wb.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 故障 Excel 导出 Request VO", description = "参数和 ErpFaultPageReqVO 是一致的")
@Data
public class ErpFaultExportReqVO {

    @ApiModelProperty(value = "故障编号")
    private String code;

    @ApiModelProperty(value = "资产编号")
    private String assetCode;

    @ApiModelProperty(value = "资产分类")
    private Integer assetType;

    @ApiModelProperty(value = "故障类型")
    private Integer faultType;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
