package com.zungen.wb.module.bpm.controller.admin.loan;

import com.zungen.wb.framework.common.pojo.CommonResult;
import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.product.BpmLoanProductCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.product.BpmLoanProductPageReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.product.BpmLoanProductRespVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.product.BpmLoanProductUpdateReqVO;
import com.zungen.wb.module.bpm.convert.loan.BpmLoanProductConvert;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanProductDO;
import com.zungen.wb.module.bpm.service.loan.BpmLoanProductService;
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

@Api(tags = "管理后台 - 贷款产品")
@RestController
@RequestMapping("/bpm/loan-product")
@Validated
public class BpmLoanProductController {

    @Resource
    private BpmLoanProductService loanProductService;

    @PostMapping("/create")
    @ApiOperation("创建贷款产品")
    @PreAuthorize("@ss.hasPermission('bpm:loan-product:create')")
    public CommonResult<Long> createLoanProduct(@Valid @RequestBody BpmLoanProductCreateReqVO createReqVO) {
        return success(loanProductService.createLoanProduct(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新贷款产品")
    @PreAuthorize("@ss.hasPermission('bpm:loan-product:update')")
    public CommonResult<Boolean> updateLoanProduct(@Valid @RequestBody BpmLoanProductUpdateReqVO updateReqVO) {
        loanProductService.updateLoanProduct(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除贷款产品")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bpm:loan-product:delete')")
    public CommonResult<Boolean> deleteLoanProduct(@RequestParam("id") Long id) {
        loanProductService.deleteLoanProduct(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得贷款产品")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bpm:loan-product:query')")
    public CommonResult<BpmLoanProductRespVO> getLoanProduct(@RequestParam("id") Long id) {
        BpmLoanProductDO loanProduct = loanProductService.getLoanProduct(id);
        return success(BpmLoanProductConvert.INSTANCE.convert(loanProduct));
    }

    @GetMapping("/list")
    @ApiOperation("获得贷款产品列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('bpm:loan-product:query')")
    public CommonResult<List<BpmLoanProductRespVO>> getLoanProductList(@RequestParam("ids") Collection<Long> ids) {
        List<BpmLoanProductDO> list = loanProductService.getLoanProductList(ids);
        return success(BpmLoanProductConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得贷款产品分页")
    @PreAuthorize("@ss.hasPermission('bpm:loan-product:query')")
    public CommonResult<PageResult<BpmLoanProductRespVO>> getLoanProductPage(@Valid BpmLoanProductPageReqVO pageVO) {
        PageResult<BpmLoanProductDO> pageResult = loanProductService.getLoanProductPage(pageVO);
        return success(BpmLoanProductConvert.INSTANCE.convertPage(pageResult));
    }

}
