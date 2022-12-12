package com.zungen.wb.module.erp.service.assets;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import com.zungen.wb.framework.test.core.ut.BaseDbUnitTest;

import com.zungen.wb.module.erp.controller.admin.assets.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.assets.ErpAssetsPadDO;
import com.zungen.wb.module.erp.dal.mysql.assets.ErpAssetsPadMapper;
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
* {@link ErpAssetsPadServiceImpl} 的单元测试类
*
* @author admin
*/
@Import(ErpAssetsPadServiceImpl.class)
public class ErpAssetsPadServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ErpAssetsPadServiceImpl assetsPadService;

    @Resource
    private ErpAssetsPadMapper assetsPadMapper;

    @Test
    public void testCreateAssetsPad_success() {
        // 准备参数
        ErpAssetsPadCreateReqVO reqVO = randomPojo(ErpAssetsPadCreateReqVO.class);

        // 调用
        Long assetsPadId = assetsPadService.createAssetsPad(reqVO);
        // 断言
        assertNotNull(assetsPadId);
        // 校验记录的属性是否正确
        ErpAssetsPadDO assetsPad = assetsPadMapper.selectById(assetsPadId);
        assertPojoEquals(reqVO, assetsPad);
    }

    @Test
    public void testUpdateAssetsPad_success() {
        // mock 数据
        ErpAssetsPadDO dbAssetsPad = randomPojo(ErpAssetsPadDO.class);
        assetsPadMapper.insert(dbAssetsPad);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ErpAssetsPadUpdateReqVO reqVO = randomPojo(ErpAssetsPadUpdateReqVO.class, o -> {
            o.setId(dbAssetsPad.getId()); // 设置更新的 ID
        });

        // 调用
        assetsPadService.updateAssetsPad(reqVO);
        // 校验是否更新正确
        ErpAssetsPadDO assetsPad = assetsPadMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, assetsPad);
    }

    @Test
    public void testUpdateAssetsPad_notExists() {
        // 准备参数
        ErpAssetsPadUpdateReqVO reqVO = randomPojo(ErpAssetsPadUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> assetsPadService.updateAssetsPad(reqVO), ASSETS_PAD_NOT_EXISTS);
    }

    @Test
    public void testDeleteAssetsPad_success() {
        // mock 数据
        ErpAssetsPadDO dbAssetsPad = randomPojo(ErpAssetsPadDO.class);
        assetsPadMapper.insert(dbAssetsPad);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbAssetsPad.getId();

        // 调用
        assetsPadService.deleteAssetsPad(id);
       // 校验数据不存在了
       assertNull(assetsPadMapper.selectById(id));
    }

    @Test
    public void testDeleteAssetsPad_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> assetsPadService.deleteAssetsPad(id), ASSETS_PAD_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAssetsPadPage() {
       // mock 数据
       ErpAssetsPadDO dbAssetsPad = randomPojo(ErpAssetsPadDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setCode(null);
           o.setStatus(null);
           o.setMeid(null);
           o.setSn(null);
           o.setModelNo(null);
           o.setBatchNo(null);
           o.setRom(null);
           o.setSpecs(null);
           o.setBlueMac(null);
           o.setMac(null);
           o.setUseDept(null);
           o.setRemark(null);
           o.setCreateTime(null);
       });
       assetsPadMapper.insert(dbAssetsPad);
       // 测试 name 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setName(null)));
       // 测试 code 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setCode(null)));
       // 测试 status 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setStatus(null)));
       // 测试 meid 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setMeid(null)));
       // 测试 sn 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setSn(null)));
       // 测试 modelNo 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setModelNo(null)));
       // 测试 batchNo 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setBatchNo(null)));
       // 测试 rom 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setRom(null)));
       // 测试 specs 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setSpecs(null)));
       // 测试 blueMac 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setBlueMac(null)));
       // 测试 mac 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setMac(null)));
       // 测试 useDept 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setUseDept(null)));
       // 测试 remark 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setRemark(null)));
       // 测试 createTime 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setCreateTime(null)));
       // 准备参数
       ErpAssetsPadPageReqVO reqVO = new ErpAssetsPadPageReqVO();
       reqVO.setName(null);
       reqVO.setCode(null);
       reqVO.setStatus(null);
       reqVO.setMeid(null);
       reqVO.setSn(null);
       reqVO.setModelNo(null);
       reqVO.setBatchNo(null);
       reqVO.setRom(null);
       reqVO.setSpecs(null);
       reqVO.setBlueMac(null);
       reqVO.setMac(null);
       reqVO.setUseDept(null);
       reqVO.setRemark(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<ErpAssetsPadDO> pageResult = assetsPadService.getAssetsPadPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbAssetsPad, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAssetsPadList() {
       // mock 数据
       ErpAssetsPadDO dbAssetsPad = randomPojo(ErpAssetsPadDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setCode(null);
           o.setStatus(null);
           o.setMeid(null);
           o.setSn(null);
           o.setModelNo(null);
           o.setBatchNo(null);
           o.setRom(null);
           o.setSpecs(null);
           o.setBlueMac(null);
           o.setMac(null);
           o.setUseDept(null);
           o.setRemark(null);
           o.setCreateTime(null);
       });
       assetsPadMapper.insert(dbAssetsPad);
       // 测试 name 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setName(null)));
       // 测试 code 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setCode(null)));
       // 测试 status 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setStatus(null)));
       // 测试 meid 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setMeid(null)));
       // 测试 sn 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setSn(null)));
       // 测试 modelNo 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setModelNo(null)));
       // 测试 batchNo 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setBatchNo(null)));
       // 测试 rom 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setRom(null)));
       // 测试 specs 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setSpecs(null)));
       // 测试 blueMac 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setBlueMac(null)));
       // 测试 mac 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setMac(null)));
       // 测试 useDept 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setUseDept(null)));
       // 测试 remark 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setRemark(null)));
       // 测试 createTime 不匹配
       assetsPadMapper.insert(cloneIgnoreId(dbAssetsPad, o -> o.setCreateTime(null)));
       // 准备参数
       ErpAssetsPadExportReqVO reqVO = new ErpAssetsPadExportReqVO();
       reqVO.setName(null);
       reqVO.setCode(null);
       reqVO.setStatus(null);
       reqVO.setMeid(null);
       reqVO.setSn(null);
       reqVO.setModelNo(null);
       reqVO.setBatchNo(null);
       reqVO.setRom(null);
       reqVO.setSpecs(null);
       reqVO.setBlueMac(null);
       reqVO.setMac(null);
       reqVO.setUseDept(null);
       reqVO.setRemark(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<ErpAssetsPadDO> list = assetsPadService.getAssetsPadList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbAssetsPad, list.get(0));
    }

}
