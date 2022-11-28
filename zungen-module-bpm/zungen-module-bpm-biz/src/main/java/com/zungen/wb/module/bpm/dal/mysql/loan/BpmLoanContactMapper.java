package com.zungen.wb.module.bpm.dal.mysql.loan;

import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.zungen.wb.framework.mybatis.core.mapper.BaseMapperX;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.contact.BpmLoanContactPageReqVO;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanContactDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 联系人信息 Mapper
 *
 * @author minson
 */
@Mapper
public interface BpmLoanContactMapper extends BaseMapperX<BpmLoanContactDO> {

    default PageResult<BpmLoanContactDO> selectPage(BpmLoanContactPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BpmLoanContactDO>()
                .likeIfPresent(BpmLoanContactDO::getName, reqVO.getName())
                .eqIfPresent(BpmLoanContactDO::getMobile, reqVO.getMobile())
                .eqIfPresent(BpmLoanContactDO::getWork, reqVO.getWork())
                .eqIfPresent(BpmLoanContactDO::getEmail, reqVO.getEmail())
                .eqIfPresent(BpmLoanContactDO::getRelationship, reqVO.getRelationship())
                .betweenIfPresent(BpmLoanContactDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(BpmLoanContactDO::getType, reqVO.getType())
                .orderByDesc(BpmLoanContactDO::getId));
    }

}
