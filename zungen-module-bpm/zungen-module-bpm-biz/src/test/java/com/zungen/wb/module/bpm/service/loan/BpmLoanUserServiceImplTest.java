package com.zungen.wb.module.bpm.service.loan;

import com.zungen.wb.module.bpm.controller.admin.loan.vo.user.BpmLoanUserCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.user.BpmLoanUserPageReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.user.BpmLoanUserUpdateReqVO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import com.zungen.wb.framework.test.core.ut.BaseDbUnitTest;

import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanUserDO;
import com.zungen.wb.module.bpm.dal.mysql.loan.BpmLoanUserMapper;
import com.zungen.wb.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;
import java.util.*;

import static com.zungen.wb.framework.test.core.util.AssertUtils.*;
import static com.zungen.wb.framework.test.core.util.RandomUtils.*;
import static com.zungen.wb.framework.common.util.object.ObjectUtils.*;
import static com.zungen.wb.module.bpm.enums.ErrorCodeConstants.LOAN_USER_NOT_EXISTS;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link BpmLoanUserServiceImpl} 的单元测试类
*
* @author minson
*/
@Import(BpmLoanUserServiceImpl.class)
public class BpmLoanUserServiceImplTest extends BaseDbUnitTest {

    @Resource
    private BpmLoanUserServiceImpl loanUserService;

    @Resource
    private BpmLoanUserMapper loanUserMapper;

    @Test
    public void testCreateLoanUser_success() {
        // 准备参数
        BpmLoanUserCreateReqVO reqVO = randomPojo(BpmLoanUserCreateReqVO.class);

        // 调用
        Long loanUserId = loanUserService.createLoanUser(reqVO);
        // 断言
        assertNotNull(loanUserId);
        // 校验记录的属性是否正确
        BpmLoanUserDO loanUser = loanUserMapper.selectById(loanUserId);
        assertPojoEquals(reqVO, loanUser);
    }

    @Test
    public void testUpdateLoanUser_success() {
        // mock 数据
        BpmLoanUserDO dbLoanUser = randomPojo(BpmLoanUserDO.class);
        loanUserMapper.insert(dbLoanUser);// @Sql: 先插入出一条存在的数据
        // 准备参数
        BpmLoanUserUpdateReqVO reqVO = randomPojo(BpmLoanUserUpdateReqVO.class, o -> {
            o.setId(dbLoanUser.getId()); // 设置更新的 ID
        });

        // 调用
        loanUserService.updateLoanUser(reqVO);
        // 校验是否更新正确
        BpmLoanUserDO loanUser = loanUserMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, loanUser);
    }

    @Test
    public void testUpdateLoanUser_notExists() {
        // 准备参数
        BpmLoanUserUpdateReqVO reqVO = randomPojo(BpmLoanUserUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> loanUserService.updateLoanUser(reqVO), LOAN_USER_NOT_EXISTS);
    }

    @Test
    public void testDeleteLoanUser_success() {
        // mock 数据
        BpmLoanUserDO dbLoanUser = randomPojo(BpmLoanUserDO.class);
        loanUserMapper.insert(dbLoanUser);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbLoanUser.getId();

        // 调用
        loanUserService.deleteLoanUser(id);
       // 校验数据不存在了
       assertNull(loanUserMapper.selectById(id));
    }

    @Test
    public void testDeleteLoanUser_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> loanUserService.deleteLoanUser(id), LOAN_USER_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetLoanUserPage() {
       // mock 数据
       BpmLoanUserDO dbLoanUser = randomPojo(BpmLoanUserDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setMobile(null);
           o.setCreateTime(null);
       });
       loanUserMapper.insert(dbLoanUser);
       // 测试 name 不匹配
       loanUserMapper.insert(cloneIgnoreId(dbLoanUser, o -> o.setName(null)));
       // 测试 mobile 不匹配
       loanUserMapper.insert(cloneIgnoreId(dbLoanUser, o -> o.setMobile(null)));
       // 测试 createTime 不匹配
       loanUserMapper.insert(cloneIgnoreId(dbLoanUser, o -> o.setCreateTime(null)));
       // 准备参数
       BpmLoanUserPageReqVO reqVO = new BpmLoanUserPageReqVO();
       reqVO.setName(null);
       reqVO.setMobile(null);
       reqVO.setContactName(null);
       reqVO.setContactMobile(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<BpmLoanUserDO> pageResult = loanUserService.getLoanUserPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbLoanUser, pageResult.getList().get(0));
    }

}
