package com.zungen.wb.module.erp.service.assets;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsSimDO;
import com.zungen.wb.framework.common.pojo.PageResult;

import com.zungen.wb.module.erp.convert.assets.ErpAssetsSimConvert;
import com.zungen.wb.module.erp.dal.mysql.assets.ErpAssetsSimMapper;

import static com.zungen.wb.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.zungen.wb.module.erp.enums.ErrorCodeConstants.*;

/**
 * 资产-sim卡 Service 实现类
 *
 * @author admin
 */
@Service
@Validated
public class ErpAssetsSimServiceImpl implements ErpAssetsSimService {

    @Resource
    private ErpAssetsSimMapper assetsSimMapper;

    @Override
    public Long createAssetsSim(ErpAssetsSimCreateReqVO createReqVO) {
        // 插入
        ErpAssetsSimDO assetsSim = ErpAssetsSimConvert.INSTANCE.convert(createReqVO);
        assetsSimMapper.insert(assetsSim);
        // 返回
        return assetsSim.getId();
    }

    @Override
    public void updateAssetsSim(ErpAssetsSimUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateAssetsSimExists(updateReqVO.getId());
        // 更新
        ErpAssetsSimDO updateObj = ErpAssetsSimConvert.INSTANCE.convert(updateReqVO);
        assetsSimMapper.updateById(updateObj);
    }

    @Override
    public void deleteAssetsSim(Long id) {
        // 校验存在
        this.validateAssetsSimExists(id);
        // 删除
        assetsSimMapper.deleteById(id);
    }

    private void validateAssetsSimExists(Long id) {
        if (assetsSimMapper.selectById(id) == null) {
            throw exception(ASSETS_SIM_NOT_EXISTS);
        }
    }

    @Override
    public ErpAssetsSimDO getAssetsSim(Long id) {
        return assetsSimMapper.selectById(id);
    }

    @Override
    public List<ErpAssetsSimDO> getAssetsSimList(Collection<Long> ids) {
        return assetsSimMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ErpAssetsSimDO> getAssetsSimPage(ErpAssetsSimPageReqVO pageReqVO) {
        return assetsSimMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ErpAssetsSimDO> getAssetsSimList(ErpAssetsSimExportReqVO exportReqVO) {
        return assetsSimMapper.selectList(exportReqVO);
    }

}
