package com.zungen.wb.module.bpm.convert.loan;

import java.util.*;

import com.zungen.wb.framework.common.pojo.PageResult;

import com.zungen.wb.module.bpm.controller.admin.loan.vo.identity.BpmLoanIdentityCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.user.BpmLoanUserCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.user.BpmLoanUserRespVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.user.BpmLoanUserUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanUserDO;

/**
 * 贷款人信息 Convert
 *
 * @author minson
 */
@Mapper
public interface BpmLoanUserConvert {

    BpmLoanUserConvert INSTANCE = Mappers.getMapper(BpmLoanUserConvert.class);

    BpmLoanUserDO convert(BpmLoanUserCreateReqVO bean);

    BpmLoanUserDO convert(BpmLoanUserUpdateReqVO bean);

    BpmLoanUserRespVO convert(BpmLoanUserDO bean);

    List<BpmLoanUserRespVO> convertList(List<BpmLoanUserDO> list);

    PageResult<BpmLoanUserRespVO> convertPage(PageResult<BpmLoanUserDO> page);


    default BpmLoanIdentityCreateReqVO convert2(BpmLoanUserCreateReqVO bean) {
        BpmLoanIdentityCreateReqVO identityCreateReqVO = new BpmLoanIdentityCreateReqVO();
        identityCreateReqVO.setUserId(bean.getUserId());
        identityCreateReqVO.setName(bean.getName());
        identityCreateReqVO.setIdentityCardNumber(bean.getIdentityCardNumber());
        identityCreateReqVO.setMobile(bean.getMobile());
        return identityCreateReqVO;
    }

}
