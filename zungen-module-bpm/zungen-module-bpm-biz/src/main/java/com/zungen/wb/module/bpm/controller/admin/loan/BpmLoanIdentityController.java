package com.zungen.wb.module.bpm.controller.admin.loan;

import com.zungen.wb.framework.common.pojo.CommonResult;
import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.framework.security.core.annotations.PreAuthenticated;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.identity.BpmLoanIdentityCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.identity.BpmLoanIdentityPageReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.identity.BpmLoanIdentityRespVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.identity.BpmLoanIdentityUpdateReqVO;
import com.zungen.wb.module.bpm.convert.loan.BpmLoanIdentityConvert;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanIdentityDO;
import com.zungen.wb.module.bpm.service.loan.BpmLoanIdentityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

import static com.zungen.wb.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.zungen.wb.framework.common.pojo.CommonResult.success;
import static com.zungen.wb.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;
import static com.zungen.wb.module.infra.enums.ErrorCodeConstants.FILE_IS_EMPTY;

@Api(tags = "管理后台 - 贷款/担保人-身份要素认证")
@RestController
@RequestMapping("/bpm/loan/identity")
@Validated
public class BpmLoanIdentityController {

    @Resource
    private BpmLoanIdentityService loanIdentityService;

    @PostMapping("/upload-id-card-front")
    @ApiOperation("上传身份证正面照片")
    @PreAuthenticated
    public CommonResult<String> uploadIdCardFront(@RequestParam("idCardFile") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw exception(FILE_IS_EMPTY);
        }
        String idCardFileUrl = loanIdentityService.uploadIdCardFront(getLoginUserId(), file.getInputStream());
        return success(idCardFileUrl);
    }

    @PostMapping("/upload-id-card-back")
    @ApiOperation("上传身份证背面照片")
    @PreAuthenticated
    public CommonResult<String> uploadIdCardBack(@RequestParam("idCardFile") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw exception(FILE_IS_EMPTY);
        }
        String idCardFileUrl = loanIdentityService.uploadIdCardBack(getLoginUserId(), file.getInputStream());
        return success(idCardFileUrl);
    }

    @PostMapping("/create")
    @ApiOperation("创建贷款/担保人-身份要素认证")
    @PreAuthorize("@ss.hasPermission('bpm:loan-identity:create')")
    public CommonResult<Long> createLoanIdentity(@Valid @RequestBody BpmLoanIdentityCreateReqVO createReqVO) {
        return success(loanIdentityService.createLoanIdentity(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新贷款/担保人-身份要素认证")
    @PreAuthorize("@ss.hasPermission('bpm:loan-identity:update')")
    public CommonResult<Boolean> updateLoanIdentity(@Valid @RequestBody BpmLoanIdentityUpdateReqVO updateReqVO) {
        loanIdentityService.updateLoanIdentity(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除贷款/担保人-身份要素认证")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bpm:loan-identity:delete')")
    public CommonResult<Boolean> deleteLoanIdentity(@RequestParam("id") Long id) {
        loanIdentityService.deleteLoanIdentity(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得贷款/担保人-身份要素认证")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bpm:loan-identity:query')")
    public CommonResult<BpmLoanIdentityRespVO> getLoanIdentity(@RequestParam("id") Long id) {
        BpmLoanIdentityDO loanIdentity = loanIdentityService.getLoanIdentity(id);
        return success(BpmLoanIdentityConvert.INSTANCE.convert(loanIdentity));
    }

    @GetMapping("/list")
    @ApiOperation("获得贷款/担保人-身份要素认证列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('bpm:loan-identity:query')")
    public CommonResult<List<BpmLoanIdentityRespVO>> getLoanIdentityList(@RequestParam("ids") Collection<Long> ids) {
        List<BpmLoanIdentityDO> list = loanIdentityService.getLoanIdentityList(ids);
        return success(BpmLoanIdentityConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得贷款/担保人-身份要素认证分页")
    @PreAuthorize("@ss.hasPermission('bpm:loan-identity:query')")
    public CommonResult<PageResult<BpmLoanIdentityRespVO>> getLoanIdentityPage(@Valid BpmLoanIdentityPageReqVO pageVO) {
        PageResult<BpmLoanIdentityDO> pageResult = loanIdentityService.getLoanIdentityPage(pageVO);
        return success(BpmLoanIdentityConvert.INSTANCE.convertPage(pageResult));
    }

}
