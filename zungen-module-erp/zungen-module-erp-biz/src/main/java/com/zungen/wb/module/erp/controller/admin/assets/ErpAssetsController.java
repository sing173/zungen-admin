package com.zungen.wb.module.erp.controller.admin.assets;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.*;

import javax.validation.*;
import java.util.*;

import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.framework.common.pojo.CommonResult;
import static com.zungen.wb.framework.common.pojo.CommonResult.success;

import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsDO;
import com.zungen.wb.module.erp.convert.assets.ErpAssetsConvert;
import com.zungen.wb.module.erp.service.assets.ErpAssetsService;

@Api(tags = "管理后台 - 资产")
@RestController
@RequestMapping("/erp/assets")
@Validated
public class ErpAssetsController {

    @Resource
    private ErpAssetsService assetsService;

    @PostMapping("/create")
    @ApiOperation("创建资产")
    @PreAuthorize("@ss.hasPermission('erp:assets:create')")
    public CommonResult<Long> createAssets(@Valid @RequestBody ErpAssetsCreateReqVO createReqVO) {
        return success(assetsService.createAssets(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新资产")
    @PreAuthorize("@ss.hasPermission('erp:assets:update')")
    public CommonResult<Boolean> updateAssets(@Valid @RequestBody ErpAssetsUpdateReqVO updateReqVO) {
        assetsService.updateAssets(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除资产")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('erp:assets:delete')")
    public CommonResult<Boolean> deleteAssets(@RequestParam("id") Long id) {
        assetsService.deleteAssets(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得资产")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('erp:assets:query')")
    public CommonResult<ErpAssetsRespVO> getAssets(@RequestParam("id") Long id) {
        ErpAssetsDO assets = assetsService.getAssets(id);
        return success(ErpAssetsConvert.INSTANCE.convert(assets));
    }

    @GetMapping("/list")
    @ApiOperation("获得资产列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('erp:assets:query')")
    public CommonResult<List<ErpAssetsRespVO>> getAssetsList(@RequestParam("ids") Collection<Long> ids) {
        List<ErpAssetsDO> list = assetsService.getAssetsList(ids);
        return success(ErpAssetsConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得资产分页")
    @PreAuthorize("@ss.hasPermission('erp:assets:query')")
    public CommonResult<PageResult<ErpAssetsRespVO>> getAssetsPage(@Valid ErpAssetsPageReqVO pageVO) {
        PageResult<ErpAssetsDO> pageResult = assetsService.getAssetsPage(pageVO);
        return success(ErpAssetsConvert.INSTANCE.convertPage(pageResult));
    }


}
