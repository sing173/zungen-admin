package com.zungen.wb.module.system.convert.permission;

import com.zungen.wb.module.system.controller.admin.permission.vo.menu.MenuCreateReqVO;
import com.zungen.wb.module.system.controller.admin.permission.vo.menu.MenuRespVO;
import com.zungen.wb.module.system.controller.admin.permission.vo.menu.MenuSimpleRespVO;
import com.zungen.wb.module.system.controller.admin.permission.vo.menu.MenuUpdateReqVO;
import com.zungen.wb.module.system.dal.dataobject.permission.MenuDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MenuConvert {

    MenuConvert INSTANCE = Mappers.getMapper(MenuConvert.class);

    List<MenuRespVO> convertList(List<MenuDO> list);

    MenuDO convert(MenuCreateReqVO bean);

    MenuDO convert(MenuUpdateReqVO bean);

    MenuRespVO convert(MenuDO bean);

    List<MenuSimpleRespVO> convertList02(List<MenuDO> list);

}
