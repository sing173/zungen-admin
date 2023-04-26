package com.zungen.wb.module.erp.dal.dataobject.assets;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsAutoIncrement;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsKey;
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
    @IsKey
    @Column(comment = "唯一标识")
    private String id;
    /**
     * 平板id
     */
    @Column(comment = "平板id")
    private String padId;
    /**
     * 背夹名称
     */
    @Column(comment = "背夹名称")
    private String name;
    /**
     * 背夹资产编号
     */
    @Column(comment = "背夹资产编号")
    private String code;
    /**
     * 状态
     */
    @Column(comment = "状态")
    private Integer status;
    /**
     * 序列号
     */
    @Column(comment = "序列号")
    private String sn;
    /**
     * 备注
     */
    @Column(comment = "备注")
    private String remark;

}
