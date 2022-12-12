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
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsSimDO;
import com.zungen.wb.module.erp.convert.assets.ErpAssetsSimConvert;
import com.zungen.wb.module.erp.service.assets.ErpAssetsSimService;

@Api(tags = "管理后台 - 资产-sim卡")
@RestController
@RequestMapping("/erp/assets-sim")
@Validated
public class ErpAssetsSimController {

    @Resource
    private ErpAssetsSimService assetsSimService;

    @PostMapping("/create")
    @ApiOperation("创建资产-sim卡")
    @PreAuthorize("@ss.hasPermission('erp:assets-sim:create')")
    public CommonResult<Long> createAssetsSim(@Valid @RequestBody ErpAssetsSimCreateReqVO createReqVO) {
        return success(assetsSimService.createAssetsSim(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新资产-sim卡")
    @PreAuthorize("@ss.hasPermission('erp:assets-sim:update')")
    public CommonResult<Boolean> updateAssetsSim(@Valid @RequestBody ErpAssetsSimUpdateReqVO updateReqVO) {
        assetsSimService.updateAssetsSim(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除资产-sim卡")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('erp:assets-sim:delete')")
    public CommonResult<Boolean> deleteAssetsSim(@RequestParam("id") Long id) {
        assetsSimService.deleteAssetsSim(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得资产-sim卡")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('erp:assets-sim:query')")
    public CommonResult<ErpAssetsSimRespVO> getAssetsSim(@RequestParam("id") Long id) {
        ErpAssetsSimDO assetsSim = assetsSimService.getAssetsSim(id);
        return success(ErpAssetsSimConvert.INSTANCE.convert(assetsSim));
    }

    @GetMapping("/list")
    @ApiOperation("获得资产-sim卡列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('erp:assets-sim:query')")
    public CommonResult<List<ErpAssetsSimRespVO>> getAssetsSimList(@RequestParam("ids") Collection<Long> ids) {
        List<ErpAssetsSimDO> list = assetsSimService.getAssetsSimList(ids);
        return success(ErpAssetsSimConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得资产-sim卡分页")
    @PreAuthorize("@ss.hasPermission('erp:assets-sim:query')")
    public CommonResult<PageResult<ErpAssetsSimRespVO>> getAssetsSimPage(@Valid ErpAssetsSimPageReqVO pageVO) {
        PageResult<ErpAssetsSimDO> pageResult = assetsSimService.getAssetsSimPage(pageVO);
        return success(ErpAssetsSimConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出资产-sim卡 Excel")
    @PreAuthorize("@ss.hasPermission('erp:assets-sim:export')")
    @OperateLog(type = EXPORT)
    public void exportAssetsSimExcel(@Valid ErpAssetsSimExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ErpAssetsSimDO> list = assetsSimService.getAssetsSimList(exportReqVO);
        // 导出 Excel
        List<ErpAssetsSimExcelVO> datas = ErpAssetsSimConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "资产-sim卡.xls", "数据", ErpAssetsSimExcelVO.class, datas);
    }

}
