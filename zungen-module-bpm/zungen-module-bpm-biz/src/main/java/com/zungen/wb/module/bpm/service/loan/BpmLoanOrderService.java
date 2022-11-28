package com.zungen.wb.module.bpm.service.loan;

import java.util.*;
import javax.validation.*;

import com.zungen.wb.module.bpm.controller.admin.loan.vo.order.BpmLoanOrderCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.order.BpmLoanOrderPageReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.order.BpmLoanOrderUpdateReqVO;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanOrderDO;
import com.zungen.wb.framework.common.pojo.PageResult;

/**
 * 贷款工单 Service 接口
 *
 * @author minson
 */
public interface BpmLoanOrderService {

    /**
     * 创建贷款工单
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createLoanOrder(Long userId, @Valid BpmLoanOrderCreateReqVO createReqVO);

    /**
     * 更新贷款工单
     *
     * @param updateReqVO 更新信息
     */
    void updateLoanOrder(@Valid BpmLoanOrderUpdateReqVO updateReqVO);

    /**
     * 删除贷款工单
     *
     * @param id 编号
     */
    void deleteLoanOrder(Long id);

    /**
     * 获得贷款工单
     *
     * @param id 编号
     * @return 贷款工单
     */
    BpmLoanOrderDO getLoanOrder(Long id);

    /**
     * 获得贷款工单列表
     *
     * @param ids 编号
     * @return 贷款工单列表
     */
    List<BpmLoanOrderDO> getLoanOrderList(Collection<Long> ids);

    /**
     * 获得贷款工单分页
     *
     * @param pageReqVO 分页查询
     * @return 贷款工单分页
     */
    PageResult<BpmLoanOrderDO> getLoanOrderPage(BpmLoanOrderPageReqVO pageReqVO);

}
