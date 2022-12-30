package com.zungen.wb.module.erp.service.assets;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import com.zungen.wb.framework.test.core.ut.BaseDbUnitTest;

import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsBackDO;
import com.zungen.wb.module.erp.dal.mysql.assets.ErpAssetsBackMapper;
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
* {@link ErpAssetsBackServiceImpl} 的单元测试类
*
* @author admin
*/
@Import(ErpAssetsBackServiceImpl.class)
public class ErpAssetsBackServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ErpAssetsBackServiceImpl assetsBackService;

    @Resource
    private ErpAssetsBackMapper assetsBackMapper;

    @Test
    public void testCreateAssetsBack_success() {
        // 准备参数
        ErpAssetsBackCreateReqVO reqVO = randomPojo(ErpAssetsBackCreateReqVO.class);

        // 调用
        String assetsBackId = assetsBackService.createAssetsBack(reqVO);
        // 断言
        assertNotNull(assetsBackId);
        // 校验记录的属性是否正确
        ErpAssetsBackDO assetsBack = assetsBackMapper.selectById(assetsBackId);
        assertPojoEquals(reqVO, assetsBack);
    }

    @Test
    public void testUpdateAssetsBack_success() {
        // mock 数据
        ErpAssetsBackDO dbAssetsBack = randomPojo(ErpAssetsBackDO.class);
        assetsBackMapper.insert(dbAssetsBack);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ErpAssetsBackUpdateReqVO reqVO = randomPojo(ErpAssetsBackUpdateReqVO.class, o -> {
            o.setId(dbAssetsBack.getId()); // 设置更新的 ID
        });

        // 调用
        assetsBackService.updateAssetsBack(reqVO);
        // 校验是否更新正确
        ErpAssetsBackDO assetsBack = assetsBackMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, assetsBack);
    }

    @Test
    public void testUpdateAssetsBack_notExists() {
        // 准备参数
        ErpAssetsBackUpdateReqVO reqVO = randomPojo(ErpAssetsBackUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> assetsBackService.updateAssetsBack(reqVO), ASSETS_BACK_NOT_EXISTS);
    }

    @Test
    public void testDeleteAssetsBack_success() {
        // mock 数据
        ErpAssetsBackDO dbAssetsBack = randomPojo(ErpAssetsBackDO.class);
        assetsBackMapper.insert(dbAssetsBack);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbAssetsBack.getId();

        // 调用
        assetsBackService.deleteAssetsBack(id);
       // 校验数据不存在了
       assertNull(assetsBackMapper.selectById(id));
    }

    @Test
    public void testDeleteAssetsBack_notExists() {
        // 准备参数
        String id = randomString();

        // 调用, 并断言异常
        assertServiceException(() -> assetsBackService.deleteAssetsBack(id), ASSETS_BACK_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAssetsBackPage() {
       // mock 数据
       ErpAssetsBackDO dbAssetsBack = randomPojo(ErpAssetsBackDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setCode(null);
           o.setStatus(null);
           o.setSn(null);
           o.setCreateTime(null);
       });
       assetsBackMapper.insert(dbAssetsBack);
       // 测试 name 不匹配
       assetsBackMapper.insert(cloneIgnoreId(dbAssetsBack, o -> o.setName(null)));
       // 测试 code 不匹配
       assetsBackMapper.insert(cloneIgnoreId(dbAssetsBack, o -> o.setCode(null)));
       // 测试 status 不匹配
       assetsBackMapper.insert(cloneIgnoreId(dbAssetsBack, o -> o.setStatus(null)));
       // 测试 sn 不匹配
       assetsBackMapper.insert(cloneIgnoreId(dbAssetsBack, o -> o.setSn(null)));
       // 测试 createTime 不匹配
       assetsBackMapper.insert(cloneIgnoreId(dbAssetsBack, o -> o.setCreateTime(null)));
       // 准备参数
       ErpAssetsBackPageReqVO reqVO = new ErpAssetsBackPageReqVO();
       reqVO.setName(null);
       reqVO.setCode(null);
       reqVO.setStatus(null);
       reqVO.setSn(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<ErpAssetsBackDO> pageResult = assetsBackService.getAssetsBackPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbAssetsBack, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAssetsBackList() {
       // mock 数据
       ErpAssetsBackDO dbAssetsBack = randomPojo(ErpAssetsBackDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setCode(null);
           o.setStatus(null);
           o.setSn(null);
           o.setCreateTime(null);
       });
       assetsBackMapper.insert(dbAssetsBack);
       // 测试 name 不匹配
       assetsBackMapper.insert(cloneIgnoreId(dbAssetsBack, o -> o.setName(null)));
       // 测试 code 不匹配
       assetsBackMapper.insert(cloneIgnoreId(dbAssetsBack, o -> o.setCode(null)));
       // 测试 status 不匹配
       assetsBackMapper.insert(cloneIgnoreId(dbAssetsBack, o -> o.setStatus(null)));
       // 测试 sn 不匹配
       assetsBackMapper.insert(cloneIgnoreId(dbAssetsBack, o -> o.setSn(null)));
       // 测试 createTime 不匹配
       assetsBackMapper.insert(cloneIgnoreId(dbAssetsBack, o -> o.setCreateTime(null)));
       // 准备参数
       ErpAssetsBackExportReqVO reqVO = new ErpAssetsBackExportReqVO();
       reqVO.setName(null);
       reqVO.setCode(null);
       reqVO.setStatus(null);
       reqVO.setSn(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<ErpAssetsBackDO> list = assetsBackService.getAssetsBackList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbAssetsBack, list.get(0));
    }

}
