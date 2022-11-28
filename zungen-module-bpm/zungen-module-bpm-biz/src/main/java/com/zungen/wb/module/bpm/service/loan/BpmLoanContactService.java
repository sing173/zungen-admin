package com.zungen.wb.module.bpm.service.loan;

import java.util.*;
import javax.validation.*;

import com.zungen.wb.module.bpm.controller.admin.loan.vo.contact.BpmLoanContactCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.contact.BpmLoanContactPageReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.contact.BpmLoanContactUpdateReqVO;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanContactDO;
import com.zungen.wb.framework.common.pojo.PageResult;

/**
 * 联系人信息 Service 接口
 *
 * @author minson
 */
public interface BpmLoanContactService {

    /**
     * 创建联系人信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createLoanContact(@Valid BpmLoanContactCreateReqVO createReqVO);

    /**
     * 更新联系人信息
     *
     * @param updateReqVO 更新信息
     */
    void updateLoanContact(@Valid BpmLoanContactUpdateReqVO updateReqVO);

    /**
     * 删除联系人信息
     *
     * @param id 编号
     */
    void deleteLoanContact(Long id);

    /**
     * 获得联系人信息
     *
     * @param id 编号
     * @return 联系人信息
     */
    BpmLoanContactDO getLoanContact(Long id);

    /**
     * 获得联系人信息列表
     *
     * @param ids 编号
     * @return 联系人信息列表
     */
    List<BpmLoanContactDO> getLoanContactList(Collection<Long> ids);

    /**
     * 获得联系人信息分页
     *
     * @param pageReqVO 分页查询
     * @return 联系人信息分页
     */
    PageResult<BpmLoanContactDO> getLoanContactPage(BpmLoanContactPageReqVO pageReqVO);

}
