package com.zungen.wb.module.bpm.service.loan;

import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.identity.BpmLoanIdentityCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.user.BpmLoanUserCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.user.BpmLoanUserPageReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.user.BpmLoanUserUpdateReqVO;
import com.zungen.wb.module.bpm.convert.loan.BpmLoanUserConvert;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanUserDO;
import com.zungen.wb.module.bpm.dal.mysql.loan.BpmLoanUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static com.zungen.wb.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.zungen.wb.module.bpm.enums.ErrorCodeConstants.LOAN_USER_NOT_EXISTS;

/**
 * 贷款人信息 Service 实现类
 *
 * @author minson
 */
@Service
@Validated
public class BpmLoanUserServiceImpl implements BpmLoanUserService {

    @Resource
    private BpmLoanUserMapper loanUserMapper;

    @Resource
    private BpmLoanIdentityService loanIdentityService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createLoanUser(BpmLoanUserCreateReqVO createReqVO) {
        //先插入身份认证信息
        BpmLoanIdentityCreateReqVO identityCreateReqVO = BpmLoanUserConvert.INSTANCE.convert2(createReqVO);
        Long identityId = loanIdentityService.createLoanIdentity(identityCreateReqVO);

        // 插入贷款人信息
        BpmLoanUserDO loanUser = BpmLoanUserConvert.INSTANCE.convert(createReqVO);
        loanUser.setIdentityId(identityId);
        loanUserMapper.insert(loanUser);

        // 返回
        return loanUser.getId();
    }

    @Override
    public void updateLoanUser(BpmLoanUserUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateLoanUserExists(updateReqVO.getId());
        // 更新
        BpmLoanUserDO updateObj = BpmLoanUserConvert.INSTANCE.convert(updateReqVO);
        loanUserMapper.updateById(updateObj);
    }

    @Override
    public void deleteLoanUser(Long id) {
        // 校验存在
        this.validateLoanUserExists(id);
        // 删除
        loanUserMapper.deleteById(id);
    }

    private void validateLoanUserExists(Long id) {
        if (loanUserMapper.selectById(id) == null) {
            throw exception(LOAN_USER_NOT_EXISTS);
        }
    }

    @Override
    public BpmLoanUserDO getLoanUser(Long id) {
        return loanUserMapper.selectById(id);
    }

    @Override
    public List<BpmLoanUserDO> getLoanUserList(Collection<Long> ids) {
        return loanUserMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<BpmLoanUserDO> getLoanUserPage(BpmLoanUserPageReqVO pageReqVO) {
        return loanUserMapper.selectPage(pageReqVO);
    }

}
