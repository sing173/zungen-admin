package com.zungen.wb.module.erp.service.assets;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import com.zungen.wb.framework.test.core.ut.BaseDbUnitTest;

import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsDO;
import com.zungen.wb.module.erp.dal.mysql.assets.ErpAssetsMapper;
import com.zungen.wb.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;
import java.util.*;

import static com.zungen.wb.module.erp.enums.ErrorCodeConstants.*;
import static com.zungen.wb.framework.test.core.util.AssertUtils.*;
import static com.zungen.wb.framework.test.core.util.RandomUtils.*;
import static com.zungen.wb.framework.common.util.object.ObjectUtils.*;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link ErpAssetsServiceImpl} 的单元测试类
*
* @author admin
*/
@Import(ErpAssetsServiceImpl.class)
public class ErpAssetsServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ErpAssetsServiceImpl assetsService;

    @Resource
    private ErpAssetsMapper assetsMapper;

    @Test
    public void testCreateAssets_success() {
        // 准备参数
        ErpAssetsCreateReqVO reqVO = randomPojo(ErpAssetsCreateReqVO.class);

        // 调用
        Long assetsId = assetsService.createAssets(reqVO);
        // 断言
        assertNotNull(assetsId);
        // 校验记录的属性是否正确
        ErpAssetsDO assets = assetsMapper.selectById(assetsId);
        assertPojoEquals(reqVO, assets);
    }

    @Test
    public void testUpdateAssets_success() {
        // mock 数据
        ErpAssetsDO dbAssets = randomPojo(ErpAssetsDO.class);
        assetsMapper.insert(dbAssets);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ErpAssetsUpdateReqVO reqVO = randomPojo(ErpAssetsUpdateReqVO.class, o -> {
            o.setId(dbAssets.getId()); // 设置更新的 ID
        });

        // 调用
        assetsService.updateAssets(reqVO);
        // 校验是否更新正确
        ErpAssetsDO assets = assetsMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, assets);
    }

    @Test
    public void testUpdateAssets_notExists() {
        // 准备参数
        ErpAssetsUpdateReqVO reqVO = randomPojo(ErpAssetsUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> assetsService.updateAssets(reqVO), ASSETS_NOT_EXISTS);
    }

    @Test
    public void testDeleteAssets_success() {
        // mock 数据
        ErpAssetsDO dbAssets = randomPojo(ErpAssetsDO.class);
        assetsMapper.insert(dbAssets);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbAssets.getId();

        // 调用
        assetsService.deleteAssets(id);
       // 校验数据不存在了
       assertNull(assetsMapper.selectById(id));
    }

    @Test
    public void testDeleteAssets_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> assetsService.deleteAssets(id), ASSETS_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAssetsPage() {
       // mock 数据
       ErpAssetsDO dbAssets = randomPojo(ErpAssetsDO.class, o -> { // 等会查询到
           o.setCode(null);
           o.setType(null);
           o.setStatus(null);
           o.setCheckInTime(null);
       });
       assetsMapper.insert(dbAssets);
       // 测试 code 不匹配
       assetsMapper.insert(cloneIgnoreId(dbAssets, o -> o.setCode(null)));
       // 测试 type 不匹配
       assetsMapper.insert(cloneIgnoreId(dbAssets, o -> o.setType(null)));
       // 测试 status 不匹配
       assetsMapper.insert(cloneIgnoreId(dbAssets, o -> o.setStatus(null)));
       // 测试 checkInTime 不匹配
       assetsMapper.insert(cloneIgnoreId(dbAssets, o -> o.setCheckInTime(null)));
       // 准备参数
       ErpAssetsPageReqVO reqVO = new ErpAssetsPageReqVO();
       reqVO.setCode(null);
       reqVO.setType(null);
       reqVO.setStatus(null);
       reqVO.setCheckInTime((new Date[]{}));

       // 调用
       PageResult<ErpAssetsDO> pageResult = assetsService.getAssetsPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbAssets, pageResult.getList().get(0));
    }

}
