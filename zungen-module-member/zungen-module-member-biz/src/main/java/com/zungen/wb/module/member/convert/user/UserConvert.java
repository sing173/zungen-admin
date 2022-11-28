package com.zungen.wb.module.member.convert.user;

import com.zungen.wb.module.member.api.user.dto.UserInfoDTO;
import com.zungen.wb.module.member.api.user.dto.UserRespDTO;
import com.zungen.wb.module.member.controller.app.user.vo.AppUserInfoRespVO;
import com.zungen.wb.module.member.dal.dataobject.user.MemberUserDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    AppUserInfoRespVO convert(MemberUserDO bean);

    UserRespDTO convert2(MemberUserDO bean);
    UserInfoDTO convertInfo(MemberUserDO bean);
}
