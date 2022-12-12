package com.zungen.wb.module.erp.convert.assets;

import java.util.*;

import com.zungen.wb.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsSimDO;

/**
 * 资产-sim卡 Convert
 *
 * @author admin
 */
@Mapper
public interface ErpAssetsSimConvert {

    ErpAssetsSimConvert INSTANCE = Mappers.getMapper(ErpAssetsSimConvert.class);

    ErpAssetsSimDO convert(ErpAssetsSimCreateReqVO bean);

    ErpAssetsSimDO convert(ErpAssetsSimUpdateReqVO bean);

    ErpAssetsSimRespVO convert(ErpAssetsSimDO bean);

    List<ErpAssetsSimRespVO> convertList(List<ErpAssetsSimDO> list);

    PageResult<ErpAssetsSimRespVO> convertPage(PageResult<ErpAssetsSimDO> page);

    List<ErpAssetsSimExcelVO> convertList02(List<ErpAssetsSimDO> list);

}
