package com.zungen.wb.module.bpm.service.loan;

import com.zungen.wb.module.bpm.controller.admin.loan.vo.guarantee.BpmLoanGuaranteeCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.guarantee.BpmLoanGuaranteePageReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.guarantee.BpmLoanGuaranteeUpdateReqVO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import com.zungen.wb.framework.test.core.ut.BaseDbUnitTest;

import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanGuaranteeDO;
import com.zungen.wb.module.bpm.dal.mysql.loan.BpmLoanGuaranteeMapper;
import com.zungen.wb.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;
import java.util.*;

import static com.zungen.wb.module.bpm.enums.ErrorCodeConstants.*;
import static com.zungen.wb.framework.test.core.util.AssertUtils.*;
import static com.zungen.wb.framework.test.core.util.RandomUtils.*;
import static com.zungen.wb.framework.common.util.object.ObjectUtils.*;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link BpmLoanGuaranteeServiceImpl} 的单元测试类
*
* @author minson
*/
@Import(BpmLoanGuaranteeServiceImpl.class)
public class BpmLoanGuaranteeServiceImplTest extends BaseDbUnitTest {

    @Resource
    private BpmLoanGuaranteeServiceImpl loanGuaranteeService;

    @Resource
    private BpmLoanGuaranteeMapper loanGuaranteeMapper;

    @Test
    public void testCreateLoanGuarantee_success() {
        // 准备参数
        BpmLoanGuaranteeCreateReqVO reqVO = randomPojo(BpmLoanGuaranteeCreateReqVO.class);

        // 调用
        Long loanGuaranteeId = loanGuaranteeService.createLoanGuarantee(reqVO);
        // 断言
        assertNotNull(loanGuaranteeId);
        // 校验记录的属性是否正确
        BpmLoanGuaranteeDO loanGuarantee = loanGuaranteeMapper.selectById(loanGuaranteeId);
        assertPojoEquals(reqVO, loanGuarantee);
    }

    @Test
    public void testUpdateLoanGuarantee_success() {
        // mock 数据
        BpmLoanGuaranteeDO dbLoanGuarantee = randomPojo(BpmLoanGuaranteeDO.class);
        loanGuaranteeMapper.insert(dbLoanGuarantee);// @Sql: 先插入出一条存在的数据
        // 准备参数
        BpmLoanGuaranteeUpdateReqVO reqVO = randomPojo(BpmLoanGuaranteeUpdateReqVO.class, o -> {
            o.setId(dbLoanGuarantee.getId()); // 设置更新的 ID
        });

        // 调用
        loanGuaranteeService.updateLoanGuarantee(reqVO);
        // 校验是否更新正确
        BpmLoanGuaranteeDO loanGuarantee = loanGuaranteeMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, loanGuarantee);
    }

    @Test
    public void testUpdateLoanGuarantee_notExists() {
        // 准备参数
        BpmLoanGuaranteeUpdateReqVO reqVO = randomPojo(BpmLoanGuaranteeUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> loanGuaranteeService.updateLoanGuarantee(reqVO), LOAN_GUARANTEE_NOT_EXISTS);
    }

    @Test
    public void testDeleteLoanGuarantee_success() {
        // mock 数据
        BpmLoanGuaranteeDO dbLoanGuarantee = randomPojo(BpmLoanGuaranteeDO.class);
        loanGuaranteeMapper.insert(dbLoanGuarantee);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbLoanGuarantee.getId();

        // 调用
        loanGuaranteeService.deleteLoanGuarantee(id);
       // 校验数据不存在了
       assertNull(loanGuaranteeMapper.selectById(id));
    }

    @Test
    public void testDeleteLoanGuarantee_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> loanGuaranteeService.deleteLoanGuarantee(id), LOAN_GUARANTEE_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetLoanGuaranteePage() {
       // mock 数据
       BpmLoanGuaranteeDO dbLoanGuarantee = randomPojo(BpmLoanGuaranteeDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setMobile(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       loanGuaranteeMapper.insert(dbLoanGuarantee);
       // 测试 name 不匹配
       loanGuaranteeMapper.insert(cloneIgnoreId(dbLoanGuarantee, o -> o.setName(null)));
       // 测试 mobile 不匹配
       loanGuaranteeMapper.insert(cloneIgnoreId(dbLoanGuarantee, o -> o.setMobile(null)));
       // 测试 status 不匹配
       loanGuaranteeMapper.insert(cloneIgnoreId(dbLoanGuarantee, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       loanGuaranteeMapper.insert(cloneIgnoreId(dbLoanGuarantee, o -> o.setCreateTime(null)));
       // 准备参数
       BpmLoanGuaranteePageReqVO reqVO = new BpmLoanGuaranteePageReqVO();
       reqVO.setName(null);
       reqVO.setMobile(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<BpmLoanGuaranteeDO> pageResult = loanGuaranteeService.getLoanGuaranteePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbLoanGuarantee, pageResult.getList().get(0));
    }
}
