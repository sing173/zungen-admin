package com.zungen.wb.module.erp.service.assets;

import com.zungen.wb.module.erp.convert.assets.ErpAssetsConvert;
import com.zungen.wb.module.erp.enums.assets.AssetsTypeEnum;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsBackDO;
import com.zungen.wb.framework.common.pojo.PageResult;

import com.zungen.wb.module.erp.convert.assets.ErpAssetsBackConvert;
import com.zungen.wb.module.erp.dal.mysql.assets.ErpAssetsBackMapper;

import static com.zungen.wb.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.zungen.wb.module.erp.enums.ErrorCodeConstants.*;

/**
 * 资产-背夹 Service 实现类
 *
 * @author admin
 */
@Service
@Validated
public class ErpAssetsBackServiceImpl implements ErpAssetsBackService {

    @Resource
    private ErpAssetsBackMapper assetsBackMapper;

    @Resource
    private ErpAssetsService assetsService;

    @Override
    public String createAssetsBack(ErpAssetsBackCreateReqVO createReqVO) {
        // 插入
        ErpAssetsBackDO assetsBack = ErpAssetsBackConvert.INSTANCE.convert(createReqVO);
        assetsBackMapper.insert(assetsBack);
        //插入资产汇总表
        ErpAssetsCreateReqVO assetsCreateReqVO = ErpAssetsConvert.INSTANCE.convertByBack(assetsBack);
        assetsCreateReqVO.setType(AssetsTypeEnum.BACK.getType());
        assetsCreateReqVO.setCheckInTime(new Date());
        assetsService.createAssets(assetsCreateReqVO);

        // 返回
        return assetsBack.getId();
    }

    @Override
    public void updateAssetsBack(ErpAssetsBackUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateAssetsBackExists(updateReqVO.getId());
        // 更新
        ErpAssetsBackDO updateObj = ErpAssetsBackConvert.INSTANCE.convert(updateReqVO);
        assetsBackMapper.updateById(updateObj);
        //更新资产汇总表
        assetsService.updateByAssetId(ErpAssetsConvert.INSTANCE.convertByBack2(updateObj));
    }

    @Override
    public void deleteAssetsBack(String id) {
        // 校验存在
        this.validateAssetsBackExists(id);
        // 删除
        assetsBackMapper.deleteById(id);
        // 删除资产汇总表记录
        assetsService.deleteAssetsByAssetId(id);
    }

    private void validateAssetsBackExists(String id) {
        if (assetsBackMapper.selectById(id) == null) {
            throw exception(ASSETS_BACK_NOT_EXISTS);
        }
    }

    @Override
    public ErpAssetsBackDO getAssetsBack(String id) {
        return assetsBackMapper.selectById(id);
    }

    @Override
    public ErpAssetsBackDO selectChildAssetByPadId(String padId) {
        return assetsBackMapper.selectChildAssetByPadId(padId);
    }

    @Override
    public List<ErpAssetsBackDO> getAssetsBackList(Collection<String> ids) {
        return assetsBackMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ErpAssetsBackDO> getAssetsBackPage(ErpAssetsBackPageReqVO pageReqVO) {
        return assetsBackMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ErpAssetsBackDO> getAssetsBackList(ErpAssetsBackExportReqVO exportReqVO) {
        return assetsBackMapper.selectList(exportReqVO);
    }

    @Override
    public void updatePadIdById(String id, String padId) {
        assetsBackMapper.updatePadIdById(id, padId);
        assetsService.updateParentByPadId(id, padId);
    }

}
