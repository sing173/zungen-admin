package com.zungen.wb.module.bpm.dal.mysql.loan;

import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.zungen.wb.framework.mybatis.core.mapper.BaseMapperX;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.product.BpmLoanProductPageReqVO;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanProductDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 贷款产品 Mapper
 *
 * @author minson
 */
@Mapper
public interface BpmLoanProductMapper extends BaseMapperX<BpmLoanProductDO> {

    default PageResult<BpmLoanProductDO> selectPage(BpmLoanProductPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BpmLoanProductDO>()
                .likeIfPresent(BpmLoanProductDO::getName, reqVO.getName())
                .eqIfPresent(BpmLoanProductDO::getNo, reqVO.getNo())
                .eqIfPresent(BpmLoanProductDO::getRates, reqVO.getRates())
                .eqIfPresent(BpmLoanProductDO::getAmount, reqVO.getAmount())
                .eqIfPresent(BpmLoanProductDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(BpmLoanProductDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BpmLoanProductDO::getId));
    }
}
