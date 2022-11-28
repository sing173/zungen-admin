package com.zungen.wb.module.bpm.service.loan;

import com.zungen.wb.module.bpm.controller.admin.loan.vo.contact.BpmLoanContactCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.contact.BpmLoanContactPageReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.contact.BpmLoanContactUpdateReqVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;

import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanContactDO;
import com.zungen.wb.framework.common.pojo.PageResult;

import com.zungen.wb.module.bpm.convert.loan.BpmLoanContactConvert;
import com.zungen.wb.module.bpm.dal.mysql.loan.BpmLoanContactMapper;

import static com.zungen.wb.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.zungen.wb.module.bpm.enums.ErrorCodeConstants.*;

/**
 * 联系人信息 Service 实现类
 *
 * @author minson
 */
@Service
@Validated
public class BpmLoanContactServiceImpl implements BpmLoanContactService {

    @Resource
    private BpmLoanContactMapper loanContactMapper;

    @Override
    public Long createLoanContact(BpmLoanContactCreateReqVO createReqVO) {
        // 插入
        BpmLoanContactDO loanContact = BpmLoanContactConvert.INSTANCE.convert(createReqVO);
        loanContactMapper.insert(loanContact);
        // 返回
        return loanContact.getId();
    }

    @Override
    public void updateLoanContact(BpmLoanContactUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateLoanContactExists(updateReqVO.getId());
        // 更新
        BpmLoanContactDO updateObj = BpmLoanContactConvert.INSTANCE.convert(updateReqVO);
        loanContactMapper.updateById(updateObj);
    }

    @Override
    public void deleteLoanContact(Long id) {
        // 校验存在
        this.validateLoanContactExists(id);
        // 删除
        loanContactMapper.deleteById(id);
    }

    private void validateLoanContactExists(Long id) {
        if (loanContactMapper.selectById(id) == null) {
            throw exception(LOAN_CONTACT_NOT_EXISTS);
        }
    }

    @Override
    public BpmLoanContactDO getLoanContact(Long id) {
        return loanContactMapper.selectById(id);
    }

    @Override
    public List<BpmLoanContactDO> getLoanContactList(Collection<Long> ids) {
        return loanContactMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<BpmLoanContactDO> getLoanContactPage(BpmLoanContactPageReqVO pageReqVO) {
        return loanContactMapper.selectPage(pageReqVO);
    }

}
