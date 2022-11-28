package com.zungen.wb.module.system.api.permission;

import com.zungen.wb.module.system.service.permission.RoleService;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * 角色 API 实现类
 *
 * @author admin
 */
@Service
public class RoleApiImpl implements RoleApi {

    @Resource
    private RoleService roleService;

    @Override
    public void validRoles(Collection<Long> ids) {
        roleService.validRoles(ids);
    }
}
