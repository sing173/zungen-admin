package com.zungen.wb.module.system.dal.mysql.errorcode;

import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.framework.mybatis.core.mapper.BaseMapperX;
import com.zungen.wb.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.zungen.wb.module.system.controller.admin.errorcode.vo.ErrorCodeExportReqVO;
import com.zungen.wb.module.system.controller.admin.errorcode.vo.ErrorCodePageReqVO;
import com.zungen.wb.module.system.dal.dataobject.errorcode.ErrorCodeDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Mapper
public interface ErrorCodeMapper extends BaseMapperX<ErrorCodeDO> {

    default PageResult<ErrorCodeDO> selectPage(ErrorCodePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ErrorCodeDO>()
                .eqIfPresent(ErrorCodeDO::getType, reqVO.getType())
                .likeIfPresent(ErrorCodeDO::getApplicationName, reqVO.getApplicationName())
                .eqIfPresent(ErrorCodeDO::getCode, reqVO.getCode())
                .likeIfPresent(ErrorCodeDO::getMessage, reqVO.getMessage())
                .betweenIfPresent(ErrorCodeDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ErrorCodeDO::getCode));
    }

    default List<ErrorCodeDO> selectList(ErrorCodeExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ErrorCodeDO>()
                .eqIfPresent(ErrorCodeDO::getType, reqVO.getType())
                .likeIfPresent(ErrorCodeDO::getApplicationName, reqVO.getApplicationName())
                .eqIfPresent(ErrorCodeDO::getCode, reqVO.getCode())
                .likeIfPresent(ErrorCodeDO::getMessage, reqVO.getMessage())
                .betweenIfPresent(ErrorCodeDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ErrorCodeDO::getCode));
    }

    default List<ErrorCodeDO> selectListByCodes(Collection<Integer> codes) {
        return selectList(new LambdaQueryWrapperX<ErrorCodeDO>().in(ErrorCodeDO::getCode, codes));
    }

    default ErrorCodeDO selectByCode(Integer code) {
        return selectOne(new LambdaQueryWrapperX<ErrorCodeDO>().eq(ErrorCodeDO::getCode, code));
    }

    default List<ErrorCodeDO> selectListByApplicationNameAndUpdateTimeGt(String applicationName, Date minUpdateTime) {
        return selectList(new LambdaQueryWrapperX<ErrorCodeDO>().eq(ErrorCodeDO::getApplicationName, applicationName)
                .gtIfPresent(ErrorCodeDO::getUpdateTime, minUpdateTime));
    }

}
