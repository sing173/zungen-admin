package com.zungen.wb.module.erp.service.assets;

import java.util.*;
import javax.validation.*;
import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsBackDO;
import com.zungen.wb.framework.common.pojo.PageResult;

/**
 * 资产-背夹 Service 接口
 *
 * @author admin
 */
public interface ErpAssetsBackService {

    /**
     * 创建资产-背夹
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createAssetsBack(@Valid ErpAssetsBackCreateReqVO createReqVO);

    /**
     * 更新资产-背夹
     *
     * @param updateReqVO 更新信息
     */
    void updateAssetsBack(@Valid ErpAssetsBackUpdateReqVO updateReqVO);

    /**
     * 删除资产-背夹
     *
     * @param id 编号
     */
    void deleteAssetsBack(String id);

    /**
     * 获得资产-背夹
     *
     * @param id 编号
     * @return 资产-背夹
     */
    ErpAssetsBackDO getAssetsBack(String id);

    /**
     * 获得资产-背夹列表
     *
     * @param ids 编号
     * @return 资产-背夹列表
     */
    List<ErpAssetsBackDO> getAssetsBackList(Collection<String> ids);

    /**
     * 获得资产-背夹分页
     *
     * @param pageReqVO 分页查询
     * @return 资产-背夹分页
     */
    PageResult<ErpAssetsBackDO> getAssetsBackPage(ErpAssetsBackPageReqVO pageReqVO);

    /**
     * 获得资产-背夹列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 资产-背夹列表
     */
    List<ErpAssetsBackDO> getAssetsBackList(ErpAssetsBackExportReqVO exportReqVO);

}
