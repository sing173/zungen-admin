package com.zungen.wb.module.bpm.controller.admin.loan;

import com.zungen.wb.framework.common.pojo.CommonResult;
import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.user.BpmLoanUserCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.user.BpmLoanUserPageReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.user.BpmLoanUserRespVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.user.BpmLoanUserUpdateReqVO;
import com.zungen.wb.module.bpm.convert.loan.BpmLoanUserConvert;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanUserDO;
import com.zungen.wb.module.bpm.service.loan.BpmLoanUserService;
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

@Api(tags = "管理后台 - 贷款人信息")
@RestController
@RequestMapping("/bpm/loan/user")
@Validated
public class BpmLoanUserController {

    @Resource
    private BpmLoanUserService loanUserService;

    @PostMapping("/create")
    @ApiOperation("创建贷款人信息")
    @PreAuthorize("@ss.hasPermission('bpm:loan:create')")
    public CommonResult<Long> createLoanUser(@Valid @RequestBody BpmLoanUserCreateReqVO createReqVO) {
        return success(loanUserService.createLoanUser(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新贷款人信息")
    @PreAuthorize("@ss.hasPermission('bpm:loan:update')")
    public CommonResult<Boolean> updateLoanUser(@Valid @RequestBody BpmLoanUserUpdateReqVO updateReqVO) {
        loanUserService.updateLoanUser(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除贷款人信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bpm:loan:delete')")
    public CommonResult<Boolean> deleteLoanUser(@RequestParam("id") Long id) {
        loanUserService.deleteLoanUser(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得贷款人信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bpm:loan:query')")
    public CommonResult<BpmLoanUserRespVO> getLoanUser(@RequestParam("id") Long id) {
        BpmLoanUserDO loanUser = loanUserService.getLoanUser(id);
        return success(BpmLoanUserConvert.INSTANCE.convert(loanUser));
    }

    @GetMapping("/list")
    @ApiOperation("获得贷款人信息列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('bpm:loan:query')")
    public CommonResult<List<BpmLoanUserRespVO>> getLoanUserList(@RequestParam("ids") Collection<Long> ids) {
        List<BpmLoanUserDO> list = loanUserService.getLoanUserList(ids);
        return success(BpmLoanUserConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得贷款人信息分页")
    @PreAuthorize("@ss.hasPermission('bpm:loan:query')")
    public CommonResult<PageResult<BpmLoanUserRespVO>> getLoanUserPage(@Valid BpmLoanUserPageReqVO pageVO) {
        PageResult<BpmLoanUserDO> pageResult = loanUserService.getLoanUserPage(pageVO);
        return success(BpmLoanUserConvert.INSTANCE.convertPage(pageResult));
    }

}
