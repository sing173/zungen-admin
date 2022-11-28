package com.zungen.wb.module.member.api.user;

import com.zungen.wb.module.member.api.user.dto.UserRespDTO;

/**
 * 会员用户的 API 接口
 *
 * @author admin
 */
public interface MemberUserApi {

    /**
     * 获得会员用户信息
     *
     * @param id 用户编号
     * @return 用户信息
     */
    UserRespDTO getUser(Long id);

}
