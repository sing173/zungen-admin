package com.zungen.wb.module.system.service.member;

/**
 * Member Service 接口
 *
 * @author admin
 */
public interface MemberService {

    /**
     * 获得会员用户的手机号码
     *
     * @param id 会员用户编号
     * @return 手机号码
     */
    String getMemberUserMobile(Long id);

}
