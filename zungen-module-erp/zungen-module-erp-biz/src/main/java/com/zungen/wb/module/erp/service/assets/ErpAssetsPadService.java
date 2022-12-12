package com.zungen.wb.module.erp.service.assets;

import java.util.*;
import javax.validation.*;
import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsPadDO;
import com.zungen.wb.framework.common.pojo.PageResult;

/**
 * 资产-平板 Service 接口
 *
 * @author admin
 */
public interface ErpAssetsPadService {

    /**
     * 创建资产-平板
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAssetsPad(@Valid ErpAssetsPadCreateReqVO createReqVO);

    /**
     * 更新资产-平板
     *
     * @param updateReqVO 更新信息
     */
    void updateAssetsPad(@Valid ErpAssetsPadUpdateReqVO updateReqVO);

    /**
     * 删除资产-平板
     *
     * @param id 编号
     */
    void deleteAssetsPad(Long id);

    /**
     * 获得资产-平板
     *
     * @param id 编号
     * @return 资产-平板
     */
    ErpAssetsPadDO getAssetsPad(Long id);

    /**
     * 获得资产-平板列表
     *
     * @param ids 编号
     * @return 资产-平板列表
     */
    List<ErpAssetsPadDO> getAssetsPadList(Collection<Long> ids);

    /**
     * 获得资产-平板分页
     *
     * @param pageReqVO 分页查询
     * @return 资产-平板分页
     */
    PageResult<ErpAssetsPadDO> getAssetsPadPage(ErpAssetsPadPageReqVO pageReqVO);

    /**
     * 获得资产-平板列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 资产-平板列表
     */
    List<ErpAssetsPadDO> getAssetsPadList(ErpAssetsPadExportReqVO exportReqVO);

}
