package com.zungen.wb.module.bpm.convert.loan;

import java.util.*;

import com.zungen.wb.framework.common.pojo.PageResult;

import com.zungen.wb.module.bpm.controller.admin.loan.vo.order.BpmLoanOrderCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.order.BpmLoanOrderRespVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.order.BpmLoanOrderUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanOrderDO;

/**
 * 贷款工单 Convert
 *
 * @author minson
 */
@Mapper
public interface BpmLoanOrderConvert {

    BpmLoanOrderConvert INSTANCE = Mappers.getMapper(BpmLoanOrderConvert.class);

    BpmLoanOrderDO convert(BpmLoanOrderCreateReqVO bean);

    BpmLoanOrderDO convert(BpmLoanOrderUpdateReqVO bean);

    BpmLoanOrderRespVO convert(BpmLoanOrderDO bean);

    List<BpmLoanOrderRespVO> convertList(List<BpmLoanOrderDO> list);

    PageResult<BpmLoanOrderRespVO> convertPage(PageResult<BpmLoanOrderDO> page);

}
