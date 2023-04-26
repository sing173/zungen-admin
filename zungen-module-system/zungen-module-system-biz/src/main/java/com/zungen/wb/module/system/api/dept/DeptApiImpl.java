package com.zungen.wb.module.system.api.dept;

import com.zungen.wb.module.system.api.dept.dto.DeptRespDTO;
import com.zungen.wb.module.system.convert.dept.DeptConvert;
import com.zungen.wb.module.system.dal.dataobject.dept.DeptDO;
import com.zungen.wb.module.system.service.dept.DeptService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * 部门 API 实现类
 *
 * @author admin
 */
@Service
public class DeptApiImpl implements DeptApi {

    @Resource
    private DeptService deptService;

    @Override
    public DeptRespDTO getDept(Long id) {
        DeptDO dept = deptService.getDept(id);
        return DeptConvert.INSTANCE.convert03(dept);
    }

    @Override
    public List<DeptRespDTO> getDepts(Collection<Long> ids) {
        List<DeptDO> depts = deptService.getDepts(ids);
        return DeptConvert.INSTANCE.convertList03(depts);
    }

    @Override
    public void validDepts(Collection<Long> ids) {
        deptService.validDepts(ids);
    }

}
