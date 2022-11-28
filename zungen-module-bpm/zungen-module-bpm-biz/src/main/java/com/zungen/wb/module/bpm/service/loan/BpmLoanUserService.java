package com.zungen.wb.module.bpm.service.loan;

import java.util.*;
import javax.validation.*;

import com.zungen.wb.module.bpm.controller.admin.loan.vo.user.BpmLoanUserCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.user.BpmLoanUserPageReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.user.BpmLoanUserUpdateReqVO;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanUserDO;
import com.zungen.wb.framework.common.pojo.PageResult;

/**
 * 贷款人信息 Service 接口
 *
 * @author minson
 */
public interface BpmLoanUserService {

    /**
     * 创建贷款人信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createLoanUser(@Valid BpmLoanUserCreateReqVO createReqVO);

    /**
     * 更新贷款人信息
     *
     * @param updateReqVO 更新信息
     */
    void updateLoanUser(@Valid BpmLoanUserUpdateReqVO updateReqVO);

    /**
     * 删除贷款人信息
     *
     * @param id 编号
     */
    void deleteLoanUser(Long id);

    /**
     * 获得贷款人信息
     *
     * @param id 编号
     * @return 贷款人信息
     */
    BpmLoanUserDO getLoanUser(Long id);

    /**
     * 获得贷款人信息列表
     *
     * @param ids 编号
     * @return 贷款人信息列表
     */
    List<BpmLoanUserDO> getLoanUserList(Collection<Long> ids);

    /**
     * 获得贷款人信息分页
     *
     * @param pageReqVO 分页查询
     * @return 贷款人信息分页
     */
    PageResult<BpmLoanUserDO> getLoanUserPage(BpmLoanUserPageReqVO pageReqVO);

}
