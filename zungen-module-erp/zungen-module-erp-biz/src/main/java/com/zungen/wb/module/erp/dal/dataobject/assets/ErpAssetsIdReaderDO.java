package com.zungen.wb.module.erp.dal.dataobject.assets;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import com.zungen.wb.framework.mybatis.core.dataobject.BaseDO;

/**
 * 资产-身份证读取仪 DO
 *
 * @author admin
 */
@TableName("erp_assets_id_reader")
@KeySequence("erp_assets_id_reader_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErpAssetsIdReaderDO extends BaseDO {

    /**
     * 唯一标识
     */
    @TableId
    private Long id;
    /**
     * 平板id
     */
    private Long padId;
    /**
     * 身份证读取仪名称
     */
    private String name;
    /**
     * 资产编号
     */
    private String code;
    /**
     * 序列号
     */
    private String sn;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
