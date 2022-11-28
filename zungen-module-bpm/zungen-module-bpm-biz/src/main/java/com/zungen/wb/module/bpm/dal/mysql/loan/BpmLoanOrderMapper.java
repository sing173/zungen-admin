package com.zungen.wb.module.bpm.dal.mysql.loan;

import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.zungen.wb.framework.mybatis.core.mapper.BaseMapperX;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.order.BpmLoanOrderPageReqVO;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanOrderDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 贷款工单 Mapper
 *
 * @author minson
 */
@Mapper
public interface BpmLoanOrderMapper extends BaseMapperX<BpmLoanOrderDO> {

    default PageResult<BpmLoanOrderDO> selectPage(BpmLoanOrderPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BpmLoanOrderDO>()
                .eqIfPresent(BpmLoanOrderDO::getRepaymentPeriods, reqVO.getRepaymentPeriods())
                .eqIfPresent(BpmLoanOrderDO::getRepaymentType, reqVO.getRepaymentType())
                .betweenIfPresent(BpmLoanOrderDO::getAuditTime, reqVO.getAuditTime())
                .eqIfPresent(BpmLoanOrderDO::getAuditRemark, reqVO.getAuditRemark())
                .eqIfPresent(BpmLoanOrderDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(BpmLoanOrderDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BpmLoanOrderDO::getId));
    }

}
