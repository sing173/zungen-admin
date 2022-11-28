package com.zungen.wb.module.bpm.service.loan;

import java.util.*;
import javax.validation.*;

import com.zungen.wb.module.bpm.controller.admin.loan.vo.guarantee.BpmLoanGuaranteeCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.guarantee.BpmLoanGuaranteePageReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.guarantee.BpmLoanGuaranteeUpdateReqVO;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanGuaranteeDO;
import com.zungen.wb.framework.common.pojo.PageResult;

/**
 * 担保信息 Service 接口
 *
 * @author minson
 */
public interface BpmLoanGuaranteeService {

    /**
     * 创建担保信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createLoanGuarantee(@Valid BpmLoanGuaranteeCreateReqVO createReqVO);

    /**
     * 更新担保信息
     *
     * @param updateReqVO 更新信息
     */
    void updateLoanGuarantee(@Valid BpmLoanGuaranteeUpdateReqVO updateReqVO);

    /**
     * 删除担保信息
     *
     * @param id 编号
     */
    void deleteLoanGuarantee(Long id);

    /**
     * 获得担保信息
     *
     * @param id 编号
     * @return 担保信息
     */
    BpmLoanGuaranteeDO getLoanGuarantee(Long id);

    /**
     * 获得担保信息列表
     *
     * @param ids 编号
     * @return 担保信息列表
     */
    List<BpmLoanGuaranteeDO> getLoanGuaranteeList(Collection<Long> ids);

    /**
     * 获得担保信息分页
     *
     * @param pageReqVO 分页查询
     * @return 担保信息分页
     */
    PageResult<BpmLoanGuaranteeDO> getLoanGuaranteePage(BpmLoanGuaranteePageReqVO pageReqVO);

}
