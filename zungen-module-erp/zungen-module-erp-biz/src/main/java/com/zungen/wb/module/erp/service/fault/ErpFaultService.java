package com.zungen.wb.module.erp.service.fault;

import java.util.*;
import javax.validation.*;
import com.zungen.wb.module.erp.controller.admin.fault.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.fault.ErpFaultDO;
import com.zungen.wb.framework.common.pojo.PageResult;

/**
 * 故障 Service 接口
 *
 * @author admin
 */
public interface ErpFaultService {

    /**
     * 创建故障
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createFault(@Valid ErpFaultCreateReqVO createReqVO);

    /**
     * 更新故障
     *
     * @param updateReqVO 更新信息
     */
    void updateFault(@Valid ErpFaultUpdateReqVO updateReqVO);

    /**
     * 删除故障
     *
     * @param id 编号
     */
    void deleteFault(Long id);

    /**
     * 获得故障
     *
     * @param id 编号
     * @return 故障
     */
    ErpFaultDO getFault(Long id);

    /**
     * 获得故障列表
     *
     * @param ids 编号
     * @return 故障列表
     */
    List<ErpFaultDO> getFaultList(Collection<Long> ids);

    /**
     * 获得故障分页
     *
     * @param pageReqVO 分页查询
     * @return 故障分页
     */
    PageResult<ErpFaultDO> getFaultPage(ErpFaultPageReqVO pageReqVO);

    /**
     * 获得故障列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 故障列表
     */
    List<ErpFaultDO> getFaultList(ErpFaultExportReqVO exportReqVO);

}
