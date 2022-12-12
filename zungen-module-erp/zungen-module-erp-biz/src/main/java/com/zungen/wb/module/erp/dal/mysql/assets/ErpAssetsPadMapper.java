package com.zungen.wb.module.erp.dal.mysql.assets;

import java.util.*;

import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.zungen.wb.framework.mybatis.core.mapper.BaseMapperX;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsPadDO;
import org.apache.ibatis.annotations.Mapper;
import com.zungen.wb.module.erp.controller.admin.assets.vo.*;

/**
 * 资产-平板 Mapper
 *
 * @author admin
 */
@Mapper
public interface ErpAssetsPadMapper extends BaseMapperX<ErpAssetsPadDO> {

    default PageResult<ErpAssetsPadDO> selectPage(ErpAssetsPadPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ErpAssetsPadDO>()
                .likeIfPresent(ErpAssetsPadDO::getName, reqVO.getName())
                .eqIfPresent(ErpAssetsPadDO::getCode, reqVO.getCode())
                .eqIfPresent(ErpAssetsPadDO::getStatus, reqVO.getStatus())
                .eqIfPresent(ErpAssetsPadDO::getMeid, reqVO.getMeid())
                .eqIfPresent(ErpAssetsPadDO::getSn, reqVO.getSn())
                .eqIfPresent(ErpAssetsPadDO::getModelNo, reqVO.getModelNo())
                .eqIfPresent(ErpAssetsPadDO::getBatchNo, reqVO.getBatchNo())
                .eqIfPresent(ErpAssetsPadDO::getRom, reqVO.getRom())
                .eqIfPresent(ErpAssetsPadDO::getSpecs, reqVO.getSpecs())
                .eqIfPresent(ErpAssetsPadDO::getBlueMac, reqVO.getBlueMac())
                .eqIfPresent(ErpAssetsPadDO::getMac, reqVO.getMac())
                .eqIfPresent(ErpAssetsPadDO::getUseDept, reqVO.getUseDept())
                .eqIfPresent(ErpAssetsPadDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(ErpAssetsPadDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ErpAssetsPadDO::getId));
    }

    default List<ErpAssetsPadDO> selectList(ErpAssetsPadExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ErpAssetsPadDO>()
                .likeIfPresent(ErpAssetsPadDO::getName, reqVO.getName())
                .eqIfPresent(ErpAssetsPadDO::getCode, reqVO.getCode())
                .eqIfPresent(ErpAssetsPadDO::getStatus, reqVO.getStatus())
                .eqIfPresent(ErpAssetsPadDO::getMeid, reqVO.getMeid())
                .eqIfPresent(ErpAssetsPadDO::getSn, reqVO.getSn())
                .eqIfPresent(ErpAssetsPadDO::getModelNo, reqVO.getModelNo())
                .eqIfPresent(ErpAssetsPadDO::getBatchNo, reqVO.getBatchNo())
                .eqIfPresent(ErpAssetsPadDO::getRom, reqVO.getRom())
                .eqIfPresent(ErpAssetsPadDO::getSpecs, reqVO.getSpecs())
                .eqIfPresent(ErpAssetsPadDO::getBlueMac, reqVO.getBlueMac())
                .eqIfPresent(ErpAssetsPadDO::getMac, reqVO.getMac())
                .eqIfPresent(ErpAssetsPadDO::getUseDept, reqVO.getUseDept())
                .eqIfPresent(ErpAssetsPadDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(ErpAssetsPadDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ErpAssetsPadDO::getId));
    }

}
