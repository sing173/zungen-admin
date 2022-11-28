package com.zungen.wb.module.bpm.convert.loan;

import java.util.*;

import com.zungen.wb.framework.common.pojo.PageResult;

import com.zungen.wb.module.bpm.controller.admin.loan.vo.contact.BpmLoanContactCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.contact.BpmLoanContactRespVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.contact.BpmLoanContactUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanContactDO;

/**
 * 联系人信息 Convert
 *
 * @author minson
 */
@Mapper
public interface BpmLoanContactConvert {

    BpmLoanContactConvert INSTANCE = Mappers.getMapper(BpmLoanContactConvert.class);

    BpmLoanContactDO convert(BpmLoanContactCreateReqVO bean);

    BpmLoanContactDO convert(BpmLoanContactUpdateReqVO bean);

    BpmLoanContactRespVO convert(BpmLoanContactDO bean);

    List<BpmLoanContactRespVO> convertList(List<BpmLoanContactDO> list);

    PageResult<BpmLoanContactRespVO> convertPage(PageResult<BpmLoanContactDO> page);

}
