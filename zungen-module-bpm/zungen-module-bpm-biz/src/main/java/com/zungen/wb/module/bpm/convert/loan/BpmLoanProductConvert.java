package com.zungen.wb.module.bpm.convert.loan;

import java.util.*;

import com.zungen.wb.framework.common.pojo.PageResult;

import com.zungen.wb.module.bpm.controller.admin.loan.vo.product.BpmLoanProductCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.product.BpmLoanProductRespVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.product.BpmLoanProductUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanProductDO;

/**
 * 贷款产品 Convert
 *
 * @author minson
 */
@Mapper
public interface BpmLoanProductConvert {

    BpmLoanProductConvert INSTANCE = Mappers.getMapper(BpmLoanProductConvert.class);

    BpmLoanProductDO convert(BpmLoanProductCreateReqVO bean);

    BpmLoanProductDO convert(BpmLoanProductUpdateReqVO bean);

    BpmLoanProductRespVO convert(BpmLoanProductDO bean);

    List<BpmLoanProductRespVO> convertList(List<BpmLoanProductDO> list);

    PageResult<BpmLoanProductRespVO> convertPage(PageResult<BpmLoanProductDO> page);

}
