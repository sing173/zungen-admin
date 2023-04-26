package com.zungen.wb.module.erp.dal.mysql.assets;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.zungen.wb.framework.mybatis.core.mapper.BaseMapperX;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsDO;
import org.apache.ibatis.annotations.Mapper;
import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import org.apache.ibatis.annotations.Update;

/**
 * 资产 Mapper
 *
 * @author admin
 */
@Mapper
public interface ErpAssetsMapper extends BaseMapperX<ErpAssetsDO> {

    default PageResult<ErpAssetsDO> selectPage(ErpAssetsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ErpAssetsDO>()
                .likeIfPresent(ErpAssetsDO::getCode, reqVO.getCode())
                .eqIfPresent(ErpAssetsDO::getType, reqVO.getType())
                .eqIfPresent(ErpAssetsDO::getStatus, reqVO.getStatus())
                .eqIfPresent(ErpAssetsDO::getUseDept, reqVO.getUseDept())
                .betweenIfPresent(ErpAssetsDO::getCheckInTime, reqVO.getCheckInTime())
                .orderByDesc(ErpAssetsDO::getId));
    }

    default ErpAssetsDO selectByAssetId(String assetId){
        return selectOne(new QueryWrapper<ErpAssetsDO>().eq("asset_id", assetId));
    }

    default void updateByAssetId(ErpAssetsDO erpAssetsDO, String assetId) {
        update(erpAssetsDO, new QueryWrapper<ErpAssetsDO>().eq("asset_id", assetId));

    }

    default void deleteByAssetId(String assetId){
        delete(Wrappers.lambdaUpdate(ErpAssetsDO.class).eq(ErpAssetsDO::getAssetId, assetId));
    }

    @Update("UPDATE erp_assets SET parent = #{arg1} WHERE asset_id = #{arg0}")
    void updateParentByPadId(String assetId, String padId);

}
