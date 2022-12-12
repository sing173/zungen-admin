package com.zungen.wb.module.erp.controller.admin.assets.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import com.zungen.wb.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static com.zungen.wb.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 资产-身份证读取仪 Excel 导出 Request VO", description = "参数和 ErpAssetsIdReaderPageReqVO 是一致的")
@Data
public class ErpAssetsIdReaderExportReqVO {

    @ApiModelProperty(value = "平板id")
    private Long padId;

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
