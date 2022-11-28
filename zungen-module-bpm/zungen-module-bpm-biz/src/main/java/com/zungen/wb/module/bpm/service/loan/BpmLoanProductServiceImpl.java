package com.zungen.wb.module.bpm.service.loan;

import com.zungen.wb.module.bpm.controller.admin.loan.vo.product.BpmLoanProductCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.product.BpmLoanProductPageReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.product.BpmLoanProductUpdateReqVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;

import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanProductDO;
import com.zungen.wb.framework.common.pojo.PageResult;

import com.zungen.wb.module.bpm.convert.loan.BpmLoanProductConvert;
import com.zungen.wb.module.bpm.dal.mysql.loan.BpmLoanProductMapper;

import static com.zungen.wb.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.zungen.wb.module.bpm.enums.ErrorCodeConstants.LOAN_PRODUCT_NOT_EXISTS;

/**
 * 贷款产品 Service 实现类
 *
 * @author minson
 */
@Service
@Validated
public class BpmLoanProductServiceImpl implements BpmLoanProductService {

    @Resource
    private BpmLoanProductMapper loanProductMapper;

    @Override
    public Long createLoanProduct(BpmLoanProductCreateReqVO createReqVO) {
        // 插入
        BpmLoanProductDO loanProduct = BpmLoanProductConvert.INSTANCE.convert(createReqVO);
        loanProductMapper.insert(loanProduct);
        // 返回
        return loanProduct.getId();
    }

    @Override
    public void updateLoanProduct(BpmLoanProductUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateLoanProductExists(updateReqVO.getId());
        // 更新
        BpmLoanProductDO updateObj = BpmLoanProductConvert.INSTANCE.convert(updateReqVO);
        loanProductMapper.updateById(updateObj);
    }

    @Override
    public void deleteLoanProduct(Long id) {
        // 校验存在
        this.validateLoanProductExists(id);
        // 删除
        loanProductMapper.deleteById(id);
    }

    private void validateLoanProductExists(Long id) {
        if (loanProductMapper.selectById(id) == null) {
            throw exception(LOAN_PRODUCT_NOT_EXISTS);
        }
    }

    @Override
    public BpmLoanProductDO getLoanProduct(Long id) {
        return loanProductMapper.selectById(id);
    }

    @Override
    public List<BpmLoanProductDO> getLoanProductList(Collection<Long> ids) {
        return loanProductMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<BpmLoanProductDO> getLoanProductPage(BpmLoanProductPageReqVO pageReqVO) {
        return loanProductMapper.selectPage(pageReqVO);
    }

}
