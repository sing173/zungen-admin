package com.zungen.wb.module.erp.convert.assets;

import java.util.*;

import com.zungen.wb.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsPadDO;

/**
 * 资产-平板 Convert
 *
 * @author admin
 */
@Mapper
public interface ErpAssetsPadConvert {

    ErpAssetsPadConvert INSTANCE = Mappers.getMapper(ErpAssetsPadConvert.class);

    ErpAssetsPadDO convert(ErpAssetsPadCreateReqVO bean);

    ErpAssetsPadDO convert(ErpAssetsPadUpdateReqVO bean);

    ErpAssetsPadRespVO convert(ErpAssetsPadDO bean);

    List<ErpAssetsPadRespVO> convertList(List<ErpAssetsPadDO> list);

    PageResult<ErpAssetsPadRespVO> convertPage(PageResult<ErpAssetsPadDO> page);

    List<ErpAssetsPadExcelVO> convertList02(List<ErpAssetsPadDO> list);

}
