package com.zungen.wb.module.erp.controller.admin.assets.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import com.zungen.wb.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static com.zungen.wb.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 资产-平板 Excel 导出 Request VO", description = "参数和 ErpAssetsPadPageReqVO 是一致的")
@Data
public class ErpAssetsPadExportReqVO {

    @ApiModelProperty(value = "平板名称")
    private String name;

    @ApiModelProperty(value = "平板资产编号(IMEI)")
    private String code;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "MEID")
    private String meid;

    @ApiModelProperty(value = "序列号")
    private String sn;

    @ApiModelProperty(value = "型号")
    private String modelNo;

    @ApiModelProperty(value = "批次号")
    private String batchNo;

    @ApiModelProperty(value = "rom版本号")
    private String rom;

    @ApiModelProperty(value = "规格")
    private String specs;

    @ApiModelProperty(value = "蓝牙mac地址")
    private String blueMac;

    @ApiModelProperty(value = "无线mac地址")
    private String mac;

    @ApiModelProperty(value = "使用部门")
    private String useDept;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
