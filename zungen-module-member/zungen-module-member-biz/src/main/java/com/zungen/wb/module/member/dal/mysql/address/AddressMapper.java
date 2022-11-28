package com.zungen.wb.module.member.dal.mysql.address;


import com.zungen.wb.framework.mybatis.core.mapper.BaseMapperX;
import com.zungen.wb.framework.mybatis.core.query.QueryWrapperX;
import com.zungen.wb.module.member.dal.dataobject.address.AddressDO;
import com.zungen.wb.module.member.enums.AddressTypeEnum;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户收件地址 Mapper
 *
 * @author admin
 */
@Mapper
public interface AddressMapper extends BaseMapperX<AddressDO> {

    /**
     * 获取当前地址 根据id和userId
     * @param userId
     * @param id
     * @return
     */
    default AddressDO getAddressByIdAndUserId(Long userId, Long id) {
        QueryWrapperX<AddressDO> queryWrapperX = new QueryWrapperX<>();
        queryWrapperX.eq("user_id", userId).eq("id", id);
        return selectList(queryWrapperX).stream().findFirst().orElse(null);
    }

    /**
     * 获取地址列表
     * @param userId
     * @param type
     * @return
     */
    default List<AddressDO> selectListByUserIdAndType(Long userId, Integer type) {
        QueryWrapperX<AddressDO> queryWrapperX = new QueryWrapperX<AddressDO>().eq("user_id", userId)
                .eqIfPresent("type", type);
        return selectList(queryWrapperX);
    }

    /**
     * 获取默认地址
     * @param userId
     * @return
     */
    default AddressDO getDefaultUserAddress(Long userId) {
        List<AddressDO> addressDOList = selectListByUserIdAndType(userId, AddressTypeEnum.DEFAULT.getType());
        return addressDOList.stream().findFirst().orElse(null);
    }

    /**
     * 获取默认地址
     * @param id
     * @param addressTypeEnum
     * @return
     */
    default int updateTypeById(Long id, AddressTypeEnum addressTypeEnum) {
       return updateById(new AddressDO().setId(id).setType(addressTypeEnum.getType()));
    }

}
