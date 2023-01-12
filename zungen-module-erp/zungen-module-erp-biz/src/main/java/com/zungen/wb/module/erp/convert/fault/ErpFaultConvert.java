package com.zungen.wb.module.erp.convert.fault;

import java.util.*;

import com.zungen.wb.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.zungen.wb.module.erp.controller.admin.fault.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.fault.ErpFaultDO;

/**
 * 故障 Convert
 *
 * @author admin
 */
@Mapper
public interface ErpFaultConvert {

    ErpFaultConvert INSTANCE = Mappers.getMapper(ErpFaultConvert.class);

    ErpFaultDO convert(ErpFaultCreateReqVO bean);

    ErpFaultDO convert(ErpFaultUpdateReqVO bean);

    ErpFaultRespVO convert(ErpFaultDO bean);

    List<ErpFaultRespVO> convertList(List<ErpFaultDO> list);

    PageResult<ErpFaultRespVO> convertPage(PageResult<ErpFaultDO> page);

    List<ErpFaultExcelVO> convertList02(List<ErpFaultDO> list);

    ErpFaultDO convert(ErpFaultHandleReqVO handleReqVO);
}
