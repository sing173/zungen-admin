package com.zungen.wb.module.bpm.service.loan;

import com.zungen.wb.module.bpm.controller.admin.loan.vo.product.BpmLoanProductCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.product.BpmLoanProductPageReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.product.BpmLoanProductUpdateReqVO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import com.zungen.wb.framework.test.core.ut.BaseDbUnitTest;

import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanProductDO;
import com.zungen.wb.module.bpm.dal.mysql.loan.BpmLoanProductMapper;
import com.zungen.wb.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;
import java.util.*;

import static com.zungen.wb.framework.test.core.util.AssertUtils.*;
import static com.zungen.wb.framework.test.core.util.RandomUtils.*;
import static com.zungen.wb.framework.common.util.object.ObjectUtils.*;
import static com.zungen.wb.module.bpm.enums.ErrorCodeConstants.LOAN_PRODUCT_NOT_EXISTS;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link BpmLoanProductServiceImpl} 的单元测试类
*
* @author minson
*/
@Import(BpmLoanProductServiceImpl.class)
public class BpmLoanProductServiceImplTest extends BaseDbUnitTest {

    @Resource
    private BpmLoanProductServiceImpl loanProductService;

    @Resource
    private BpmLoanProductMapper loanProductMapper;

    @Test
    public void testCreateLoanProduct_success() {
        // 准备参数
        BpmLoanProductCreateReqVO reqVO = randomPojo(BpmLoanProductCreateReqVO.class);

        // 调用
        Long loanProductId = loanProductService.createLoanProduct(reqVO);
        // 断言
        assertNotNull(loanProductId);
        // 校验记录的属性是否正确
        BpmLoanProductDO loanProduct = loanProductMapper.selectById(loanProductId);
        assertPojoEquals(reqVO, loanProduct);
    }

    @Test
    public void testUpdateLoanProduct_success() {
        // mock 数据
        BpmLoanProductDO dbLoanProduct = randomPojo(BpmLoanProductDO.class);
        loanProductMapper.insert(dbLoanProduct);// @Sql: 先插入出一条存在的数据
        // 准备参数
        BpmLoanProductUpdateReqVO reqVO = randomPojo(BpmLoanProductUpdateReqVO.class, o -> {
            o.setId(dbLoanProduct.getId()); // 设置更新的 ID
        });

        // 调用
        loanProductService.updateLoanProduct(reqVO);
        // 校验是否更新正确
        BpmLoanProductDO loanProduct = loanProductMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, loanProduct);
    }

    @Test
    public void testUpdateLoanProduct_notExists() {
        // 准备参数
        BpmLoanProductUpdateReqVO reqVO = randomPojo(BpmLoanProductUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> loanProductService.updateLoanProduct(reqVO), LOAN_PRODUCT_NOT_EXISTS);
    }

    @Test
    public void testDeleteLoanProduct_success() {
        // mock 数据
        BpmLoanProductDO dbLoanProduct = randomPojo(BpmLoanProductDO.class);
        loanProductMapper.insert(dbLoanProduct);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbLoanProduct.getId();

        // 调用
        loanProductService.deleteLoanProduct(id);
       // 校验数据不存在了
       assertNull(loanProductMapper.selectById(id));
    }

    @Test
    public void testDeleteLoanProduct_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> loanProductService.deleteLoanProduct(id), LOAN_PRODUCT_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetLoanProductPage() {
       // mock 数据
       BpmLoanProductDO dbLoanProduct = randomPojo(BpmLoanProductDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setNo(null);
           o.setRates(null);
           o.setAmount(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       loanProductMapper.insert(dbLoanProduct);
       // 测试 name 不匹配
       loanProductMapper.insert(cloneIgnoreId(dbLoanProduct, o -> o.setName(null)));
       // 测试 no 不匹配
       loanProductMapper.insert(cloneIgnoreId(dbLoanProduct, o -> o.setNo(null)));
       // 测试 rates 不匹配
       loanProductMapper.insert(cloneIgnoreId(dbLoanProduct, o -> o.setRates(null)));
       // 测试 amount 不匹配
       loanProductMapper.insert(cloneIgnoreId(dbLoanProduct, o -> o.setAmount(null)));
       // 测试 status 不匹配
       loanProductMapper.insert(cloneIgnoreId(dbLoanProduct, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       loanProductMapper.insert(cloneIgnoreId(dbLoanProduct, o -> o.setCreateTime(null)));
       // 准备参数
       BpmLoanProductPageReqVO reqVO = new BpmLoanProductPageReqVO();
       reqVO.setName(null);
       reqVO.setNo(null);
       reqVO.setRates(null);
       reqVO.setAmount(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<BpmLoanProductDO> pageResult = loanProductService.getLoanProductPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbLoanProduct, pageResult.getList().get(0));
    }

}
