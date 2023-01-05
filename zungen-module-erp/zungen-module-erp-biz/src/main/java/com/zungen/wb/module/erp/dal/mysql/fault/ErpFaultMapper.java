package com.zungen.wb.module.erp.dal.mysql.fault;

import java.util.*;

import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.zungen.wb.framework.mybatis.core.mapper.BaseMapperX;
import com.zungen.wb.module.erp.dal.dataobject.fault.ErpFaultDO;
import org.apache.ibatis.annotations.Mapper;
import com.zungen.wb.module.erp.controller.admin.fault.vo.*;

/**
 * 故障 Mapper
 *
 * @author admin
 */
@Mapper
public interface ErpFaultMapper extends BaseMapperX<ErpFaultDO> {

    default PageResult<ErpFaultDO> selectPage(ErpFaultPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ErpFaultDO>()
                .eqIfPresent(ErpFaultDO::getCode, reqVO.getCode())
                .eqIfPresent(ErpFaultDO::getAssetCode, reqVO.getAssetCode())
                .eqIfPresent(ErpFaultDO::getAssetType, reqVO.getAssetType())
                .eqIfPresent(ErpFaultDO::getFaultType, reqVO.getFaultType())
                .betweenIfPresent(ErpFaultDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ErpFaultDO::getId));
    }

    default List<ErpFaultDO> selectList(ErpFaultExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ErpFaultDO>()
                .eqIfPresent(ErpFaultDO::getCode, reqVO.getCode())
                .eqIfPresent(ErpFaultDO::getAssetCode, reqVO.getAssetCode())
                .eqIfPresent(ErpFaultDO::getAssetType, reqVO.getAssetType())
                .eqIfPresent(ErpFaultDO::getFaultType, reqVO.getFaultType())
                .betweenIfPresent(ErpFaultDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ErpFaultDO::getId));
    }

}
