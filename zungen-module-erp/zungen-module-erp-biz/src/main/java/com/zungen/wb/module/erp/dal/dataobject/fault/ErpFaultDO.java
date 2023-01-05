package com.zungen.wb.module.erp.dal.dataobject.fault;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import com.zungen.wb.framework.mybatis.core.dataobject.BaseDO;

/**
 * 故障 DO
 *
 * @author admin
 */
@TableName("erp_fault")
@KeySequence("erp_fault_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErpFaultDO extends BaseDO {

    /**
     * 唯一标识
     */
    @TableId
    private Long id;
    /**
     * 故障编号
     */
    private String code;
    /**
     * 资产编号
     */
    private String assetCode;
    /**
     * 对应各类资产表id
     */
    private String assetId;
    /**
     * 资产分类
     */
    private Integer assetType;
    /**
     * 故障类型
     */
    private Integer faultType;
    /**
     * 上报人手机号
     */
    private String mobile;
    /**
     * 上报人姓名
     */
    private String reportor;
    /**
     * 替换的设备id
     */
    private String replaceAssetId;
    /**
     * 备注
     */
    private String remark;

}
