package com.zungen.wb.module.erp.service.assets;

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

    @Override
    public Long createAssetsIdReader(ErpAssetsIdReaderCreateReqVO createReqVO) {
        // 插入
        ErpAssetsIdReaderDO assetsIdReader = ErpAssetsIdReaderConvert.INSTANCE.convert(createReqVO);
        assetsIdReaderMapper.insert(assetsIdReader);
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
    }

    @Override
    public void deleteAssetsIdReader(Long id) {
        // 校验存在
        this.validateAssetsIdReaderExists(id);
        // 删除
        assetsIdReaderMapper.deleteById(id);
    }

    private void validateAssetsIdReaderExists(Long id) {
        if (assetsIdReaderMapper.selectById(id) == null) {
            throw exception(ASSETS_ID_READER_NOT_EXISTS);
        }
    }

    @Override
    public ErpAssetsIdReaderDO getAssetsIdReader(Long id) {
        return assetsIdReaderMapper.selectById(id);
    }

    @Override
    public List<ErpAssetsIdReaderDO> getAssetsIdReaderList(Collection<Long> ids) {
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

}
