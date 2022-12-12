package com.zungen.wb.module.erp.convert.assets;

import java.util.*;

import com.zungen.wb.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsIdReaderDO;

/**
 * 资产-身份证读取仪 Convert
 *
 * @author admin
 */
@Mapper
public interface ErpAssetsIdReaderConvert {

    ErpAssetsIdReaderConvert INSTANCE = Mappers.getMapper(ErpAssetsIdReaderConvert.class);

    ErpAssetsIdReaderDO convert(ErpAssetsIdReaderCreateReqVO bean);

    ErpAssetsIdReaderDO convert(ErpAssetsIdReaderUpdateReqVO bean);

    ErpAssetsIdReaderRespVO convert(ErpAssetsIdReaderDO bean);

    List<ErpAssetsIdReaderRespVO> convertList(List<ErpAssetsIdReaderDO> list);

    PageResult<ErpAssetsIdReaderRespVO> convertPage(PageResult<ErpAssetsIdReaderDO> page);

    List<ErpAssetsIdReaderExcelVO> convertList02(List<ErpAssetsIdReaderDO> list);

}
