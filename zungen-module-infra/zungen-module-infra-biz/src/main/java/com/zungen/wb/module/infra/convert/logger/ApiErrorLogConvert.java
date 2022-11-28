package com.zungen.wb.module.infra.convert.logger;

import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;
import com.zungen.wb.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogExcelVO;
import com.zungen.wb.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogRespVO;
import com.zungen.wb.module.infra.dal.dataobject.logger.ApiErrorLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * API 错误日志 Convert
 *
 * @author admin
 */
@Mapper
public interface ApiErrorLogConvert {

    ApiErrorLogConvert INSTANCE = Mappers.getMapper(ApiErrorLogConvert.class);

    ApiErrorLogRespVO convert(ApiErrorLogDO bean);

    PageResult<ApiErrorLogRespVO> convertPage(PageResult<ApiErrorLogDO> page);

    List<ApiErrorLogExcelVO> convertList02(List<ApiErrorLogDO> list);

    ApiErrorLogDO convert(ApiErrorLogCreateReqDTO bean);

}
