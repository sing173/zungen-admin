package com.zungen.wb.module.erp.service.assets;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import com.zungen.wb.framework.test.core.ut.BaseDbUnitTest;

import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsIdReaderDO;
import com.zungen.wb.module.erp.dal.mysql.assets.ErpAssetsIdReaderMapper;
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
* {@link ErpAssetsIdReaderServiceImpl} 的单元测试类
*
* @author admin
*/
@Import(ErpAssetsIdReaderServiceImpl.class)
public class ErpAssetsIdReaderServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ErpAssetsIdReaderServiceImpl assetsIdReaderService;

    @Resource
    private ErpAssetsIdReaderMapper assetsIdReaderMapper;

    @Test
    public void testCreateAssetsIdReader_success() {
        // 准备参数
        ErpAssetsIdReaderCreateReqVO reqVO = randomPojo(ErpAssetsIdReaderCreateReqVO.class);

        // 调用
        Long assetsIdReaderId = assetsIdReaderService.createAssetsIdReader(reqVO);
        // 断言
        assertNotNull(assetsIdReaderId);
        // 校验记录的属性是否正确
        ErpAssetsIdReaderDO assetsIdReader = assetsIdReaderMapper.selectById(assetsIdReaderId);
        assertPojoEquals(reqVO, assetsIdReader);
    }

    @Test
    public void testUpdateAssetsIdReader_success() {
        // mock 数据
        ErpAssetsIdReaderDO dbAssetsIdReader = randomPojo(ErpAssetsIdReaderDO.class);
        assetsIdReaderMapper.insert(dbAssetsIdReader);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ErpAssetsIdReaderUpdateReqVO reqVO = randomPojo(ErpAssetsIdReaderUpdateReqVO.class, o -> {
            o.setId(dbAssetsIdReader.getId()); // 设置更新的 ID
        });

        // 调用
        assetsIdReaderService.updateAssetsIdReader(reqVO);
        // 校验是否更新正确
        ErpAssetsIdReaderDO assetsIdReader = assetsIdReaderMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, assetsIdReader);
    }

    @Test
    public void testUpdateAssetsIdReader_notExists() {
        // 准备参数
        ErpAssetsIdReaderUpdateReqVO reqVO = randomPojo(ErpAssetsIdReaderUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> assetsIdReaderService.updateAssetsIdReader(reqVO), ASSETS_ID_READER_NOT_EXISTS);
    }

    @Test
    public void testDeleteAssetsIdReader_success() {
        // mock 数据
        ErpAssetsIdReaderDO dbAssetsIdReader = randomPojo(ErpAssetsIdReaderDO.class);
        assetsIdReaderMapper.insert(dbAssetsIdReader);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbAssetsIdReader.getId();

        // 调用
        assetsIdReaderService.deleteAssetsIdReader(id);
       // 校验数据不存在了
       assertNull(assetsIdReaderMapper.selectById(id));
    }

    @Test
    public void testDeleteAssetsIdReader_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> assetsIdReaderService.deleteAssetsIdReader(id), ASSETS_ID_READER_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAssetsIdReaderPage() {
       // mock 数据
       ErpAssetsIdReaderDO dbAssetsIdReader = randomPojo(ErpAssetsIdReaderDO.class, o -> { // 等会查询到
           o.setPadId(null);
           o.setName(null);
           o.setCode(null);
           o.setSn(null);
           o.setStatus(null);
           o.setRemark(null);
           o.setCreateTime(null);
       });
       assetsIdReaderMapper.insert(dbAssetsIdReader);
       // 测试 padId 不匹配
       assetsIdReaderMapper.insert(cloneIgnoreId(dbAssetsIdReader, o -> o.setPadId(null)));
       // 测试 name 不匹配
       assetsIdReaderMapper.insert(cloneIgnoreId(dbAssetsIdReader, o -> o.setName(null)));
       // 测试 code 不匹配
       assetsIdReaderMapper.insert(cloneIgnoreId(dbAssetsIdReader, o -> o.setCode(null)));
       // 测试 sn 不匹配
       assetsIdReaderMapper.insert(cloneIgnoreId(dbAssetsIdReader, o -> o.setSn(null)));
       // 测试 status 不匹配
       assetsIdReaderMapper.insert(cloneIgnoreId(dbAssetsIdReader, o -> o.setStatus(null)));
       // 测试 remark 不匹配
       assetsIdReaderMapper.insert(cloneIgnoreId(dbAssetsIdReader, o -> o.setRemark(null)));
       // 测试 createTime 不匹配
       assetsIdReaderMapper.insert(cloneIgnoreId(dbAssetsIdReader, o -> o.setCreateTime(null)));
       // 准备参数
       ErpAssetsIdReaderPageReqVO reqVO = new ErpAssetsIdReaderPageReqVO();
       reqVO.setPadId(null);
       reqVO.setName(null);
       reqVO.setCode(null);
       reqVO.setSn(null);
       reqVO.setStatus(null);
       reqVO.setRemark(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<ErpAssetsIdReaderDO> pageResult = assetsIdReaderService.getAssetsIdReaderPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbAssetsIdReader, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAssetsIdReaderList() {
       // mock 数据
       ErpAssetsIdReaderDO dbAssetsIdReader = randomPojo(ErpAssetsIdReaderDO.class, o -> { // 等会查询到
           o.setPadId(null);
           o.setName(null);
           o.setCode(null);
           o.setSn(null);
           o.setStatus(null);
           o.setRemark(null);
           o.setCreateTime(null);
       });
       assetsIdReaderMapper.insert(dbAssetsIdReader);
       // 测试 padId 不匹配
       assetsIdReaderMapper.insert(cloneIgnoreId(dbAssetsIdReader, o -> o.setPadId(null)));
       // 测试 name 不匹配
       assetsIdReaderMapper.insert(cloneIgnoreId(dbAssetsIdReader, o -> o.setName(null)));
       // 测试 code 不匹配
       assetsIdReaderMapper.insert(cloneIgnoreId(dbAssetsIdReader, o -> o.setCode(null)));
       // 测试 sn 不匹配
       assetsIdReaderMapper.insert(cloneIgnoreId(dbAssetsIdReader, o -> o.setSn(null)));
       // 测试 status 不匹配
       assetsIdReaderMapper.insert(cloneIgnoreId(dbAssetsIdReader, o -> o.setStatus(null)));
       // 测试 remark 不匹配
       assetsIdReaderMapper.insert(cloneIgnoreId(dbAssetsIdReader, o -> o.setRemark(null)));
       // 测试 createTime 不匹配
       assetsIdReaderMapper.insert(cloneIgnoreId(dbAssetsIdReader, o -> o.setCreateTime(null)));
       // 准备参数
       ErpAssetsIdReaderExportReqVO reqVO = new ErpAssetsIdReaderExportReqVO();
       reqVO.setPadId(null);
       reqVO.setName(null);
       reqVO.setCode(null);
       reqVO.setSn(null);
       reqVO.setStatus(null);
       reqVO.setRemark(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<ErpAssetsIdReaderDO> list = assetsIdReaderService.getAssetsIdReaderList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbAssetsIdReader, list.get(0));
    }

}
