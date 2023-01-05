package com.zungen.wb.module.erp.controller.admin.assets;

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

import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsPadDO;
import com.zungen.wb.module.erp.convert.assets.ErpAssetsPadConvert;
import com.zungen.wb.module.erp.service.assets.ErpAssetsPadService;

@Api(tags = "管理后台 - 资产-平板")
@RestController
@RequestMapping("/erp/assets/pad")
@Validated
public class ErpAssetsPadController {

    @Resource
    private ErpAssetsPadService assetsPadService;

    @PostMapping("/create")
    @ApiOperation("创建资产-平板")
    @PreAuthorize("@ss.hasPermission('erp:assets-pad:create')")
    public CommonResult<String> createAssetsPad(@Valid @RequestBody ErpAssetsPadCreateReqVO createReqVO) {
        return success(assetsPadService.createAssetsPad(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新资产-平板")
    @PreAuthorize("@ss.hasPermission('erp:assets-pad:update')")
    public CommonResult<Boolean> updateAssetsPad(@Valid @RequestBody ErpAssetsPadUpdateReqVO updateReqVO) {
        assetsPadService.updateAssetsPad(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除资产-平板")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('erp:assets-pad:delete')")
    public CommonResult<Boolean> deleteAssetsPad(@RequestParam("id") String id) {
        assetsPadService.deleteAssetsPad(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得资产-平板")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('erp:assets-pad:query')")
    public CommonResult<ErpAssetsPadRespVO> getAssetsPad(@RequestParam("id") String id) {
        ErpAssetsPadDO assetsPad = assetsPadService.getAssetsPad(id);
        return success(ErpAssetsPadConvert.INSTANCE.convert(assetsPad));
    }

    @GetMapping("/list")
    @ApiOperation("获得资产-平板列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('erp:assets-pad:query')")
    public CommonResult<List<ErpAssetsPadRespVO>> getAssetsPadList(@RequestParam("ids") Collection<String> ids) {
        List<ErpAssetsPadDO> list = assetsPadService.getAssetsPadList(ids);
        return success(ErpAssetsPadConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得资产-平板分页")
    @PreAuthorize("@ss.hasPermission('erp:assets-pad:query')")
    public CommonResult<PageResult<ErpAssetsPadRespVO>> getAssetsPadPage(@Valid ErpAssetsPadPageReqVO pageVO) {
        PageResult<ErpAssetsPadDO> pageResult = assetsPadService.getAssetsPadPage(pageVO);
        return success(ErpAssetsPadConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出资产-平板 Excel")
    @PreAuthorize("@ss.hasPermission('erp:assets-pad:export')")
    @OperateLog(type = EXPORT)
    public void exportAssetsPadExcel(@Valid ErpAssetsPadExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ErpAssetsPadDO> list = assetsPadService.getAssetsPadList(exportReqVO);
        // 导出 Excel
        List<ErpAssetsPadExcelVO> datas = ErpAssetsPadConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "资产-平板.xls", "数据", ErpAssetsPadExcelVO.class, datas);
    }

}
