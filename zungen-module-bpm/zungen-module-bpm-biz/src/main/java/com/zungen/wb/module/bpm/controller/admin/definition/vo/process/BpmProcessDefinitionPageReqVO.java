package com.zungen.wb.module.bpm.controller.admin.definition.vo.process;

import com.zungen.wb.framework.common.pojo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ApiModel("管理后台 - 流程定义分页 Request VO")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BpmProcessDefinitionPageReqVO extends PageParam {

    @ApiModelProperty(value = "标识", example = "process1641042089407", notes = "精准匹配")
    private String key;

}
