package com.zungen.wb.module.erp.convert.assets;

import java.util.*;

import com.zungen.wb.framework.common.pojo.PageResult;

import com.zungen.wb.module.erp.dal.dataobject.assets.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import com.zungen.wb.module.erp.controller.admin.assets.vo.*;

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

    //-- 根据pad设备编辑资产汇总记录 --//
    @Mappings({@Mapping(source = "id", target = "assetId")})
    ErpAssetsCreateReqVO convertByPad(ErpAssetsPadDO bean);

    @Mappings({@Mapping(source = "id", target = "assetId")})
    ErpAssetsUpdateReqVO convertByPad2(ErpAssetsPadDO bean);

    //-- 根据背夹设备编辑资产汇总记录 --//
    @Mappings({@Mapping(source = "id", target = "assetId")})
    ErpAssetsCreateReqVO convertByBack(ErpAssetsBackDO bean);

    @Mappings({@Mapping(source = "id", target = "assetId")})
    ErpAssetsUpdateReqVO convertByBack2(ErpAssetsBackDO bean);

    //-- 根据读取仪设备编辑资产汇总记录 --//
    @Mappings({@Mapping(source = "id", target = "assetId")})
    ErpAssetsCreateReqVO convertByReader(ErpAssetsIdReaderDO bean);

    @Mappings({@Mapping(source = "id", target = "assetId")})
    ErpAssetsUpdateReqVO convertByReader2(ErpAssetsIdReaderDO bean);

    //-- 根据读取仪设备编辑资产汇总记录 --//
    @Mappings({@Mapping(source = "id", target = "assetId"),
            @Mapping(source = "code", target = "sn"),
            @Mapping(source = "code", target = "code")})
    ErpAssetsCreateReqVO convertBySim(ErpAssetsSimDO bean);

    @Mappings({@Mapping(source = "id", target = "assetId"),
            @Mapping(source = "code", target = "sn"),
            @Mapping(source = "code", target = "code")})
    ErpAssetsUpdateReqVO convertBySim2(ErpAssetsSimDO bean);

}
