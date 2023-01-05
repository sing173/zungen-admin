package com.zungen.wb.module.erp.controller.admin.assets;

import com.zungen.wb.framework.common.pojo.CommonResult;
import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.framework.excel.core.util.ExcelUtils;
import com.zungen.wb.framework.operatelog.core.annotations.OperateLog;
import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import com.zungen.wb.module.erp.convert.assets.ErpAssetsIdReaderConvert;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsIdReaderDO;
import com.zungen.wb.module.erp.service.assets.ErpAssetsIdReaderService;
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

@Api(tags = "管理后台 - 资产-身份证读取仪")
@RestController
@RequestMapping("/erp/assets/reader")
@Validated
public class ErpAssetsIdReaderController {

    @Resource
    private ErpAssetsIdReaderService assetsIdReaderService;

    @PostMapping("/create")
    @ApiOperation("创建资产-身份证读取仪")
    @PreAuthorize("@ss.hasPermission('erp:assets-id-reader:create')")
    public CommonResult<String> createAssetsIdReader(@Valid @RequestBody ErpAssetsIdReaderCreateReqVO createReqVO) {
        return success(assetsIdReaderService.createAssetsIdReader(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新资产-身份证读取仪")
    @PreAuthorize("@ss.hasPermission('erp:assets-id-reader:update')")
    public CommonResult<Boolean> updateAssetsIdReader(@Valid @RequestBody ErpAssetsIdReaderUpdateReqVO updateReqVO) {
        assetsIdReaderService.updateAssetsIdReader(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除资产-身份证读取仪")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('erp:assets-id-reader:delete')")
    public CommonResult<Boolean> deleteAssetsIdReader(@RequestParam("id") String id) {
        assetsIdReaderService.deleteAssetsIdReader(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得资产-身份证读取仪")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('erp:assets-id-reader:query')")
    public CommonResult<ErpAssetsIdReaderRespVO> getAssetsIdReader(@RequestParam("id") String id) {
        ErpAssetsIdReaderDO assetsIdReader = assetsIdReaderService.getAssetsIdReader(id);
        return success(ErpAssetsIdReaderConvert.INSTANCE.convert(assetsIdReader));
    }

    @GetMapping("/getByPadId")
    @ApiOperation("通过平板id获得资产-读取仪")
    @ApiImplicitParam(name = "padId", value = "平板ID", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('erp:assets-id-reader:queryByPadId')")
    public CommonResult<ErpAssetsIdReaderRespVO> getAssetsBackByPadId(@RequestParam("padId") String padId) {
        ErpAssetsIdReaderDO assetsIdReader = assetsIdReaderService.selectChildAssetByPadId(padId);
        return success(ErpAssetsIdReaderConvert.INSTANCE.convert(assetsIdReader));
    }

    @GetMapping("/list")
    @ApiOperation("获得资产-身份证读取仪列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('erp:assets-id-reader:query')")
    public CommonResult<List<ErpAssetsIdReaderRespVO>> getAssetsIdReaderList(@RequestParam("ids") Collection<String> ids) {
        List<ErpAssetsIdReaderDO> list = assetsIdReaderService.getAssetsIdReaderList(ids);
        return success(ErpAssetsIdReaderConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得资产-身份证读取仪分页")
    @PreAuthorize("@ss.hasPermission('erp:assets-id-reader:query')")
    public CommonResult<PageResult<ErpAssetsIdReaderRespVO>> getAssetsIdReaderPage(@Valid ErpAssetsIdReaderPageReqVO pageVO) {
        PageResult<ErpAssetsIdReaderDO> pageResult = assetsIdReaderService.getAssetsIdReaderPage(pageVO);
        return success(ErpAssetsIdReaderConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出资产-身份证读取仪 Excel")
    @PreAuthorize("@ss.hasPermission('erp:assets-id-reader:export')")
    @OperateLog(type = EXPORT)
    public void exportAssetsIdReaderExcel(@Valid ErpAssetsIdReaderExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ErpAssetsIdReaderDO> list = assetsIdReaderService.getAssetsIdReaderList(exportReqVO);
        // 导出 Excel
        List<ErpAssetsIdReaderExcelVO> datas = ErpAssetsIdReaderConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "资产-身份证读取仪.xls", "数据", ErpAssetsIdReaderExcelVO.class, datas);
    }

}
