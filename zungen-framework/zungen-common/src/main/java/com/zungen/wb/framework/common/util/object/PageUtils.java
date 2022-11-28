package com.zungen.wb.framework.common.util.object;

import com.zungen.wb.framework.common.pojo.PageParam;

/**
 * {@link com.zungen.wb.framework.common.pojo.PageParam} 工具类
 *
 * @author admin
 */
public class PageUtils {

    public static int getStart(PageParam pageParam) {
        return (pageParam.getPageNo() - 1) * pageParam.getPageSize();
    }

}
