package com.zungen.wb.module.bpm.dal.dataobject.loan;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import com.zungen.wb.framework.mybatis.core.dataobject.BaseDO;

/**
 * 贷款产品 DO
 *
 * @author minson
 */
@TableName("bpm_loan_product")
@KeySequence("bpm_loan_product_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BpmLoanProductDO extends BaseDO {

    /**
     * 贷款产品主键
     */
    @TableId
    private Long id;
    /**
     * 产品名
     */
    private String name;
    /**
     * 产品编号
     */
    private String no;
    /**
     * 产品利率
     */
    private String rates;
    /**
     * 贷款金额
     */
    private String amount;
    /**
     * 描述
     */
    private String remark;
    /**
     * 状态(正常、过期、作废）
     */
    private Integer status;

}
