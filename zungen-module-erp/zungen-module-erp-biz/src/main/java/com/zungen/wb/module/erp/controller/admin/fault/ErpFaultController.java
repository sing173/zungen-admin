package com.zungen.wb.module.erp.controller.admin.fault;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.*;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.framework.common.pojo.CommonResult;
import static com.zungen.wb.framework.common.pojo.CommonResult.success;

import com.zungen.wb.framework.excel.core.util.ExcelUtils;

import com.zungen.wb.framework.operatelog.core.annotations.OperateLog;
import static com.zungen.wb.framework.operatelog.core.enums.OperateTypeEnum.*;

import com.zungen.wb.module.erp.controller.admin.fault.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.fault.ErpFaultDO;
import com.zungen.wb.module.erp.convert.fault.ErpFaultConvert;
import com.zungen.wb.module.erp.service.fault.ErpFaultService;

@Api(tags = "管理后台 - 故障")
@RestController
@RequestMapping("/erp/fault")
@Validated
public class ErpFaultController {

    @Resource
    private ErpFaultService faultService;

    @PostMapping("/create")
    @ApiOperation("创建故障")
    @PreAuthorize("@ss.hasPermission('erp:fault:create')")
    public CommonResult<Long> createFault(@Valid @RequestBody ErpFaultCreateReqVO createReqVO) {
        return success(faultService.createFault(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新故障")
    @PreAuthorize("@ss.hasPermission('erp:fault:update')")
    public CommonResult<Boolean> updateFault(@Valid @RequestBody ErpFaultUpdateReqVO updateReqVO) {
        faultService.updateFault(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除故障")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('erp:fault:delete')")
    public CommonResult<Boolean> deleteFault(@RequestParam("id") Long id) {
        faultService.deleteFault(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得故障")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('erp:fault:query')")
    public CommonResult<ErpFaultRespVO> getFault(@RequestParam("id") Long id) {
        ErpFaultDO fault = faultService.getFault(id);
        return success(ErpFaultConvert.INSTANCE.convert(fault));
    }

    @GetMapping("/list")
    @ApiOperation("获得故障列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('erp:fault:query')")
    public CommonResult<List<ErpFaultRespVO>> getFaultList(@RequestParam("ids") Collection<Long> ids) {
        List<ErpFaultDO> list = faultService.getFaultList(ids);
        return success(ErpFaultConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得故障分页")
    @PreAuthorize("@ss.hasPermission('erp:fault:query')")
    public CommonResult<PageResult<ErpFaultRespVO>> getFaultPage(@Valid ErpFaultPageReqVO pageVO) {
        PageResult<ErpFaultDO> pageResult = faultService.getFaultPage(pageVO);
        return success(ErpFaultConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出故障 Excel")
    @PreAuthorize("@ss.hasPermission('erp:fault:export')")
    @OperateLog(type = EXPORT)
    public void exportFaultExcel(@Valid ErpFaultExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ErpFaultDO> list = faultService.getFaultList(exportReqVO);
        // 导出 Excel
        List<ErpFaultExcelVO> datas = ErpFaultConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "故障.xls", "数据", ErpFaultExcelVO.class, datas);
    }

}
