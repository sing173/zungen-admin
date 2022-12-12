package com.zungen.wb.module.erp.dal.dataobject.assets;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import com.zungen.wb.framework.mybatis.core.dataobject.BaseDO;

/**
 * 资产-sim卡 DO
 *
 * @author admin
 */
@TableName("erp_assets_sim")
@KeySequence("erp_assets_sim_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErpAssetsSimDO extends BaseDO {

    /**
     * 唯一标识
     */
    @TableId
    private Long id;
    /**
     * sim名称
     */
    private String name;
    /**
     * sim卡资产编号(卡号,也是序列号)
     */
    private String code;
    /**
     * 平板id
     */
    private Long padId;
    /**
     * sim卡iccid号
     */
    private String iccid;
    /**
     * sim卡imsi号
     */
    private String imsi;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
