package com.zungen.wb.module.erp.dal.mysql.assets;

import java.util.*;

import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.zungen.wb.framework.mybatis.core.mapper.BaseMapperX;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsSimDO;
import org.apache.ibatis.annotations.Mapper;
import com.zungen.wb.module.erp.controller.admin.assets.vo.*;

/**
 * 资产-sim卡 Mapper
 *
 * @author admin
 */
@Mapper
public interface ErpAssetsSimMapper extends BaseMapperX<ErpAssetsSimDO> {

    default PageResult<ErpAssetsSimDO> selectPage(ErpAssetsSimPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ErpAssetsSimDO>()
                .likeIfPresent(ErpAssetsSimDO::getName, reqVO.getName())
                .eqIfPresent(ErpAssetsSimDO::getCode, reqVO.getCode())
                .eqIfPresent(ErpAssetsSimDO::getPadId, reqVO.getPadId())
                .eqIfPresent(ErpAssetsSimDO::getIccid, reqVO.getIccid())
                .eqIfPresent(ErpAssetsSimDO::getImsi, reqVO.getImsi())
                .eqIfPresent(ErpAssetsSimDO::getStatus, reqVO.getStatus())
                .eqIfPresent(ErpAssetsSimDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(ErpAssetsSimDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ErpAssetsSimDO::getId));
    }

    default List<ErpAssetsSimDO> selectList(ErpAssetsSimExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ErpAssetsSimDO>()
                .likeIfPresent(ErpAssetsSimDO::getName, reqVO.getName())
                .eqIfPresent(ErpAssetsSimDO::getCode, reqVO.getCode())
                .eqIfPresent(ErpAssetsSimDO::getPadId, reqVO.getPadId())
                .eqIfPresent(ErpAssetsSimDO::getIccid, reqVO.getIccid())
                .eqIfPresent(ErpAssetsSimDO::getImsi, reqVO.getImsi())
                .eqIfPresent(ErpAssetsSimDO::getStatus, reqVO.getStatus())
                .eqIfPresent(ErpAssetsSimDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(ErpAssetsSimDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ErpAssetsSimDO::getId));
    }

}
