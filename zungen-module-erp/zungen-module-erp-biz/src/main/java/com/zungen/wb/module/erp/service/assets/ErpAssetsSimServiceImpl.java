package com.zungen.wb.module.erp.service.assets;

import com.zungen.wb.module.erp.convert.assets.ErpAssetsConvert;
import com.zungen.wb.module.erp.enums.assets.AssetsTypeEnum;
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

    @Resource
    private ErpAssetsService assetsService;

    @Override
    public String createAssetsSim(ErpAssetsSimCreateReqVO createReqVO) {
        // 插入
        ErpAssetsSimDO assetsSim = ErpAssetsSimConvert.INSTANCE.convert(createReqVO);
        assetsSimMapper.insert(assetsSim);
        //插入资产汇总表
        ErpAssetsCreateReqVO assetsCreateReqVO = ErpAssetsConvert.INSTANCE.convertBySim(assetsSim);
        assetsCreateReqVO.setType(AssetsTypeEnum.SIM.getType());
        assetsCreateReqVO.setCheckInTime(new Date());
        assetsService.createAssets(assetsCreateReqVO);
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
        //更新资产汇总表
        assetsService.updateByAssetId(ErpAssetsConvert.INSTANCE.convertBySim2(updateObj));
    }

    @Override
    public void deleteAssetsSim(String id) {
        // 校验存在
        this.validateAssetsSimExists(id);
        // 删除
        assetsSimMapper.deleteById(id);
        // 删除资产汇总表记录
        assetsService.deleteAssetsByAssetId(id);
    }

    private void validateAssetsSimExists(String id) {
        if (assetsSimMapper.selectById(id) == null) {
            throw exception(ASSETS_SIM_NOT_EXISTS);
        }
    }

    @Override
    public ErpAssetsSimDO getAssetsSim(String id) {
        return assetsSimMapper.selectById(id);
    }

    @Override
    public List<ErpAssetsSimDO> getAssetsSimList(Collection<String> ids) {
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
