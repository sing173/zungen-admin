package com.zungen.wb.module.erp.service.assets;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import java.util.*;
import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsDO;
import com.zungen.wb.framework.common.pojo.PageResult;

import com.zungen.wb.module.erp.convert.assets.ErpAssetsConvert;
import com.zungen.wb.module.erp.dal.mysql.assets.ErpAssetsMapper;

import static com.zungen.wb.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.zungen.wb.module.erp.enums.ErrorCodeConstants.*;

/**
 * 资产 Service 实现类
 *
 * @author admin
 */
@Service
@Validated
public class ErpAssetsServiceImpl implements ErpAssetsService {

    @Resource
    private ErpAssetsMapper assetsMapper;

    @Override
    public Long createAssets(ErpAssetsCreateReqVO createReqVO) {
        // 插入
        ErpAssetsDO assets = ErpAssetsConvert.INSTANCE.convert(createReqVO);
        assetsMapper.insert(assets);
        // 返回
        return assets.getId();
    }

    @Override
    public void updateAssets(ErpAssetsUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateAssetsExists(updateReqVO.getId());
        // 更新
        ErpAssetsDO updateObj = ErpAssetsConvert.INSTANCE.convert(updateReqVO);
        assetsMapper.updateById(updateObj);
    }

    @Override
    public void updateByAssetId(@Valid ErpAssetsUpdateReqVO updateReqVO){
        // 校验存在
        ErpAssetsDO updateObj = assetsMapper.selectByAssetId(updateReqVO.getAssetId());
        if (updateObj == null) {
            throw exception(ASSETS_NOT_EXISTS);
        }
        // 更新
        updateObj.setStatus(updateReqVO.getStatus());
        updateObj.setCode(updateReqVO.getCode());
        updateObj.setName(updateReqVO.getName());
        updateObj.setRemark(updateReqVO.getRemark());
        updateObj.setSn(updateReqVO.getSn());
        updateObj.setUseDept(updateReqVO.getUseDept());

        assetsMapper.updateByAssetId(updateObj, updateReqVO.getAssetId());
    }

    @Override
    public void deleteAssets(Long id) {
        // 校验存在
        this.validateAssetsExists(id);
        // 删除
        assetsMapper.deleteById(id);
    }

    @Override
    public void deleteAssetsByAssetId(String assetId) {
        if (assetsMapper.selectByAssetId(assetId) != null) {
            assetsMapper.deleteByAssetId(assetId);
        }

    }

    private void validateAssetsExists(Long id) {
        if (assetsMapper.selectById(id) == null) {
            throw exception(ASSETS_NOT_EXISTS);
        }
    }

    @Override
    public ErpAssetsDO getAssets(Long id) {
        return assetsMapper.selectById(id);
    }

    @Override
    public List<ErpAssetsDO> getAssetsList(Collection<Long> ids) {
        return assetsMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ErpAssetsDO> getAssetsPage(ErpAssetsPageReqVO pageReqVO) {
        return assetsMapper.selectPage(pageReqVO);
    }


}
