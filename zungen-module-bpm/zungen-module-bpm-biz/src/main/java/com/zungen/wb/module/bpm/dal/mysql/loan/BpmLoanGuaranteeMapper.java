package com.zungen.wb.module.bpm.dal.mysql.loan;

import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.zungen.wb.framework.mybatis.core.mapper.BaseMapperX;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.guarantee.BpmLoanGuaranteePageReqVO;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanGuaranteeDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 担保信息 Mapper
 *
 * @author minson
 */
@Mapper
public interface BpmLoanGuaranteeMapper extends BaseMapperX<BpmLoanGuaranteeDO> {

    default PageResult<BpmLoanGuaranteeDO> selectPage(BpmLoanGuaranteePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BpmLoanGuaranteeDO>()
                .likeIfPresent(BpmLoanGuaranteeDO::getName, reqVO.getName())
                .eqIfPresent(BpmLoanGuaranteeDO::getMobile, reqVO.getMobile())
                .eqIfPresent(BpmLoanGuaranteeDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(BpmLoanGuaranteeDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BpmLoanGuaranteeDO::getId));
    }

}
