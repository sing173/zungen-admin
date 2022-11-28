package com.zungen.wb.module.system.api.user;

import com.zungen.wb.module.system.api.user.dto.AdminUserRespDTO;
import com.zungen.wb.module.system.convert.user.UserConvert;
import com.zungen.wb.module.system.dal.dataobject.user.AdminUserDO;
import com.zungen.wb.module.system.service.user.AdminUserService;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Admin 用户 API 实现类
 *
 * @author admin
 */
@Service
public class AdminUserApiImpl implements AdminUserApi {

    @Resource
    private AdminUserService userService;

    @Override
    public AdminUserRespDTO getUser(Long id) {
        AdminUserDO user = userService.getUser(id);
        return UserConvert.INSTANCE.convert4(user);
    }

    @Override
    public List<AdminUserRespDTO> getUsers(Collection<Long> ids) {
        List<AdminUserDO> users = userService.getUsers(ids);
        return UserConvert.INSTANCE.convertList4(users);
    }

    @Override
    public List<AdminUserRespDTO> getUsersByDeptIds(Collection<Long> deptIds) {
        List<AdminUserDO> users = userService.getUsersByDeptIds(deptIds);
        return UserConvert.INSTANCE.convertList4(users);
    }

    @Override
    public List<AdminUserRespDTO> getUsersByPostIds(Collection<Long> postIds) {
        List<AdminUserDO> users = userService.getUsersByPostIds(postIds);
        return UserConvert.INSTANCE.convertList4(users);
    }

    @Override
    public void validUsers(Set<Long> ids) {
        userService.validUsers(ids);
    }

}
