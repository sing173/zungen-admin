package com.zungen.wb.module.system.convert.errorcode;

import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.module.system.api.errorcode.dto.ErrorCodeAutoGenerateReqDTO;
import com.zungen.wb.module.system.api.errorcode.dto.ErrorCodeRespDTO;
import com.zungen.wb.module.system.controller.admin.errorcode.vo.ErrorCodeCreateReqVO;
import com.zungen.wb.module.system.controller.admin.errorcode.vo.ErrorCodeExcelVO;
import com.zungen.wb.module.system.controller.admin.errorcode.vo.ErrorCodeRespVO;
import com.zungen.wb.module.system.controller.admin.errorcode.vo.ErrorCodeUpdateReqVO;
import com.zungen.wb.module.system.dal.dataobject.errorcode.ErrorCodeDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 错误码 Convert
 *
 * @author admin
 */
@Mapper
public interface ErrorCodeConvert {

    ErrorCodeConvert INSTANCE = Mappers.getMapper(ErrorCodeConvert.class);

    ErrorCodeDO convert(ErrorCodeCreateReqVO bean);

    ErrorCodeDO convert(ErrorCodeUpdateReqVO bean);

    ErrorCodeRespVO convert(ErrorCodeDO bean);

    List<ErrorCodeRespVO> convertList(List<ErrorCodeDO> list);

    PageResult<ErrorCodeRespVO> convertPage(PageResult<ErrorCodeDO> page);

    List<ErrorCodeExcelVO> convertList02(List<ErrorCodeDO> list);

    ErrorCodeDO convert(ErrorCodeAutoGenerateReqDTO bean);

    List<ErrorCodeRespDTO> convertList03(List<ErrorCodeDO> list);

}
