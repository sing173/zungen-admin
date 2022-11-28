package com.zungen.wb.module.bpm.service.loan;

import com.zungen.wb.module.bpm.controller.admin.loan.vo.guarantee.BpmLoanGuaranteeCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.guarantee.BpmLoanGuaranteePageReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.guarantee.BpmLoanGuaranteeUpdateReqVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;

import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanGuaranteeDO;
import com.zungen.wb.framework.common.pojo.PageResult;

import com.zungen.wb.module.bpm.convert.loan.BpmLoanGuaranteeConvert;
import com.zungen.wb.module.bpm.dal.mysql.loan.BpmLoanGuaranteeMapper;

import static com.zungen.wb.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.zungen.wb.module.bpm.enums.ErrorCodeConstants.*;

/**
 * 担保信息 Service 实现类
 *
 * @author minson
 */
@Service
@Validated
public class BpmLoanGuaranteeServiceImpl implements BpmLoanGuaranteeService {

    @Resource
    private BpmLoanGuaranteeMapper loanGuaranteeMapper;

    @Override
    public Long createLoanGuarantee(BpmLoanGuaranteeCreateReqVO createReqVO) {
        // 插入
        BpmLoanGuaranteeDO loanGuarantee = BpmLoanGuaranteeConvert.INSTANCE.convert(createReqVO);
        loanGuaranteeMapper.insert(loanGuarantee);
        // 返回
        return loanGuarantee.getId();
    }

    @Override
    public void updateLoanGuarantee(BpmLoanGuaranteeUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateLoanGuaranteeExists(updateReqVO.getId());
        // 更新
        BpmLoanGuaranteeDO updateObj = BpmLoanGuaranteeConvert.INSTANCE.convert(updateReqVO);
        loanGuaranteeMapper.updateById(updateObj);
    }

    @Override
    public void deleteLoanGuarantee(Long id) {
        // 校验存在
        this.validateLoanGuaranteeExists(id);
        // 删除
        loanGuaranteeMapper.deleteById(id);
    }

    private void validateLoanGuaranteeExists(Long id) {
        if (loanGuaranteeMapper.selectById(id) == null) {
            throw exception(LOAN_GUARANTEE_NOT_EXISTS);
        }
    }

    @Override
    public BpmLoanGuaranteeDO getLoanGuarantee(Long id) {
        return loanGuaranteeMapper.selectById(id);
    }

    @Override
    public List<BpmLoanGuaranteeDO> getLoanGuaranteeList(Collection<Long> ids) {
        return loanGuaranteeMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<BpmLoanGuaranteeDO> getLoanGuaranteePage(BpmLoanGuaranteePageReqVO pageReqVO) {
        return loanGuaranteeMapper.selectPage(pageReqVO);
    }

}
