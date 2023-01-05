package com.zungen.wb.module.erp.service.assets;

import com.zungen.wb.module.erp.convert.assets.ErpAssetsConvert;
import com.zungen.wb.module.erp.enums.assets.AssetsTypeEnum;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsIdReaderDO;
import com.zungen.wb.framework.common.pojo.PageResult;

import com.zungen.wb.module.erp.convert.assets.ErpAssetsIdReaderConvert;
import com.zungen.wb.module.erp.dal.mysql.assets.ErpAssetsIdReaderMapper;

import static com.zungen.wb.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.zungen.wb.module.erp.enums.ErrorCodeConstants.*;

/**
 * 资产-身份证读取仪 Service 实现类
 *
 * @author admin
 */
@Service
@Validated
public class ErpAssetsIdReaderServiceImpl implements ErpAssetsIdReaderService {

    @Resource
    private ErpAssetsIdReaderMapper assetsIdReaderMapper;

    @Resource
    private ErpAssetsService assetsService;

    @Override
    public String createAssetsIdReader(ErpAssetsIdReaderCreateReqVO createReqVO) {
        // 插入
        ErpAssetsIdReaderDO assetsIdReader = ErpAssetsIdReaderConvert.INSTANCE.convert(createReqVO);
        assetsIdReaderMapper.insert(assetsIdReader);
        //插入资产汇总表
        ErpAssetsCreateReqVO assetsCreateReqVO = ErpAssetsConvert.INSTANCE.convertByReader(assetsIdReader);
        assetsCreateReqVO.setType(AssetsTypeEnum.READER.getType());
        assetsCreateReqVO.setCheckInTime(new Date());
        assetsService.createAssets(assetsCreateReqVO);

        // 返回
        return assetsIdReader.getId();
    }

    @Override
    public void updateAssetsIdReader(ErpAssetsIdReaderUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateAssetsIdReaderExists(updateReqVO.getId());
        // 更新
        ErpAssetsIdReaderDO updateObj = ErpAssetsIdReaderConvert.INSTANCE.convert(updateReqVO);
        assetsIdReaderMapper.updateById(updateObj);
        //更新资产汇总表
        assetsService.updateByAssetId(ErpAssetsConvert.INSTANCE.convertByReader2(updateObj));
    }

    @Override
    public void deleteAssetsIdReader(String id) {
        // 校验存在
        this.validateAssetsIdReaderExists(id);
        // 删除
        assetsIdReaderMapper.deleteById(id);
        // 删除资产汇总表记录
        assetsService.deleteAssetsByAssetId(id);
    }

    private void validateAssetsIdReaderExists(String id) {
        if (assetsIdReaderMapper.selectById(id) == null) {
            throw exception(ASSETS_ID_READER_NOT_EXISTS);
        }
    }

    @Override
    public ErpAssetsIdReaderDO getAssetsIdReader(String id) {
        return assetsIdReaderMapper.selectById(id);
    }

    @Override
    public List<ErpAssetsIdReaderDO> getAssetsIdReaderList(Collection<String> ids) {
        return assetsIdReaderMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ErpAssetsIdReaderDO> getAssetsIdReaderPage(ErpAssetsIdReaderPageReqVO pageReqVO) {
        return assetsIdReaderMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ErpAssetsIdReaderDO> getAssetsIdReaderList(ErpAssetsIdReaderExportReqVO exportReqVO) {
        return assetsIdReaderMapper.selectList(exportReqVO);
    }

    @Override
    public void updatePadIdById(String id, String padId) {
        assetsIdReaderMapper.updatePadIdById(id, padId);
        assetsService.updateParentByPadId(id, padId);
    }

    @Override
    public ErpAssetsIdReaderDO selectChildAssetByPadId(String padId) {
        return assetsIdReaderMapper.selectChildAssetByPadId(padId);
    }

}
