package com.zungen.wb.module.bpm.api.loan;

public interface BpmLoanOrderApi {

    /**
     * 借款人身份认证
     */
    void handleLoanUserIdentity();

    /**
     * 预审借款人初始额度
     */
    void handleInitialCredit();

    /**
     * 获取借款人初始额度
     */
    void getInitialCredit();


}
