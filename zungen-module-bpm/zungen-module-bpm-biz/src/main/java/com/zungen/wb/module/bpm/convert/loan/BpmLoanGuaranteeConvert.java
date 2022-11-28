package com.zungen.wb.module.bpm.convert.loan;

import java.util.*;

import com.zungen.wb.framework.common.pojo.PageResult;

import com.zungen.wb.module.bpm.controller.admin.loan.vo.guarantee.BpmLoanGuaranteeCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.guarantee.BpmLoanGuaranteeRespVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.guarantee.BpmLoanGuaranteeUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanGuaranteeDO;

/**
 * 担保信息 Convert
 *
 * @author minson
 */
@Mapper
public interface BpmLoanGuaranteeConvert {

    BpmLoanGuaranteeConvert INSTANCE = Mappers.getMapper(BpmLoanGuaranteeConvert.class);

    BpmLoanGuaranteeDO convert(BpmLoanGuaranteeCreateReqVO bean);

    BpmLoanGuaranteeDO convert(BpmLoanGuaranteeUpdateReqVO bean);

    BpmLoanGuaranteeRespVO convert(BpmLoanGuaranteeDO bean);

    List<BpmLoanGuaranteeRespVO> convertList(List<BpmLoanGuaranteeDO> list);

    PageResult<BpmLoanGuaranteeRespVO> convertPage(PageResult<BpmLoanGuaranteeDO> page);

}
