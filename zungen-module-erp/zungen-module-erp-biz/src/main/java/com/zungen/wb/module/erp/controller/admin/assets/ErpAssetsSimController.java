package com.zungen.wb.module.erp.controller.admin.assets;

import com.zungen.wb.framework.common.pojo.CommonResult;
import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.framework.excel.core.util.ExcelUtils;
import com.zungen.wb.framework.operatelog.core.annotations.OperateLog;
import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import com.zungen.wb.module.erp.convert.assets.ErpAssetsSimConvert;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsSimDO;
import com.zungen.wb.module.erp.service.assets.ErpAssetsSimService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static com.zungen.wb.framework.common.pojo.CommonResult.success;
import static com.zungen.wb.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;

@Api(tags = "管理后台 - 资产-sim卡")
@RestController
@RequestMapping("/erp/assets/sim")
@Validated
public class ErpAssetsSimController {

    @Resource
    private ErpAssetsSimService assetsSimService;

    @PostMapping("/create")
    @ApiOperation("创建资产-sim卡")
    @PreAuthorize("@ss.hasPermission('erp:assets-sim:create')")
    public CommonResult<String> createAssetsSim(@Valid @RequestBody ErpAssetsSimCreateReqVO createReqVO) {
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
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('erp:assets-sim:delete')")
    public CommonResult<Boolean> deleteAssetsSim(@RequestParam("id") String id) {
        assetsSimService.deleteAssetsSim(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得资产-sim卡")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('erp:assets-sim:query')")
    public CommonResult<ErpAssetsSimRespVO> getAssetsSim(@RequestParam("id") String id) {
        ErpAssetsSimDO assetsSim = assetsSimService.getAssetsSim(id);
        return success(ErpAssetsSimConvert.INSTANCE.convert(assetsSim));
    }

    @GetMapping("/getByPadId")
    @ApiOperation("通过平板id获得资产-sim卡")
    @ApiImplicitParam(name = "padId", value = "平板ID", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('erp:assets-sim:queryByPadId')")
    public CommonResult<ErpAssetsSimRespVO> getAssetsBackByPadId(@RequestParam("padId") String padId) {
        ErpAssetsSimDO assetsSim = assetsSimService.selectChildAssetByPadId(padId);
        return success(ErpAssetsSimConvert.INSTANCE.convert(assetsSim));
    }

    @GetMapping("/list")
    @ApiOperation("获得资产-sim卡列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('erp:assets-sim:query')")
    public CommonResult<List<ErpAssetsSimRespVO>> getAssetsSimList(@RequestParam("ids") Collection<String> ids) {
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
