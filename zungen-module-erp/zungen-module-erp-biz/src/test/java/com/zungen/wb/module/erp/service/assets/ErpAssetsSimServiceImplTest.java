package com.zungen.wb.module.erp.service.assets;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import com.zungen.wb.framework.test.core.ut.BaseDbUnitTest;

import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsSimDO;
import com.zungen.wb.module.erp.dal.mysql.assets.ErpAssetsSimMapper;
import com.zungen.wb.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;

import static cn.hutool.core.util.RandomUtil.*;
import static com.zungen.wb.module.erp.enums.ErrorCodeConstants.*;
import static com.zungen.wb.framework.test.core.util.AssertUtils.*;
import static com.zungen.wb.framework.test.core.util.RandomUtils.*;
import static com.zungen.wb.framework.common.util.object.ObjectUtils.*;
import static com.zungen.wb.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link ErpAssetsSimServiceImpl} 的单元测试类
*
* @author admin
*/
@Import(ErpAssetsSimServiceImpl.class)
public class ErpAssetsSimServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ErpAssetsSimServiceImpl assetsSimService;

    @Resource
    private ErpAssetsSimMapper assetsSimMapper;

    @Test
    public void testCreateAssetsSim_success() {
        // 准备参数
        ErpAssetsSimCreateReqVO reqVO = randomPojo(ErpAssetsSimCreateReqVO.class);

        // 调用
        String assetsSimId = assetsSimService.createAssetsSim(reqVO);
        // 断言
        assertNotNull(assetsSimId);
        // 校验记录的属性是否正确
        ErpAssetsSimDO assetsSim = assetsSimMapper.selectById(assetsSimId);
        assertPojoEquals(reqVO, assetsSim);
    }

    @Test
    public void testUpdateAssetsSim_success() {
        // mock 数据
        ErpAssetsSimDO dbAssetsSim = randomPojo(ErpAssetsSimDO.class);
        assetsSimMapper.insert(dbAssetsSim);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ErpAssetsSimUpdateReqVO reqVO = randomPojo(ErpAssetsSimUpdateReqVO.class, o -> {
            o.setId(dbAssetsSim.getId()); // 设置更新的 ID
        });

        // 调用
        assetsSimService.updateAssetsSim(reqVO);
        // 校验是否更新正确
        ErpAssetsSimDO assetsSim = assetsSimMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, assetsSim);
    }

    @Test
    public void testUpdateAssetsSim_notExists() {
        // 准备参数
        ErpAssetsSimUpdateReqVO reqVO = randomPojo(ErpAssetsSimUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> assetsSimService.updateAssetsSim(reqVO), ASSETS_SIM_NOT_EXISTS);
    }

    @Test
    public void testDeleteAssetsSim_success() {
        // mock 数据
        ErpAssetsSimDO dbAssetsSim = randomPojo(ErpAssetsSimDO.class);
        assetsSimMapper.insert(dbAssetsSim);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbAssetsSim.getId();

        // 调用
        assetsSimService.deleteAssetsSim(id);
       // 校验数据不存在了
       assertNull(assetsSimMapper.selectById(id));
    }

    @Test
    public void testDeleteAssetsSim_notExists() {
        // 准备参数
        String id = randomString();

        // 调用, 并断言异常
        assertServiceException(() -> assetsSimService.deleteAssetsSim(id), ASSETS_SIM_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAssetsSimPage() {
       // mock 数据
       ErpAssetsSimDO dbAssetsSim = randomPojo(ErpAssetsSimDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setCode(null);
           o.setPadId(null);
           o.setIccid(null);
           o.setImsi(null);
           o.setStatus(null);
           o.setRemark(null);
           o.setCreateTime(null);
       });
       assetsSimMapper.insert(dbAssetsSim);
       // 测试 name 不匹配
       assetsSimMapper.insert(cloneIgnoreId(dbAssetsSim, o -> o.setName(null)));
       // 测试 code 不匹配
       assetsSimMapper.insert(cloneIgnoreId(dbAssetsSim, o -> o.setCode(null)));
       // 测试 padId 不匹配
       assetsSimMapper.insert(cloneIgnoreId(dbAssetsSim, o -> o.setPadId(null)));
       // 测试 iccid 不匹配
       assetsSimMapper.insert(cloneIgnoreId(dbAssetsSim, o -> o.setIccid(null)));
       // 测试 imsi 不匹配
       assetsSimMapper.insert(cloneIgnoreId(dbAssetsSim, o -> o.setImsi(null)));
       // 测试 status 不匹配
       assetsSimMapper.insert(cloneIgnoreId(dbAssetsSim, o -> o.setStatus(null)));
       // 测试 remark 不匹配
       assetsSimMapper.insert(cloneIgnoreId(dbAssetsSim, o -> o.setRemark(null)));
       // 测试 createTime 不匹配
       assetsSimMapper.insert(cloneIgnoreId(dbAssetsSim, o -> o.setCreateTime(null)));
       // 准备参数
       ErpAssetsSimPageReqVO reqVO = new ErpAssetsSimPageReqVO();
       reqVO.setName(null);
       reqVO.setCode(null);
       reqVO.setPadId(null);
       reqVO.setIccid(null);
       reqVO.setImsi(null);
       reqVO.setStatus(null);
       reqVO.setRemark(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<ErpAssetsSimDO> pageResult = assetsSimService.getAssetsSimPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbAssetsSim, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAssetsSimList() {
       // mock 数据
       ErpAssetsSimDO dbAssetsSim = randomPojo(ErpAssetsSimDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setCode(null);
           o.setPadId(null);
           o.setIccid(null);
           o.setImsi(null);
           o.setStatus(null);
           o.setRemark(null);
           o.setCreateTime(null);
       });
       assetsSimMapper.insert(dbAssetsSim);
       // 测试 name 不匹配
       assetsSimMapper.insert(cloneIgnoreId(dbAssetsSim, o -> o.setName(null)));
       // 测试 code 不匹配
       assetsSimMapper.insert(cloneIgnoreId(dbAssetsSim, o -> o.setCode(null)));
       // 测试 padId 不匹配
       assetsSimMapper.insert(cloneIgnoreId(dbAssetsSim, o -> o.setPadId(null)));
       // 测试 iccid 不匹配
       assetsSimMapper.insert(cloneIgnoreId(dbAssetsSim, o -> o.setIccid(null)));
       // 测试 imsi 不匹配
       assetsSimMapper.insert(cloneIgnoreId(dbAssetsSim, o -> o.setImsi(null)));
       // 测试 status 不匹配
       assetsSimMapper.insert(cloneIgnoreId(dbAssetsSim, o -> o.setStatus(null)));
       // 测试 remark 不匹配
       assetsSimMapper.insert(cloneIgnoreId(dbAssetsSim, o -> o.setRemark(null)));
       // 测试 createTime 不匹配
       assetsSimMapper.insert(cloneIgnoreId(dbAssetsSim, o -> o.setCreateTime(null)));
       // 准备参数
       ErpAssetsSimExportReqVO reqVO = new ErpAssetsSimExportReqVO();
       reqVO.setName(null);
       reqVO.setCode(null);
       reqVO.setPadId(null);
       reqVO.setIccid(null);
       reqVO.setImsi(null);
       reqVO.setStatus(null);
       reqVO.setRemark(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<ErpAssetsSimDO> list = assetsSimService.getAssetsSimList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbAssetsSim, list.get(0));
    }

}
