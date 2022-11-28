package com.zungen.wb.module.bpm.convert.loan;

import java.util.*;

import com.zungen.wb.framework.common.pojo.PageResult;

import com.zungen.wb.module.bpm.controller.admin.loan.vo.identity.BpmLoanIdentityCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.identity.BpmLoanIdentityRespVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.identity.BpmLoanIdentityUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanIdentityDO;

/**
 * 贷款/担保人-身份要素认证 Convert
 *
 * @author minson
 */
@Mapper
public interface BpmLoanIdentityConvert {

    BpmLoanIdentityConvert INSTANCE = Mappers.getMapper(BpmLoanIdentityConvert.class);

    BpmLoanIdentityDO convert(BpmLoanIdentityCreateReqVO bean);

    BpmLoanIdentityDO convert(BpmLoanIdentityUpdateReqVO bean);

    BpmLoanIdentityRespVO convert(BpmLoanIdentityDO bean);

    List<BpmLoanIdentityRespVO> convertList(List<BpmLoanIdentityDO> list);

    PageResult<BpmLoanIdentityRespVO> convertPage(PageResult<BpmLoanIdentityDO> page);

}
