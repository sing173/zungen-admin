package com.zungen.wb.module.bpm.controller.admin.loan;

import com.zungen.wb.framework.common.pojo.CommonResult;
import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.contact.BpmLoanContactCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.contact.BpmLoanContactPageReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.contact.BpmLoanContactRespVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.contact.BpmLoanContactUpdateReqVO;
import com.zungen.wb.module.bpm.convert.loan.BpmLoanContactConvert;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanContactDO;
import com.zungen.wb.module.bpm.service.loan.BpmLoanContactService;
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

@Api(tags = "管理后台 - 联系人信息")
@RestController
@RequestMapping("/bpm/loan-contact")
@Validated
public class BpmLoanContactController {

    @Resource
    private BpmLoanContactService loanContactService;

    @PostMapping("/create")
    @ApiOperation("创建联系人信息")
    @PreAuthorize("@ss.hasPermission('bpm:loan-contact:create')")
    public CommonResult<Long> createLoanContact(@Valid @RequestBody BpmLoanContactCreateReqVO createReqVO) {
        return success(loanContactService.createLoanContact(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新联系人信息")
    @PreAuthorize("@ss.hasPermission('bpm:loan-contact:update')")
    public CommonResult<Boolean> updateLoanContact(@Valid @RequestBody BpmLoanContactUpdateReqVO updateReqVO) {
        loanContactService.updateLoanContact(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除联系人信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bpm:loan-contact:delete')")
    public CommonResult<Boolean> deleteLoanContact(@RequestParam("id") Long id) {
        loanContactService.deleteLoanContact(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得联系人信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bpm:loan-contact:query')")
    public CommonResult<BpmLoanContactRespVO> getLoanContact(@RequestParam("id") Long id) {
        BpmLoanContactDO loanContact = loanContactService.getLoanContact(id);
        return success(BpmLoanContactConvert.INSTANCE.convert(loanContact));
    }

    @GetMapping("/list")
    @ApiOperation("获得联系人信息列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('bpm:loan-contact:query')")
    public CommonResult<List<BpmLoanContactRespVO>> getLoanContactList(@RequestParam("ids") Collection<Long> ids) {
        List<BpmLoanContactDO> list = loanContactService.getLoanContactList(ids);
        return success(BpmLoanContactConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得联系人信息分页")
    @PreAuthorize("@ss.hasPermission('bpm:loan-contact:query')")
    public CommonResult<PageResult<BpmLoanContactRespVO>> getLoanContactPage(@Valid BpmLoanContactPageReqVO pageVO) {
        PageResult<BpmLoanContactDO> pageResult = loanContactService.getLoanContactPage(pageVO);
        return success(BpmLoanContactConvert.INSTANCE.convertPage(pageResult));
    }

}
