package com.zungen.wb.module.erp.dal.mysql.assets;

import java.util.*;

import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.zungen.wb.framework.mybatis.core.mapper.BaseMapperX;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsBackDO;
import org.apache.ibatis.annotations.Mapper;
import com.zungen.wb.module.erp.controller.admin.assets.vo.*;

/**
 * 资产-背夹 Mapper
 *
 * @author admin
 */
@Mapper
public interface ErpAssetsBackMapper extends BaseMapperX<ErpAssetsBackDO> {

    default PageResult<ErpAssetsBackDO> selectPage(ErpAssetsBackPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ErpAssetsBackDO>()
                .likeIfPresent(ErpAssetsBackDO::getName, reqVO.getName())
                .eqIfPresent(ErpAssetsBackDO::getCode, reqVO.getCode())
                .eqIfPresent(ErpAssetsBackDO::getStatus, reqVO.getStatus())
                .eqIfPresent(ErpAssetsBackDO::getSn, reqVO.getSn())
                .betweenIfPresent(ErpAssetsBackDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ErpAssetsBackDO::getId));
    }

    default List<ErpAssetsBackDO> selectList(ErpAssetsBackExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ErpAssetsBackDO>()
                .likeIfPresent(ErpAssetsBackDO::getName, reqVO.getName())
                .eqIfPresent(ErpAssetsBackDO::getCode, reqVO.getCode())
                .eqIfPresent(ErpAssetsBackDO::getStatus, reqVO.getStatus())
                .eqIfPresent(ErpAssetsBackDO::getSn, reqVO.getSn())
                .betweenIfPresent(ErpAssetsBackDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ErpAssetsBackDO::getId));
    }

}
