package com.zungen.wb.module.erp.service.assets;

import java.util.*;
import javax.validation.*;
import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsIdReaderDO;
import com.zungen.wb.framework.common.pojo.PageResult;

/**
 * 资产-身份证读取仪 Service 接口
 *
 * @author admin
 */
public interface ErpAssetsIdReaderService {

    /**
     * 创建资产-身份证读取仪
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createAssetsIdReader(@Valid ErpAssetsIdReaderCreateReqVO createReqVO);

    /**
     * 更新资产-身份证读取仪
     *
     * @param updateReqVO 更新信息
     */
    void updateAssetsIdReader(@Valid ErpAssetsIdReaderUpdateReqVO updateReqVO);

    /**
     * 删除资产-身份证读取仪
     *
     * @param id 编号
     */
    void deleteAssetsIdReader(String id);

    /**
     * 获得资产-身份证读取仪
     *
     * @param id 编号
     * @return 资产-身份证读取仪
     */
    ErpAssetsIdReaderDO getAssetsIdReader(String id);

    /**
     * 获得资产-身份证读取仪列表
     *
     * @param ids 编号
     * @return 资产-身份证读取仪列表
     */
    List<ErpAssetsIdReaderDO> getAssetsIdReaderList(Collection<String> ids);

    /**
     * 获得资产-身份证读取仪分页
     *
     * @param pageReqVO 分页查询
     * @return 资产-身份证读取仪分页
     */
    PageResult<ErpAssetsIdReaderDO> getAssetsIdReaderPage(ErpAssetsIdReaderPageReqVO pageReqVO);

    /**
     * 获得资产-身份证读取仪列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 资产-身份证读取仪列表
     */
    List<ErpAssetsIdReaderDO> getAssetsIdReaderList(ErpAssetsIdReaderExportReqVO exportReqVO);

    /**
     * 更新关联平板id
     * @param id
     * @param padId
     */
    void updatePadIdById(String id, String padId);

    /**
     * 根据关联padId找读取仪
     * @param padId
     * @return
     */
    ErpAssetsIdReaderDO selectChildAssetByPadId(String padId);
}
