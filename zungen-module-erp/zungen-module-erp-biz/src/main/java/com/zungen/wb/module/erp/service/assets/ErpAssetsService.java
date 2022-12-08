package com.zungen.wb.module.erp.service.assets;

import java.util.*;
import javax.validation.*;
import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsDO;
import com.zungen.wb.framework.common.pojo.PageResult;

/**
 * 资产 Service 接口
 *
 * @author admin
 */
public interface ErpAssetsService {

    /**
     * 创建资产
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAssets(@Valid ErpAssetsCreateReqVO createReqVO);

    /**
     * 更新资产
     *
     * @param updateReqVO 更新信息
     */
    void updateAssets(@Valid ErpAssetsUpdateReqVO updateReqVO);

    /**
     * 删除资产
     *
     * @param id 编号
     */
    void deleteAssets(Long id);

    /**
     * 获得资产
     *
     * @param id 编号
     * @return 资产
     */
    ErpAssetsDO getAssets(Long id);

    /**
     * 获得资产列表
     *
     * @param ids 编号
     * @return 资产列表
     */
    List<ErpAssetsDO> getAssetsList(Collection<Long> ids);

    /**
     * 获得资产分页
     *
     * @param pageReqVO 分页查询
     * @return 资产分页
     */
    PageResult<ErpAssetsDO> getAssetsPage(ErpAssetsPageReqVO pageReqVO);

}
