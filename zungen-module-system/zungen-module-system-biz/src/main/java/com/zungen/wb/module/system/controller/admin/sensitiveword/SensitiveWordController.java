package com.zungen.wb.module.system.controller.admin.sensitiveword;

import com.zungen.wb.framework.common.pojo.CommonResult;
import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.framework.excel.core.util.ExcelUtils;
import com.zungen.wb.framework.operatelog.core.annotations.OperateLog;
import com.zungen.wb.module.system.controller.admin.sensitiveword.vo.*;
import com.zungen.wb.module.system.convert.sensitiveword.SensitiveWordConvert;
import com.zungen.wb.module.system.dal.dataobject.sensitiveword.SensitiveWordDO;
import com.zungen.wb.module.system.service.sensitiveword.SensitiveWordService;
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
import java.util.List;
import java.util.Set;

import static com.zungen.wb.framework.common.pojo.CommonResult.success;
import static com.zungen.wb.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;

@Api(tags = "管理后台 - 敏感词")
@RestController
@RequestMapping("/system/sensitive-word")
@Validated
public class SensitiveWordController {

    @Resource
    private SensitiveWordService sensitiveWordService;

    @PostMapping("/create")
    @ApiOperation("创建敏感词")
    @PreAuthorize("@ss.hasPermission('system:sensitive-word:create')")
    public CommonResult<Long> createSensitiveWord(@Valid @RequestBody SensitiveWordCreateReqVO createReqVO) {
        return success(sensitiveWordService.createSensitiveWord(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新敏感词")
    @PreAuthorize("@ss.hasPermission('system:sensitive-word:update')")
    public CommonResult<Boolean> updateSensitiveWord(@Valid @RequestBody SensitiveWordUpdateReqVO updateReqVO) {
        sensitiveWordService.updateSensitiveWord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除敏感词")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('system:sensitive-word:delete')")
    public CommonResult<Boolean> deleteSensitiveWord(@RequestParam("id") Long id) {
        sensitiveWordService.deleteSensitiveWord(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得敏感词")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('system:sensitive-word:query')")
    public CommonResult<SensitiveWordRespVO> getSensitiveWord(@RequestParam("id") Long id) {
        SensitiveWordDO sensitiveWord = sensitiveWordService.getSensitiveWord(id);
        return success(SensitiveWordConvert.INSTANCE.convert(sensitiveWord));
    }

    @GetMapping("/page")
    @ApiOperation("获得敏感词分页")
    @PreAuthorize("@ss.hasPermission('system:sensitive-word:query')")
    public CommonResult<PageResult<SensitiveWordRespVO>> getSensitiveWordPage(@Valid SensitiveWordPageReqVO pageVO) {
        PageResult<SensitiveWordDO> pageResult = sensitiveWordService.getSensitiveWordPage(pageVO);
        return success(SensitiveWordConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出敏感词 Excel")
    @PreAuthorize("@ss.hasPermission('system:sensitive-word:export')")
    @OperateLog(type = EXPORT)
    public void exportSensitiveWordExcel(@Valid SensitiveWordExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<SensitiveWordDO> list = sensitiveWordService.getSensitiveWordList(exportReqVO);
        // 导出 Excel
        List<SensitiveWordExcelVO> datas = SensitiveWordConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "敏感词.xls", "数据", SensitiveWordExcelVO.class, datas);
    }

    @GetMapping("/get-tags")
    @ApiOperation("获取所有敏感词的标签数组")
    @PreAuthorize("@ss.hasPermission('system:sensitive-word:query')")
    public CommonResult<Set<String>> getSensitiveWordTags() throws IOException {
        return success(sensitiveWordService.getSensitiveWordTags());
    }

    @GetMapping("/validate-text")
    @ApiOperation("获得文本所包含的不合法的敏感词数组")
    public CommonResult<List<String>> validateText(@RequestParam("text") String text,
                                                   @RequestParam(value = "tags", required = false) List<String> tags) {
        return success(sensitiveWordService.validateText(text, tags));
    }

}
