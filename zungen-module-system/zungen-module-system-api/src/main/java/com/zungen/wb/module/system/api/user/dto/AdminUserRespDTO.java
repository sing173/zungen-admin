package com.zungen.wb.module.system.api.user.dto;

import com.zungen.wb.framework.common.enums.CommonStatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * Admin 用户 Response DTO
 *
 * @author admin
 */
@Data
public class AdminUserRespDTO implements Serializable {

    /**
     * 用户ID
     */
    private Long id;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 帐号状态
     *
     * 枚举 {@link CommonStatusEnum}
     */
    private Integer status;

    /**
     * 部门ID
     */
    private Long deptId;
    /**
     * 岗位编号数组
     */
    private Set<Long> postIds;
    /**
     * 手机号码
     */
    private String mobile;

}
