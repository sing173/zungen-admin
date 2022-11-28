package com.zungen.wb.module.bpm.service.loan;

import java.util.*;
import javax.validation.*;

import com.zungen.wb.module.bpm.controller.admin.loan.vo.product.BpmLoanProductCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.product.BpmLoanProductPageReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.product.BpmLoanProductUpdateReqVO;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanProductDO;
import com.zungen.wb.framework.common.pojo.PageResult;

/**
 * 贷款产品 Service 接口
 *
 * @author minson
 */
public interface BpmLoanProductService {

    /**
     * 创建贷款产品
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createLoanProduct(@Valid BpmLoanProductCreateReqVO createReqVO);

    /**
     * 更新贷款产品
     *
     * @param updateReqVO 更新信息
     */
    void updateLoanProduct(@Valid BpmLoanProductUpdateReqVO updateReqVO);

    /**
     * 删除贷款产品
     *
     * @param id 编号
     */
    void deleteLoanProduct(Long id);

    /**
     * 获得贷款产品
     *
     * @param id 编号
     * @return 贷款产品
     */
    BpmLoanProductDO getLoanProduct(Long id);

    /**
     * 获得贷款产品列表
     *
     * @param ids 编号
     * @return 贷款产品列表
     */
    List<BpmLoanProductDO> getLoanProductList(Collection<Long> ids);

    /**
     * 获得贷款产品分页
     *
     * @param pageReqVO 分页查询
     * @return 贷款产品分页
     */
    PageResult<BpmLoanProductDO> getLoanProductPage(BpmLoanProductPageReqVO pageReqVO);

}
