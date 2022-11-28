package com.zungen.wb.module.member.convert.social;

import com.zungen.wb.module.member.controller.app.social.vo.AppSocialUserBindReqVO;
import com.zungen.wb.module.member.controller.app.social.vo.AppSocialUserUnbindReqVO;
import com.zungen.wb.module.system.api.social.dto.SocialUserBindReqDTO;
import com.zungen.wb.module.system.api.social.dto.SocialUserUnbindReqDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SocialUserConvert {

    SocialUserConvert INSTANCE = Mappers.getMapper(SocialUserConvert.class);

    SocialUserBindReqDTO convert(Long userId, Integer userType, AppSocialUserBindReqVO reqVO);

    SocialUserUnbindReqDTO convert(Long userId, Integer userType, AppSocialUserUnbindReqVO reqVO);

}
