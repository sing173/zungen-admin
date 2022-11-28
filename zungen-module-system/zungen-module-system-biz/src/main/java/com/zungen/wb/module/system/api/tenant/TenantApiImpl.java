package com.zungen.wb.module.system.api.tenant;

import com.zungen.wb.module.system.service.tenant.TenantService;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 多租户的 API 实现类
 *
 * @author admin
 */
@Service
public class TenantApiImpl implements TenantApi {

    @Resource
    private TenantService tenantService;

    @Override
    public List<Long> getTenantIds() {
        return tenantService.getTenantIds();
    }

    @Override
    public void validTenant(Long id) {
        tenantService.validTenant(id);
    }

}
