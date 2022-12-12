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
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsBackDO;
import com.zungen.wb.module.erp.convert.assets.ErpAssetsBackConvert;
import com.zungen.wb.module.erp.service.assets.ErpAssetsBackService;

@Api(tags = "管理后台 - 资产-背夹")
@RestController
@RequestMapping("/erp/assets-back")
@Validated
public class ErpAssetsBackController {

    @Resource
    private ErpAssetsBackService assetsBackService;

    @PostMapping("/create")
    @ApiOperation("创建资产-背夹")
    @PreAuthorize("@ss.hasPermission('erp:assets-back:create')")
    public CommonResult<Long> createAssetsBack(@Valid @RequestBody ErpAssetsBackCreateReqVO createReqVO) {
        return success(assetsBackService.createAssetsBack(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新资产-背夹")
    @PreAuthorize("@ss.hasPermission('erp:assets-back:update')")
    public CommonResult<Boolean> updateAssetsBack(@Valid @RequestBody ErpAssetsBackUpdateReqVO updateReqVO) {
        assetsBackService.updateAssetsBack(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除资产-背夹")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('erp:assets-back:delete')")
    public CommonResult<Boolean> deleteAssetsBack(@RequestParam("id") Long id) {
        assetsBackService.deleteAssetsBack(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得资产-背夹")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('erp:assets-back:query')")
    public CommonResult<ErpAssetsBackRespVO> getAssetsBack(@RequestParam("id") Long id) {
        ErpAssetsBackDO assetsBack = assetsBackService.getAssetsBack(id);
        return success(ErpAssetsBackConvert.INSTANCE.convert(assetsBack));
    }

    @GetMapping("/list")
    @ApiOperation("获得资产-背夹列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('erp:assets-back:query')")
    public CommonResult<List<ErpAssetsBackRespVO>> getAssetsBackList(@RequestParam("ids") Collection<Long> ids) {
        List<ErpAssetsBackDO> list = assetsBackService.getAssetsBackList(ids);
        return success(ErpAssetsBackConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得资产-背夹分页")
    @PreAuthorize("@ss.hasPermission('erp:assets-back:query')")
    public CommonResult<PageResult<ErpAssetsBackRespVO>> getAssetsBackPage(@Valid ErpAssetsBackPageReqVO pageVO) {
        PageResult<ErpAssetsBackDO> pageResult = assetsBackService.getAssetsBackPage(pageVO);
        return success(ErpAssetsBackConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出资产-背夹 Excel")
    @PreAuthorize("@ss.hasPermission('erp:assets-back:export')")
    @OperateLog(type = EXPORT)
    public void exportAssetsBackExcel(@Valid ErpAssetsBackExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ErpAssetsBackDO> list = assetsBackService.getAssetsBackList(exportReqVO);
        // 导出 Excel
        List<ErpAssetsBackExcelVO> datas = ErpAssetsBackConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "资产-背夹.xls", "数据", ErpAssetsBackExcelVO.class, datas);
    }

}
