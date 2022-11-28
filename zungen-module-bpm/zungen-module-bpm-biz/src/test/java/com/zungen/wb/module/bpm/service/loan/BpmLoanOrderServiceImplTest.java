package com.zungen.wb.module.bpm.service.loan;

import com.zungen.wb.module.bpm.controller.admin.loan.vo.order.BpmLoanOrderCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.order.BpmLoanOrderPageReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.order.BpmLoanOrderUpdateReqVO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import com.zungen.wb.framework.test.core.ut.BaseDbUnitTest;

import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanOrderDO;
import com.zungen.wb.module.bpm.dal.mysql.loan.BpmLoanOrderMapper;
import com.zungen.wb.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;
import java.util.*;

import static com.zungen.wb.module.bpm.enums.ErrorCodeConstants.*;
import static com.zungen.wb.framework.test.core.util.AssertUtils.*;
import static com.zungen.wb.framework.test.core.util.RandomUtils.*;
import static com.zungen.wb.framework.common.util.object.ObjectUtils.*;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link BpmLoanOrderServiceImpl} 的单元测试类
*
* @author minson
*/
@Import(BpmLoanOrderServiceImpl.class)
public class BpmLoanOrderServiceImplTest extends BaseDbUnitTest {

    @Resource
    private BpmLoanOrderServiceImpl loanOrderService;

    @Resource
    private BpmLoanOrderMapper loanOrderMapper;

    @Test
    public void testCreateLoanOrder_success() {
        // 准备参数
        BpmLoanOrderCreateReqVO reqVO = randomPojo(BpmLoanOrderCreateReqVO.class);

        // 调用
        Long loanOrderId = loanOrderService.createLoanOrder(11L, reqVO);
        // 断言
        assertNotNull(loanOrderId);
        // 校验记录的属性是否正确
        BpmLoanOrderDO loanOrder = loanOrderMapper.selectById(loanOrderId);
        assertPojoEquals(reqVO, loanOrder);
    }

    @Test
    public void testUpdateLoanOrder_success() {
        // mock 数据
        BpmLoanOrderDO dbLoanOrder = randomPojo(BpmLoanOrderDO.class);
        loanOrderMapper.insert(dbLoanOrder);// @Sql: 先插入出一条存在的数据
        // 准备参数
        BpmLoanOrderUpdateReqVO reqVO = randomPojo(BpmLoanOrderUpdateReqVO.class, o -> {
            o.setId(dbLoanOrder.getId()); // 设置更新的 ID
        });

        // 调用
        loanOrderService.updateLoanOrder(reqVO);
        // 校验是否更新正确
        BpmLoanOrderDO loanOrder = loanOrderMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, loanOrder);
    }

    @Test
    public void testUpdateLoanOrder_notExists() {
        // 准备参数
        BpmLoanOrderUpdateReqVO reqVO = randomPojo(BpmLoanOrderUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> loanOrderService.updateLoanOrder(reqVO), LOAN_ORDER_NOT_EXISTS);
    }

    @Test
    public void testDeleteLoanOrder_success() {
        // mock 数据
        BpmLoanOrderDO dbLoanOrder = randomPojo(BpmLoanOrderDO.class);
        loanOrderMapper.insert(dbLoanOrder);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbLoanOrder.getId();

        // 调用
        loanOrderService.deleteLoanOrder(id);
       // 校验数据不存在了
       assertNull(loanOrderMapper.selectById(id));
    }

    @Test
    public void testDeleteLoanOrder_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> loanOrderService.deleteLoanOrder(id), LOAN_ORDER_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetLoanOrderPage() {
       // mock 数据
       BpmLoanOrderDO dbLoanOrder = randomPojo(BpmLoanOrderDO.class, o -> { // 等会查询到
           o.setRepaymentPeriods(null);
           o.setRepaymentType(null);
           o.setAuditTime(null);
           o.setAuditRemark(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       loanOrderMapper.insert(dbLoanOrder);
       // 测试 repaymentPeriods 不匹配
       loanOrderMapper.insert(cloneIgnoreId(dbLoanOrder, o -> o.setRepaymentPeriods(null)));
       // 测试 repaymentType 不匹配
       loanOrderMapper.insert(cloneIgnoreId(dbLoanOrder, o -> o.setRepaymentType(null)));
       // 测试 auditTime 不匹配
       loanOrderMapper.insert(cloneIgnoreId(dbLoanOrder, o -> o.setAuditTime(null)));
       // 测试 auditRemark 不匹配
       loanOrderMapper.insert(cloneIgnoreId(dbLoanOrder, o -> o.setAuditRemark(null)));
       // 测试 status 不匹配
       loanOrderMapper.insert(cloneIgnoreId(dbLoanOrder, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       loanOrderMapper.insert(cloneIgnoreId(dbLoanOrder, o -> o.setCreateTime(null)));
       // 准备参数
       BpmLoanOrderPageReqVO reqVO = new BpmLoanOrderPageReqVO();
       reqVO.setRepaymentPeriods(null);
       reqVO.setRepaymentType(null);
       reqVO.setAuditTime((new Date[]{}));
       reqVO.setAuditRemark(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<BpmLoanOrderDO> pageResult = loanOrderService.getLoanOrderPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbLoanOrder, pageResult.getList().get(0));
    }

}
