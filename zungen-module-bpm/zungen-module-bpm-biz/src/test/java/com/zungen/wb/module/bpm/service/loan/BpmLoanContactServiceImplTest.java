package com.zungen.wb.module.bpm.service.loan;

import com.zungen.wb.module.bpm.controller.admin.loan.vo.contact.BpmLoanContactCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.contact.BpmLoanContactPageReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.contact.BpmLoanContactUpdateReqVO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import com.zungen.wb.framework.test.core.ut.BaseDbUnitTest;

import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanContactDO;
import com.zungen.wb.module.bpm.dal.mysql.loan.BpmLoanContactMapper;
import com.zungen.wb.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;
import java.util.*;

import static com.zungen.wb.module.bpm.enums.ErrorCodeConstants.*;
import static com.zungen.wb.framework.test.core.util.AssertUtils.*;
import static com.zungen.wb.framework.test.core.util.RandomUtils.*;
import static com.zungen.wb.framework.common.util.object.ObjectUtils.*;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link BpmLoanContactServiceImpl} 的单元测试类
*
* @author minson
*/
@Import(BpmLoanContactServiceImpl.class)
public class BpmLoanContactServiceImplTest extends BaseDbUnitTest {

    @Resource
    private BpmLoanContactServiceImpl loanContactService;

    @Resource
    private BpmLoanContactMapper loanContactMapper;

    @Test
    public void testCreateLoanContact_success() {
        // 准备参数
        BpmLoanContactCreateReqVO reqVO = randomPojo(BpmLoanContactCreateReqVO.class);

        // 调用
        Long loanContactId = loanContactService.createLoanContact(reqVO);
        // 断言
        assertNotNull(loanContactId);
        // 校验记录的属性是否正确
        BpmLoanContactDO loanContact = loanContactMapper.selectById(loanContactId);
        assertPojoEquals(reqVO, loanContact);
    }

    @Test
    public void testUpdateLoanContact_success() {
        // mock 数据
        BpmLoanContactDO dbLoanContact = randomPojo(BpmLoanContactDO.class);
        loanContactMapper.insert(dbLoanContact);// @Sql: 先插入出一条存在的数据
        // 准备参数
        BpmLoanContactUpdateReqVO reqVO = randomPojo(BpmLoanContactUpdateReqVO.class, o -> {
            o.setId(dbLoanContact.getId()); // 设置更新的 ID
        });

        // 调用
        loanContactService.updateLoanContact(reqVO);
        // 校验是否更新正确
        BpmLoanContactDO loanContact = loanContactMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, loanContact);
    }

    @Test
    public void testUpdateLoanContact_notExists() {
        // 准备参数
        BpmLoanContactUpdateReqVO reqVO = randomPojo(BpmLoanContactUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> loanContactService.updateLoanContact(reqVO), LOAN_CONTACT_NOT_EXISTS);
    }

    @Test
    public void testDeleteLoanContact_success() {
        // mock 数据
        BpmLoanContactDO dbLoanContact = randomPojo(BpmLoanContactDO.class);
        loanContactMapper.insert(dbLoanContact);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbLoanContact.getId();

        // 调用
        loanContactService.deleteLoanContact(id);
       // 校验数据不存在了
       assertNull(loanContactMapper.selectById(id));
    }

    @Test
    public void testDeleteLoanContact_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> loanContactService.deleteLoanContact(id), LOAN_CONTACT_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetLoanContactPage() {
       // mock 数据
       BpmLoanContactDO dbLoanContact = randomPojo(BpmLoanContactDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setMobile(null);
           o.setWork(null);
           o.setEmail(null);
           o.setRelationship(null);
           o.setCreateTime(null);
           o.setType(null);
       });
       loanContactMapper.insert(dbLoanContact);
       // 测试 name 不匹配
       loanContactMapper.insert(cloneIgnoreId(dbLoanContact, o -> o.setName(null)));
       // 测试 mobile 不匹配
       loanContactMapper.insert(cloneIgnoreId(dbLoanContact, o -> o.setMobile(null)));
       // 测试 work 不匹配
       loanContactMapper.insert(cloneIgnoreId(dbLoanContact, o -> o.setWork(null)));
       // 测试 email 不匹配
       loanContactMapper.insert(cloneIgnoreId(dbLoanContact, o -> o.setEmail(null)));
       // 测试 relationship 不匹配
       loanContactMapper.insert(cloneIgnoreId(dbLoanContact, o -> o.setRelationship(null)));
       // 测试 createTime 不匹配
       loanContactMapper.insert(cloneIgnoreId(dbLoanContact, o -> o.setCreateTime(null)));
       // 测试 type 不匹配
       loanContactMapper.insert(cloneIgnoreId(dbLoanContact, o -> o.setType(null)));
       // 准备参数
       BpmLoanContactPageReqVO reqVO = new BpmLoanContactPageReqVO();
       reqVO.setName(null);
       reqVO.setMobile(null);
       reqVO.setWork(null);
       reqVO.setEmail(null);
       reqVO.setRelationship(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setType(null);

       // 调用
       PageResult<BpmLoanContactDO> pageResult = loanContactService.getLoanContactPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbLoanContact, pageResult.getList().get(0));
    }

}
