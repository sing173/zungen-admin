package com.zungen.wb.module.bpm.dal.mysql.loan;

import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.framework.mybatis.core.mapper.BaseMapperX;
import com.zungen.wb.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.user.BpmLoanUserPageReqVO;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanUserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 贷款人信息 Mapper
 *
 * @author minson
 */
@Mapper
public interface BpmLoanUserMapper extends BaseMapperX<BpmLoanUserDO> {

    default PageResult<BpmLoanUserDO> selectPage(BpmLoanUserPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BpmLoanUserDO>()
                .likeIfPresent(BpmLoanUserDO::getName, reqVO.getName())
                .likeIfPresent(BpmLoanUserDO::getMobile, reqVO.getMobile())
                .betweenIfPresent(BpmLoanUserDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BpmLoanUserDO::getId));
    }

}
