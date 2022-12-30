package com.zungen.wb.module.erp.dal.dataobject.assets;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import com.zungen.wb.framework.mybatis.core.dataobject.BaseDO;

/**
 * 资产-背夹 DO
 *
 * @author admin
 */
@TableName("erp_assets_back")
@KeySequence("erp_assets_back_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErpAssetsBackDO extends BaseDO {

    /**
     * 唯一标识
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    /**
     * 平板id
     */
    private Long padId;
    /**
     * 背夹名称
     */
    private String name;
    /**
     * 背夹资产编号
     */
    private String code;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 序列号
     */
    private String sn;
    /**
     * 备注
     */
    private String remark;

}
