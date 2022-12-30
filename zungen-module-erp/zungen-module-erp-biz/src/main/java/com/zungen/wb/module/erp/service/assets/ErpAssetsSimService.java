package com.zungen.wb.module.erp.service.assets;

import java.util.*;
import javax.validation.*;
import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsSimDO;
import com.zungen.wb.framework.common.pojo.PageResult;

/**
 * 资产-sim卡 Service 接口
 *
 * @author admin
 */
public interface ErpAssetsSimService {

    /**
     * 创建资产-sim卡
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createAssetsSim(@Valid ErpAssetsSimCreateReqVO createReqVO);

    /**
     * 更新资产-sim卡
     *
     * @param updateReqVO 更新信息
     */
    void updateAssetsSim(@Valid ErpAssetsSimUpdateReqVO updateReqVO);

    /**
     * 删除资产-sim卡
     *
     * @param id 编号
     */
    void deleteAssetsSim(String id);

    /**
     * 获得资产-sim卡
     *
     * @param id 编号
     * @return 资产-sim卡
     */
    ErpAssetsSimDO getAssetsSim(String id);

    /**
     * 获得资产-sim卡列表
     *
     * @param ids 编号
     * @return 资产-sim卡列表
     */
    List<ErpAssetsSimDO> getAssetsSimList(Collection<String> ids);

    /**
     * 获得资产-sim卡分页
     *
     * @param pageReqVO 分页查询
     * @return 资产-sim卡分页
     */
    PageResult<ErpAssetsSimDO> getAssetsSimPage(ErpAssetsSimPageReqVO pageReqVO);

    /**
     * 获得资产-sim卡列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 资产-sim卡列表
     */
    List<ErpAssetsSimDO> getAssetsSimList(ErpAssetsSimExportReqVO exportReqVO);

}
