package com.zungen.wb.module.bpm.dal.dataobject.loan;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import com.zungen.wb.framework.mybatis.core.dataobject.BaseDO;

/**
 * 贷款工单 DO
 *
 * @author minson
 */
@TableName("bpm_loan_order")
@KeySequence("bpm_loan_order_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BpmLoanOrderDO extends BaseDO {

    /**
     * 贷款表单主键
     */
    @TableId
    private Long id;
    /**
     * 贷款编号
     */
    private String orderNo;
    /**
     * 贷款人编号
     */
    private Long loanUserId;
    /**
     * 贷款产品编号
     */
    private Long productId;
    /**
     * 担保信息编号
     */
    private Long guaranteeId;
    /**
     * 流程实例的编号
     */
    private String processInstanceId;
    /**
     * 期望额度
     */
    private Long expectedCredit;
    /**
     * 初始额度
     */
    private Long initialCredit;
    /**
     * 还款期数
     */
    private Integer repaymentPeriods;
    /**
     * 还款方式
     */
    private Integer repaymentType;
    /**
     * 审批时间
     */
    private Date auditTime;
    /**
     * 审批意见
     */
    private String auditRemark;
    /**
     * 状态
     */
    private Integer status;

}
