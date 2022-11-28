package com.zungen.wb.module.bpm.controller.admin.loan;

import com.zungen.wb.framework.common.pojo.CommonResult;
import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.order.BpmLoanOrderCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.order.BpmLoanOrderPageReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.order.BpmLoanOrderRespVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.order.BpmLoanOrderUpdateReqVO;
import com.zungen.wb.module.bpm.convert.loan.BpmLoanOrderConvert;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanOrderDO;
import com.zungen.wb.module.bpm.service.loan.BpmLoanOrderService;
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
import static com.zungen.wb.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Api(tags = "管理后台 - 贷款工单")
@RestController
@RequestMapping("/bpm/loan/order")
@Validated
public class BpmLoanOrderController {

    @Resource
    private BpmLoanOrderService loanOrderService;

    @PostMapping("/create")
    @ApiOperation("创建贷款工单")
    @PreAuthorize("@ss.hasPermission('bpm:loan-order:create')")
    public CommonResult<Long> createLoanOrder(@Valid @RequestBody BpmLoanOrderCreateReqVO createReqVO) {
        return success(loanOrderService.createLoanOrder(getLoginUserId(), createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新贷款工单")
    @PreAuthorize("@ss.hasPermission('bpm:loan-order:update')")
    public CommonResult<Boolean> updateLoanOrder(@Valid @RequestBody BpmLoanOrderUpdateReqVO updateReqVO) {
        loanOrderService.updateLoanOrder(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除贷款工单")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bpm:loan-order:delete')")
    public CommonResult<Boolean> deleteLoanOrder(@RequestParam("id") Long id) {
        loanOrderService.deleteLoanOrder(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得贷款工单")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bpm:loan-order:query')")
    public CommonResult<BpmLoanOrderRespVO> getLoanOrder(@RequestParam("id") Long id) {
        BpmLoanOrderDO loanOrder = loanOrderService.getLoanOrder(id);
        return success(BpmLoanOrderConvert.INSTANCE.convert(loanOrder));
    }

    @GetMapping("/list")
    @ApiOperation("获得贷款工单列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('bpm:loan-order:query')")
    public CommonResult<List<BpmLoanOrderRespVO>> getLoanOrderList(@RequestParam("ids") Collection<Long> ids) {
        List<BpmLoanOrderDO> list = loanOrderService.getLoanOrderList(ids);
        return success(BpmLoanOrderConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得贷款工单分页")
    @PreAuthorize("@ss.hasPermission('bpm:loan-order:query')")
    public CommonResult<PageResult<BpmLoanOrderRespVO>> getLoanOrderPage(@Valid BpmLoanOrderPageReqVO pageVO) {
        PageResult<BpmLoanOrderDO> pageResult = loanOrderService.getLoanOrderPage(pageVO);
        return success(BpmLoanOrderConvert.INSTANCE.convertPage(pageResult));
    }

}
