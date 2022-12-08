package com.zungen.wb.module.erp.dal.dataobject.assets;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import com.zungen.wb.framework.mybatis.core.dataobject.BaseDO;

/**
 * 资产 DO
 *
 * @author admin
 */
@TableName("erp_assets")
@KeySequence("erp_assets_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErpAssetsDO extends BaseDO {

    /**
     * 唯一标识
     */
    @TableId
    private Long id;
    /**
     * 对应各类资产表id
     */
    private Long assertId;
    /**
     * 资产名称
     */
    private String name;
    /**
     * 资产编号
     */
    private String code;
    /**
     * 资产分类
     */
    private Integer type;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 关联资产
     */
    private Long parent;
    /**
     * 入库时间
     */
    private Date checkInTime;
    /**
     * 序列号
     */
    private String sn;
    /**
     * 使用部门
     */
    private String useDept;
    /**
     * 备注
     */
    private String remark;

}
