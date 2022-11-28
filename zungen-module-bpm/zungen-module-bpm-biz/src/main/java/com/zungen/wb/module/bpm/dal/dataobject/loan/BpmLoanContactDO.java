package com.zungen.wb.module.bpm.dal.dataobject.loan;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import com.zungen.wb.framework.mybatis.core.dataobject.BaseDO;

/**
 * 联系人信息 DO
 *
 * @author minson
 */
@TableName("bpm_loan_contact")
@KeySequence("bpm_loan_contact_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BpmLoanContactDO extends BaseDO {

    /**
     * 联系人主键
     */
    @TableId
    private Long id;
    /**
     * 贷款人的用户编号
     */
    private Long userId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 家庭地址
     */
    private String address;
    /**
     * 工作单位
     */
    private String work;
    /**
     * 工作电话
     */
    private String workPhone;
    /**
     * 工作地址
     */
    private String workAddress;
    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 关系
     */
    private Integer relationship;
    /**
     * 联系人类型（紧急、工作...）
     */
    private Integer type;

}
