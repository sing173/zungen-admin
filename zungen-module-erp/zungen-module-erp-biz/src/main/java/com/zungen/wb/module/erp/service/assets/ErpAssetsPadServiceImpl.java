package com.zungen.wb.module.erp.service.assets;

import com.zungen.wb.module.erp.convert.assets.ErpAssetsConvert;
import com.zungen.wb.module.erp.enums.DictTypeConstants;
import com.zungen.wb.module.erp.enums.assets.AssetsTypeEnum;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsPadDO;
import com.zungen.wb.framework.common.pojo.PageResult;

import com.zungen.wb.module.erp.convert.assets.ErpAssetsPadConvert;
import com.zungen.wb.module.erp.dal.mysql.assets.ErpAssetsPadMapper;

import static com.zungen.wb.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.zungen.wb.module.erp.enums.ErrorCodeConstants.*;

/**
 * 资产-平板 Service 实现类
 *
 * @author admin
 */
@Service
@Validated
public class ErpAssetsPadServiceImpl implements ErpAssetsPadService {

    @Resource
    private ErpAssetsPadMapper assetsPadMapper;

    @Resource
    private ErpAssetsService assetsService;

    @Override
    public String createAssetsPad(ErpAssetsPadCreateReqVO createReqVO) {
        // 插入
        ErpAssetsPadDO assetsPad = ErpAssetsPadConvert.INSTANCE.convert(createReqVO);
        assetsPadMapper.insert(assetsPad);
        //插入资产汇总表
        ErpAssetsCreateReqVO assetsCreateReqVO = ErpAssetsConvert.INSTANCE.convertByPad(assetsPad);
        assetsCreateReqVO.setType(AssetsTypeEnum.PAD.getType());
        assetsCreateReqVO.setCheckInTime(new Date());
        assetsService.createAssets(assetsCreateReqVO);

        // 返回
        return assetsPad.getId();
    }

    @Override
    public void updateAssetsPad(ErpAssetsPadUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateAssetsPadExists(updateReqVO.getId());
        // 更新
        ErpAssetsPadDO updateObj = ErpAssetsPadConvert.INSTANCE.convert(updateReqVO);
        assetsPadMapper.updateById(updateObj);
        //更新资产汇总表
        assetsService.updateByAssetId(ErpAssetsConvert.INSTANCE.convertByPad2(updateObj));
    }

    @Override
    public void deleteAssetsPad(String id) {
        // 校验存在
        this.validateAssetsPadExists(id);
        // 删除
        assetsPadMapper.deleteById(id);
        // 删除资产汇总表记录
        assetsService.deleteAssetsByAssetId(id);
    }

    private void validateAssetsPadExists(String id) {
        if (assetsPadMapper.selectById(id) == null) {
            throw exception(ASSETS_PAD_NOT_EXISTS);
        }
    }

    @Override
    public ErpAssetsPadDO getAssetsPad(String id) {
        return assetsPadMapper.selectById(id);
    }

    @Override
    public List<ErpAssetsPadDO> getAssetsPadList(Collection<String> ids) {
        return assetsPadMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ErpAssetsPadDO> getAssetsPadPage(ErpAssetsPadPageReqVO pageReqVO) {
        return assetsPadMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ErpAssetsPadDO> getAssetsPadList(ErpAssetsPadExportReqVO exportReqVO) {
        return assetsPadMapper.selectList(exportReqVO);
    }

}
