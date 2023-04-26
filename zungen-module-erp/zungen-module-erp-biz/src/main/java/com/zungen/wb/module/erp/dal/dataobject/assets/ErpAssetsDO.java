package com.zungen.wb.module.erp.dal.dataobject.assets;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsAutoIncrement;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsKey;
import com.gitee.sunchenbin.mybatis.actable.annotation.TableComment;
import com.zungen.wb.framework.mybatis.core.dataobject.BaseDO;
import lombok.*;

import java.util.Date;

/**
 * 资产 DO
 *
 * @author admin
 */
@TableComment("资产总表")
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
    @IsKey
    @IsAutoIncrement
    @Column(comment = "唯一标识")
    private Long id;
    /**
     * 对应各类资产表id
     */
    @Column(comment = "对应各类资产表id")
    private String assetId;
    /**
     * 资产名称
     */
    @Column(comment = "资产名称")
    private String name;
    /**
     * 资产编号
     */
    @Column(comment = "资产编号")
    private String code;
    /**
     * 资产分类
     */
    @Column(comment = "资产分类")
    private Integer type;
    /**
     * 状态
     */
    @Column(comment = "状态")
    private Integer status;
    /**
     * 关联资产
     */
    @Column(comment = "关联资产")
    private String parent;
    /**
     * 入库时间
     */
    @Column(comment = "入库时间")
    private Date checkInTime;
    /**
     * 序列号
     */
    @Column(comment = "序列号")
    private String sn;
    /**
     * 使用部门
     */
    @Column(comment = "使用部门")
    private String useDept;
    /**
     * 备注
     */
    @Column(comment = "备注")
    private String remark;

}
