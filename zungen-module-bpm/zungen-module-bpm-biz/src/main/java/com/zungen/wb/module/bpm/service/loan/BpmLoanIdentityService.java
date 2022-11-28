package com.zungen.wb.module.bpm.service.loan;

import java.io.InputStream;
import java.util.*;
import javax.validation.*;

import com.zungen.wb.module.bpm.controller.admin.loan.vo.identity.BpmLoanIdentityCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.identity.BpmLoanIdentityPageReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.identity.BpmLoanIdentityUpdateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.identity.BpmLoanIdentityVO;
import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanIdentityDO;
import com.zungen.wb.framework.common.pojo.PageResult;

/**
 * 贷款/担保人-身份要素认证 Service 接口
 *
 * @author minson
 */
public interface BpmLoanIdentityService {

    /**
     * 上传身份证正面照
     * @param loginUserId
     * @param inputStream
     * @return
     */
    String uploadIdCardFront(Long loginUserId, InputStream inputStream);

    /**
     * 上传身份证背面照
     * @param loginUserId
     * @param inputStream
     * @return
     */
    String uploadIdCardBack(Long loginUserId, InputStream inputStream);


    /**
     * 调用第三方身份要素接口进行借款人身份认证
     * @param loanIdentityVO
     * @return
     */
    Boolean validateLoanUser(BpmLoanIdentityVO loanIdentityVO);

    /**
     * 调用第三方身份要素接口进行担保人身份认证
     * @param loanIdentityVO
     * @return
     */
    Boolean validateGuarantor(BpmLoanIdentityVO loanIdentityVO);

    /**
     * 创建贷款/担保人-身份要素认证
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createLoanIdentity(@Valid BpmLoanIdentityCreateReqVO createReqVO);

    /**
     * 更新贷款/担保人-身份要素认证
     *
     * @param updateReqVO 更新信息
     */
    void updateLoanIdentity(@Valid BpmLoanIdentityUpdateReqVO updateReqVO);

    /**
     * 删除贷款/担保人-身份要素认证
     *
     * @param id 编号
     */
    void deleteLoanIdentity(Long id);

    /**
     * 获得贷款/担保人-身份要素认证
     *
     * @param id 编号
     * @return 贷款/担保人-身份要素认证
     */
    BpmLoanIdentityDO getLoanIdentity(Long id);

    /**
     * 获得贷款/担保人-身份要素认证列表
     *
     * @param ids 编号
     * @return 贷款/担保人-身份要素认证列表
     */
    List<BpmLoanIdentityDO> getLoanIdentityList(Collection<Long> ids);

    /**
     * 获得贷款/担保人-身份要素认证分页
     *
     * @param pageReqVO 分页查询
     * @return 贷款/担保人-身份要素认证分页
     */
    PageResult<BpmLoanIdentityDO> getLoanIdentityPage(BpmLoanIdentityPageReqVO pageReqVO);


}
