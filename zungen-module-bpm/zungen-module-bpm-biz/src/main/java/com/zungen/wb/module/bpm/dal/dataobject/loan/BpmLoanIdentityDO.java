package com.zungen.wb.module.bpm.dal.dataobject.loan;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import com.zungen.wb.framework.mybatis.core.dataobject.BaseDO;

/**
 * 贷款/担保人-身份要素认证 DO
 *
 * @author minson
 */
@TableName("bpm_loan_identity")
@KeySequence("bpm_loan_identity_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BpmLoanIdentityDO extends BaseDO {

    /**
     * 身份认证主键
     */
    @TableId
    private Long id;
    /**
     * 贷款/担保人的用户编号
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
     * 身份证编号
     */
    private String identityCardNumber;
    /**
     * 身份证正面照片
     */
    private String identityCardFront;
    /**
     * 身份证背面照片
     */
    private String identityCardBack;
    /**
     * 人脸识别状态
     */
    private Integer faceStatus;
    /**
     * 三要素验证状态
     */
    private Integer authStatus;
    /**
     * 状态(正常、过期、作废）
     */
    private Integer status;

}
