package com.zungen.wb.module.bpm.controller.admin.loan;

import com.zungen.wb.framework.common.pojo.CommonResult;
import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.guarantee.BpmLoanGuaranteeCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.guarantee.BpmLoanGuaranteePageReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.guarantee.BpmLoanGuaranteeRespVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.guarantee.BpmLoanGuaranteeUpdateReqVO;
import com.zungen.wb.module.bpm.convert.loan.BpmLoanGuaranteeConvert;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanGuaranteeDO;
import com.zungen.wb.module.bpm.service.loan.BpmLoanGuaranteeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

import static com.zungen.wb.framework.common.pojo.CommonResult.success;

@Api(tags = "管理后台 - 担保信息")
@RestController
@RequestMapping("/bpm/loan-guarantee")
@Validated
public class BpmLoanGuaranteeController {

    @Resource
    private BpmLoanGuaranteeService loanGuaranteeService;

    @PostMapping("/create")
    @ApiOperation("创建担保信息")
    @PreAuthorize("@ss.hasPermission('bpm:loan-guarantee:create')")
    public CommonResult<Long> createLoanGuarantee(@Valid @RequestBody BpmLoanGuaranteeCreateReqVO createReqVO) {
        return success(loanGuaranteeService.createLoanGuarantee(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新担保信息")
    @PreAuthorize("@ss.hasPermission('bpm:loan-guarantee:update')")
    public CommonResult<Boolean> updateLoanGuarantee(@Valid @RequestBody BpmLoanGuaranteeUpdateReqVO updateReqVO) {
        loanGuaranteeService.updateLoanGuarantee(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除担保信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bpm:loan-guarantee:delete')")
    public CommonResult<Boolean> deleteLoanGuarantee(@RequestParam("id") Long id) {
        loanGuaranteeService.deleteLoanGuarantee(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得担保信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bpm:loan-guarantee:query')")
    public CommonResult<BpmLoanGuaranteeRespVO> getLoanGuarantee(@RequestParam("id") Long id) {
        BpmLoanGuaranteeDO loanGuarantee = loanGuaranteeService.getLoanGuarantee(id);
        return success(BpmLoanGuaranteeConvert.INSTANCE.convert(loanGuarantee));
    }

    @GetMapping("/list")
    @ApiOperation("获得担保信息列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('bpm:loan-guarantee:query')")
    public CommonResult<List<BpmLoanGuaranteeRespVO>> getLoanGuaranteeList(@RequestParam("ids") Collection<Long> ids) {
        List<BpmLoanGuaranteeDO> list = loanGuaranteeService.getLoanGuaranteeList(ids);
        return success(BpmLoanGuaranteeConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得担保信息分页")
    @PreAuthorize("@ss.hasPermission('bpm:loan-guarantee:query')")
    public CommonResult<PageResult<BpmLoanGuaranteeRespVO>> getLoanGuaranteePage(@Valid BpmLoanGuaranteePageReqVO pageVO) {
        PageResult<BpmLoanGuaranteeDO> pageResult = loanGuaranteeService.getLoanGuaranteePage(pageVO);
        return success(BpmLoanGuaranteeConvert.INSTANCE.convertPage(pageResult));
    }

}
