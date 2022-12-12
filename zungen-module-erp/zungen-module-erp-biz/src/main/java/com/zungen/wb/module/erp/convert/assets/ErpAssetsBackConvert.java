package com.zungen.wb.module.erp.convert.assets;

import java.util.*;

import com.zungen.wb.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsBackDO;

/**
 * 资产-背夹 Convert
 *
 * @author admin
 */
@Mapper
public interface ErpAssetsBackConvert {

    ErpAssetsBackConvert INSTANCE = Mappers.getMapper(ErpAssetsBackConvert.class);

    ErpAssetsBackDO convert(ErpAssetsBackCreateReqVO bean);

    ErpAssetsBackDO convert(ErpAssetsBackUpdateReqVO bean);

    ErpAssetsBackRespVO convert(ErpAssetsBackDO bean);

    List<ErpAssetsBackRespVO> convertList(List<ErpAssetsBackDO> list);

    PageResult<ErpAssetsBackRespVO> convertPage(PageResult<ErpAssetsBackDO> page);

    List<ErpAssetsBackExcelVO> convertList02(List<ErpAssetsBackDO> list);

}
