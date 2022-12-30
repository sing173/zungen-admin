package com.zungen.wb.module.erp.dal.dataobject.assets;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import com.zungen.wb.framework.mybatis.core.dataobject.BaseDO;

/**
 * 资产-平板 DO
 *
 * @author admin
 */
@TableName("erp_assets_pad")
@KeySequence("erp_assets_pad_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErpAssetsPadDO extends BaseDO {

    /**
     * 唯一标识
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    /**
     * 平板名称
     */
    private String name;
    /**
     * 平板资产编号(IMEI)
     */
    private String code;
    /**
     * 状态
     */
    private Integer status;
    /**
     * MEID
     */
    private String meid;
    /**
     * 序列号
     */
    private String sn;
    /**
     * 型号
     */
    private String modelNo;
    /**
     * 批次号
     */
    private String batchNo;
    /**
     * rom版本号
     */
    private String rom;
    /**
     * 规格
     */
    private String specs;
    /**
     * 蓝牙mac地址
     */
    private String blueMac;
    /**
     * 无线mac地址
     */
    private String mac;
    /**
     * 使用部门
     */
    private Long useDept;
    /**
     * 备注
     */
    private String remark;

}
