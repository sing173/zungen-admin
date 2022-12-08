package com.zungen.wb.module.erp.convert.assets;

import java.util.*;

import com.zungen.wb.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsDO;

/**
 * 资产 Convert
 *
 * @author admin
 */
@Mapper
public interface ErpAssetsConvert {

    ErpAssetsConvert INSTANCE = Mappers.getMapper(ErpAssetsConvert.class);

    ErpAssetsDO convert(ErpAssetsCreateReqVO bean);

    ErpAssetsDO convert(ErpAssetsUpdateReqVO bean);

    ErpAssetsRespVO convert(ErpAssetsDO bean);

    List<ErpAssetsRespVO> convertList(List<ErpAssetsDO> list);

    PageResult<ErpAssetsRespVO> convertPage(PageResult<ErpAssetsDO> page);

}
