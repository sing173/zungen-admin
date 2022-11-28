package com.zungen.wb.module.system.service.dict;

import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.module.system.controller.admin.dict.vo.type.DictTypeCreateReqVO;
import com.zungen.wb.module.system.controller.admin.dict.vo.type.DictTypeExportReqVO;
import com.zungen.wb.module.system.controller.admin.dict.vo.type.DictTypePageReqVO;
import com.zungen.wb.module.system.controller.admin.dict.vo.type.DictTypeUpdateReqVO;
import com.zungen.wb.module.system.dal.dataobject.dict.DictTypeDO;

import java.util.List;

/**
 * 字典类型 Service 接口
 *
 * @author admin
 */
public interface DictTypeService {

    /**
     * 创建字典类型
     *
     * @param reqVO 字典类型信息
     * @return 字典类型编号
     */
    Long createDictType(DictTypeCreateReqVO reqVO);

    /**
     * 更新字典类型
     *
     * @param reqVO 字典类型信息
     */
    void updateDictType(DictTypeUpdateReqVO reqVO);

    /**
     * 删除字典类型
     *
     * @param id 字典类型编号
     */
    void deleteDictType(Long id);

    /**
     * 获得字典类型分页列表
     *
     * @param reqVO 分页请求
     * @return 字典类型分页列表
     */
    PageResult<DictTypeDO> getDictTypePage(DictTypePageReqVO reqVO);

    /**
     * 获得字典类型列表
     *
     * @param reqVO 列表请求
     * @return 字典类型列表
     */
    List<DictTypeDO> getDictTypeList(DictTypeExportReqVO reqVO);

    /**
     * 获得字典类型详情
     *
     * @param id 字典类型编号
     * @return 字典类型
     */
    DictTypeDO getDictType(Long id);

    /**
     * 获得字典类型详情
     *
     * @param type 字典类型
     * @return 字典类型详情
     */
    DictTypeDO getDictType(String type);

    /**
     * 获得全部字典类型列表
     *
     * @return 字典类型列表
     */
    List<DictTypeDO> getDictTypeList();

}
