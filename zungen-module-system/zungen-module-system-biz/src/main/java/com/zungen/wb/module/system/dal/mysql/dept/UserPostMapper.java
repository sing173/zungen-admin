package com.zungen.wb.module.system.dal.mysql.dept;

import com.zungen.wb.framework.mybatis.core.mapper.BaseMapperX;
import com.zungen.wb.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.zungen.wb.module.system.dal.dataobject.dept.UserPostDO;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper
public interface UserPostMapper extends BaseMapperX<UserPostDO> {

    default List<UserPostDO> selectListByUserId(Long userId) {
        return selectList(new LambdaQueryWrapperX<UserPostDO>()
                .eq(UserPostDO::getUserId, userId));
    }

    default void deleteByUserIdAndPostId(Long userId, Collection<Long> postIds) {
        delete(new LambdaQueryWrapperX<UserPostDO>()
                .eq(UserPostDO::getUserId, userId)
                .in(UserPostDO::getPostId, postIds));
    }

    default List<UserPostDO> selectListByPostIds(Collection<Long> postIds) {
        return selectList(new LambdaQueryWrapperX<UserPostDO>()
                .in(UserPostDO::getPostId, postIds));
    }

    default void deleteByUserId(Long userId){
        delete(Wrappers.lambdaUpdate(UserPostDO.class).eq(UserPostDO::getUserId, userId));
    }
}
