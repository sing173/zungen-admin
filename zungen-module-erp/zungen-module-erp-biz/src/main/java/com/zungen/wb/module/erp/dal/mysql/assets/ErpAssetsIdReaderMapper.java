package com.zungen.wb.module.erp.dal.mysql.assets;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.framework.mybatis.core.mapper.BaseMapperX;
import com.zungen.wb.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.zungen.wb.module.erp.controller.admin.assets.vo.ErpAssetsIdReaderExportReqVO;
import com.zungen.wb.module.erp.controller.admin.assets.vo.ErpAssetsIdReaderPageReqVO;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsIdReaderDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 资产-身份证读取仪 Mapper
 *
 * @author admin
 */
@Mapper
public interface ErpAssetsIdReaderMapper extends BaseMapperX<ErpAssetsIdReaderDO> {

    default PageResult<ErpAssetsIdReaderDO> selectPage(ErpAssetsIdReaderPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ErpAssetsIdReaderDO>()
                .eqIfPresent(ErpAssetsIdReaderDO::getPadId, reqVO.getPadId())
                .likeIfPresent(ErpAssetsIdReaderDO::getName, reqVO.getName())
                .eqIfPresent(ErpAssetsIdReaderDO::getCode, reqVO.getCode())
                .eqIfPresent(ErpAssetsIdReaderDO::getSn, reqVO.getSn())
                .eqIfPresent(ErpAssetsIdReaderDO::getStatus, reqVO.getStatus())
                .eqIfPresent(ErpAssetsIdReaderDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(ErpAssetsIdReaderDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ErpAssetsIdReaderDO::getId));
    }

    default List<ErpAssetsIdReaderDO> selectList(ErpAssetsIdReaderExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ErpAssetsIdReaderDO>()
                .eqIfPresent(ErpAssetsIdReaderDO::getPadId, reqVO.getPadId())
                .likeIfPresent(ErpAssetsIdReaderDO::getName, reqVO.getName())
                .eqIfPresent(ErpAssetsIdReaderDO::getCode, reqVO.getCode())
                .eqIfPresent(ErpAssetsIdReaderDO::getSn, reqVO.getSn())
                .eqIfPresent(ErpAssetsIdReaderDO::getStatus, reqVO.getStatus())
                .eqIfPresent(ErpAssetsIdReaderDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(ErpAssetsIdReaderDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ErpAssetsIdReaderDO::getId));
    }

    default ErpAssetsIdReaderDO selectChildAssetByPadId(String padId){
        return selectOne(new QueryWrapper<ErpAssetsIdReaderDO>().eq("pad_id", padId));
    }

    @Update("UPDATE erp_assets_id_reader SET pad_id = #{arg1} WHERE id = #{arg0}")
    void updatePadIdById(String id, String padId);
}
