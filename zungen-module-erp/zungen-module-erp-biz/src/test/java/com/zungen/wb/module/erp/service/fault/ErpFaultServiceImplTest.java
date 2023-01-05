package com.zungen.wb.module.erp.service.fault;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import com.zungen.wb.framework.test.core.ut.BaseDbUnitTest;

import com.zungen.wb.module.erp.controller.admin.fault.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.fault.ErpFaultDO;
import com.zungen.wb.module.erp.dal.mysql.fault.ErpFaultMapper;
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
* {@link ErpFaultServiceImpl} 的单元测试类
*
* @author admin
*/
@Import(ErpFaultServiceImpl.class)
public class ErpFaultServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ErpFaultServiceImpl faultService;

    @Resource
    private ErpFaultMapper faultMapper;

    @Test
    public void testCreateFault_success() {
        // 准备参数
        ErpFaultCreateReqVO reqVO = randomPojo(ErpFaultCreateReqVO.class);

        // 调用
        Long faultId = faultService.createFault(reqVO);
        // 断言
        assertNotNull(faultId);
        // 校验记录的属性是否正确
        ErpFaultDO fault = faultMapper.selectById(faultId);
        assertPojoEquals(reqVO, fault);
    }

    @Test
    public void testUpdateFault_success() {
        // mock 数据
        ErpFaultDO dbFault = randomPojo(ErpFaultDO.class);
        faultMapper.insert(dbFault);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ErpFaultUpdateReqVO reqVO = randomPojo(ErpFaultUpdateReqVO.class, o -> {
            o.setId(dbFault.getId()); // 设置更新的 ID
        });

        // 调用
        faultService.updateFault(reqVO);
        // 校验是否更新正确
        ErpFaultDO fault = faultMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, fault);
    }

    @Test
    public void testUpdateFault_notExists() {
        // 准备参数
        ErpFaultUpdateReqVO reqVO = randomPojo(ErpFaultUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> faultService.updateFault(reqVO), FAULT_NOT_EXISTS);
    }

    @Test
    public void testDeleteFault_success() {
        // mock 数据
        ErpFaultDO dbFault = randomPojo(ErpFaultDO.class);
        faultMapper.insert(dbFault);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbFault.getId();

        // 调用
        faultService.deleteFault(id);
       // 校验数据不存在了
       assertNull(faultMapper.selectById(id));
    }

    @Test
    public void testDeleteFault_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> faultService.deleteFault(id), FAULT_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetFaultPage() {
       // mock 数据
       ErpFaultDO dbFault = randomPojo(ErpFaultDO.class, o -> { // 等会查询到
           o.setCode(null);
           o.setAssetCode(null);
           o.setAssetType(null);
           o.setFaultType(null);
           o.setCreateTime(null);
       });
       faultMapper.insert(dbFault);
       // 测试 code 不匹配
       faultMapper.insert(cloneIgnoreId(dbFault, o -> o.setCode(null)));
       // 测试 assetCode 不匹配
       faultMapper.insert(cloneIgnoreId(dbFault, o -> o.setAssetCode(null)));
       // 测试 assetType 不匹配
       faultMapper.insert(cloneIgnoreId(dbFault, o -> o.setAssetType(null)));
       // 测试 faultType 不匹配
       faultMapper.insert(cloneIgnoreId(dbFault, o -> o.setFaultType(null)));
       // 测试 createTime 不匹配
       faultMapper.insert(cloneIgnoreId(dbFault, o -> o.setCreateTime(null)));
       // 准备参数
       ErpFaultPageReqVO reqVO = new ErpFaultPageReqVO();
       reqVO.setCode(null);
       reqVO.setAssetCode(null);
       reqVO.setAssetType(null);
       reqVO.setFaultType(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<ErpFaultDO> pageResult = faultService.getFaultPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbFault, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetFaultList() {
       // mock 数据
       ErpFaultDO dbFault = randomPojo(ErpFaultDO.class, o -> { // 等会查询到
           o.setCode(null);
           o.setAssetCode(null);
           o.setAssetType(null);
           o.setFaultType(null);
           o.setCreateTime(null);
       });
       faultMapper.insert(dbFault);
       // 测试 code 不匹配
       faultMapper.insert(cloneIgnoreId(dbFault, o -> o.setCode(null)));
       // 测试 assetCode 不匹配
       faultMapper.insert(cloneIgnoreId(dbFault, o -> o.setAssetCode(null)));
       // 测试 assetType 不匹配
       faultMapper.insert(cloneIgnoreId(dbFault, o -> o.setAssetType(null)));
       // 测试 faultType 不匹配
       faultMapper.insert(cloneIgnoreId(dbFault, o -> o.setFaultType(null)));
       // 测试 createTime 不匹配
       faultMapper.insert(cloneIgnoreId(dbFault, o -> o.setCreateTime(null)));
       // 准备参数
       ErpFaultExportReqVO reqVO = new ErpFaultExportReqVO();
       reqVO.setCode(null);
       reqVO.setAssetCode(null);
       reqVO.setAssetType(null);
       reqVO.setFaultType(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<ErpFaultDO> list = faultService.getFaultList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbFault, list.get(0));
    }

}
