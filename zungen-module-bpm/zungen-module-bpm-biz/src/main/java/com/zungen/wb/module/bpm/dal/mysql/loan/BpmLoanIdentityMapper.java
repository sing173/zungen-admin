package com.zungen.wb.module.bpm.dal.mysql.loan;

import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.framework.mybatis.core.mapper.BaseMapperX;
import com.zungen.wb.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.identity.BpmLoanIdentityPageReqVO;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanIdentityDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 贷款/担保人-身份要素认证 Mapper
 *
 * @author minson
 */
@Mapper
public interface BpmLoanIdentityMapper extends BaseMapperX<BpmLoanIdentityDO> {

    default PageResult<BpmLoanIdentityDO> selectPage(BpmLoanIdentityPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BpmLoanIdentityDO>()
                .likeIfPresent(BpmLoanIdentityDO::getName, reqVO.getName())
                .likeIfPresent(BpmLoanIdentityDO::getMobile, reqVO.getMobile())
                .eqIfPresent(BpmLoanIdentityDO::getIdentityCardNumber, reqVO.getIdentityCardNumber())
                .eqIfPresent(BpmLoanIdentityDO::getFaceStatus, reqVO.getFaceStatus())
                .eqIfPresent(BpmLoanIdentityDO::getAuthStatus, reqVO.getAuthStatus())
                .eqIfPresent(BpmLoanIdentityDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(BpmLoanIdentityDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BpmLoanIdentityDO::getId));
    }
}
