package com.zungen.wb.module.bpm.dal.dataobject.loan;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import com.zungen.wb.framework.mybatis.core.dataobject.BaseDO;

/**
 * 担保信息 DO
 *
 * @author minson
 */
@TableName("bpm_loan_guarantee")
@KeySequence("bpm_loan_guarantee_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BpmLoanGuaranteeDO extends BaseDO {

    /**
     * 担保信息主键
     */
    @TableId
    private Long id;
    /**
     * 担保人的用户编号
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
     * 担保人的家庭地址
     */
    private String address;
    /**
     * 担保人的工作单位
     */
    private String work;
    /**
     * 担保人的工作电话
     */
    private String workPhone;
    /**
     * 担保人的家庭地址
     */
    private String workAddress;
    /**
     * 担保人的邮箱地址
     */
    private String email;
    /**
     * 与贷款人关系
     */
    private Integer relationship;
    /**
     * 担保人的身份认证id
     */
    private Long identityId;
    /**
     * 担保人的联系人id
     */
    private Long contactId;
    /**
     * 状态(已注册、接收担保、验证通过）
     */
    private Integer status;
    /**
     * 担保人签名
     */
    private String sign;
    /**
     * 担保人确认担保视频
     */
    private String authVideo;

}
