package com.zungen.wb.module.bpm.service.loan;

import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.framework.test.core.ut.BaseDbUnitTest;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.identity.BpmLoanIdentityCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.identity.BpmLoanIdentityPageReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.identity.BpmLoanIdentityUpdateReqVO;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanIdentityDO;
import com.zungen.wb.module.bpm.dal.mysql.loan.BpmLoanIdentityMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.Date;

import static com.zungen.wb.framework.common.util.object.ObjectUtils.cloneIgnoreId;
import static com.zungen.wb.framework.test.core.util.AssertUtils.assertPojoEquals;
import static com.zungen.wb.framework.test.core.util.AssertUtils.assertServiceException;
import static com.zungen.wb.framework.test.core.util.RandomUtils.randomLongId;
import static com.zungen.wb.framework.test.core.util.RandomUtils.randomPojo;
import static com.zungen.wb.module.bpm.enums.ErrorCodeConstants.LOAN_IDENTITY_NOT_EXISTS;
import static org.junit.jupiter.api.Assertions.*;

/**
 * {@link BpmLoanIdentityServiceImpl} 的单元测试类
 *
 * @author minson
 */
@Import(BpmLoanIdentityServiceImpl.class)
public class BpmLoanIdentityServiceImplTest extends BaseDbUnitTest {

    @Resource
    private BpmLoanIdentityServiceImpl loanIdentityService;

    @Resource
    private BpmLoanIdentityMapper loanIdentityMapper;

    @Test
    public void testCreateLoanIdentity_success() {
        // 准备参数
        BpmLoanIdentityCreateReqVO reqVO = randomPojo(BpmLoanIdentityCreateReqVO.class);

        // 调用
        Long loanIdentityId = loanIdentityService.createLoanIdentity(reqVO);
        // 断言
        assertNotNull(loanIdentityId);
        // 校验记录的属性是否正确
        BpmLoanIdentityDO loanIdentity = loanIdentityMapper.selectById(loanIdentityId);
        assertPojoEquals(reqVO, loanIdentity);
    }

    @Test
    public void testUpdateLoanIdentity_success() {
        // mock 数据
        BpmLoanIdentityDO dbLoanIdentity = randomPojo(BpmLoanIdentityDO.class);
        loanIdentityMapper.insert(dbLoanIdentity);// @Sql: 先插入出一条存在的数据
        // 准备参数
        BpmLoanIdentityUpdateReqVO reqVO = randomPojo(BpmLoanIdentityUpdateReqVO.class, o -> {
            o.setId(dbLoanIdentity.getId()); // 设置更新的 ID
        });

        // 调用
        loanIdentityService.updateLoanIdentity(reqVO);
        // 校验是否更新正确
        BpmLoanIdentityDO loanIdentity = loanIdentityMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, loanIdentity);
    }

    @Test
    public void testUpdateLoanIdentity_notExists() {
        // 准备参数
        BpmLoanIdentityUpdateReqVO reqVO = randomPojo(BpmLoanIdentityUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> loanIdentityService.updateLoanIdentity(reqVO), LOAN_IDENTITY_NOT_EXISTS);
    }

    @Test
    public void testDeleteLoanIdentity_success() {
        // mock 数据
        BpmLoanIdentityDO dbLoanIdentity = randomPojo(BpmLoanIdentityDO.class);
        loanIdentityMapper.insert(dbLoanIdentity);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbLoanIdentity.getId();

        // 调用
        loanIdentityService.deleteLoanIdentity(id);
        // 校验数据不存在了
        assertNull(loanIdentityMapper.selectById(id));
    }

    @Test
    public void testDeleteLoanIdentity_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> loanIdentityService.deleteLoanIdentity(id), LOAN_IDENTITY_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetLoanIdentityPage() {
        // mock 数据
        BpmLoanIdentityDO dbLoanIdentity = randomPojo(BpmLoanIdentityDO.class, o -> { // 等会查询到
            o.setName(null);
            o.setMobile(null);
            o.setIdentityCardNumber(null);
            o.setFaceStatus(null);
            o.setAuthStatus(null);
            o.setStatus(null);
            o.setCreateTime(null);
        });
        loanIdentityMapper.insert(dbLoanIdentity);
        // 测试 name 不匹配
        loanIdentityMapper.insert(cloneIgnoreId(dbLoanIdentity, o -> o.setName(null)));
        // 测试 mobile 不匹配
        loanIdentityMapper.insert(cloneIgnoreId(dbLoanIdentity, o -> o.setMobile(null)));
        // 测试 identityCardNumber 不匹配
        loanIdentityMapper.insert(cloneIgnoreId(dbLoanIdentity, o -> o.setIdentityCardNumber(null)));
        // 测试 faceStatus 不匹配
        loanIdentityMapper.insert(cloneIgnoreId(dbLoanIdentity, o -> o.setFaceStatus(null)));
        // 测试 authStatus 不匹配
        loanIdentityMapper.insert(cloneIgnoreId(dbLoanIdentity, o -> o.setAuthStatus(null)));
        // 测试 status 不匹配
        loanIdentityMapper.insert(cloneIgnoreId(dbLoanIdentity, o -> o.setStatus(null)));
        // 测试 createTime 不匹配
        loanIdentityMapper.insert(cloneIgnoreId(dbLoanIdentity, o -> o.setCreateTime(null)));
        // 准备参数
        BpmLoanIdentityPageReqVO reqVO = new BpmLoanIdentityPageReqVO();
        reqVO.setName(null);
        reqVO.setMobile(null);
        reqVO.setIdentityCardNumber(null);
        reqVO.setFaceStatus(null);
        reqVO.setAuthStatus(null);
        reqVO.setStatus(null);
        reqVO.setCreateTime((new Date[]{}));

        // 调用
        PageResult<BpmLoanIdentityDO> pageResult = loanIdentityService.getLoanIdentityPage(reqVO);
        // 断言
        assertEquals(1, pageResult.getTotal());
        assertEquals(1, pageResult.getList().size());
        assertPojoEquals(dbLoanIdentity, pageResult.getList().get(0));
    }
}
