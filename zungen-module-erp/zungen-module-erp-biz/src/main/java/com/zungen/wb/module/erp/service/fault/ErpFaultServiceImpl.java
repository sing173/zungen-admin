package com.zungen.wb.module.erp.service.fault;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import java.util.*;
import com.zungen.wb.module.erp.controller.admin.fault.vo.*;
import com.zungen.wb.module.erp.dal.dataobject.fault.ErpFaultDO;
import com.zungen.wb.framework.common.pojo.PageResult;

import com.zungen.wb.module.erp.convert.fault.ErpFaultConvert;
import com.zungen.wb.module.erp.dal.mysql.fault.ErpFaultMapper;

import static com.zungen.wb.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.zungen.wb.module.erp.enums.ErrorCodeConstants.*;

/**
 * 故障 Service 实现类
 *
 * @author admin
 */
@Service
@Validated
public class ErpFaultServiceImpl implements ErpFaultService {

    @Resource
    private ErpFaultMapper faultMapper;

    @Override
    public Long createFault(ErpFaultCreateReqVO createReqVO) {
        // 插入
        ErpFaultDO fault = ErpFaultConvert.INSTANCE.convert(createReqVO);
        faultMapper.insert(fault);
        // 返回
        return fault.getId();
    }

    @Override
    public void updateFault(ErpFaultUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateFaultExists(updateReqVO.getId());
        // 更新
        ErpFaultDO updateObj = ErpFaultConvert.INSTANCE.convert(updateReqVO);
        faultMapper.updateById(updateObj);
    }

    @Override
    public void handleFault(@Valid ErpFaultHandleReqVO handleReqVO) {
        // 校验存在
        this.validateFaultExists(handleReqVO.getId());
        // 更新
        ErpFaultDO updateObj = ErpFaultConvert.INSTANCE.convert(handleReqVO);
        updateObj.setStatus(1);
        faultMapper.updateById(updateObj);
    }

    @Override
    public void deleteFault(Long id) {
        // 校验存在
        this.validateFaultExists(id);
        // 删除
        faultMapper.deleteById(id);
    }

    private void validateFaultExists(Long id) {
        if (faultMapper.selectById(id) == null) {
            throw exception(FAULT_NOT_EXISTS);
        }
    }

    @Override
    public ErpFaultDO getFault(Long id) {
        return faultMapper.selectById(id);
    }

    @Override
    public List<ErpFaultDO> getFaultList(Collection<Long> ids) {
        return faultMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ErpFaultDO> getFaultPage(ErpFaultPageReqVO pageReqVO) {
        return faultMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ErpFaultDO> getFaultList(ErpFaultExportReqVO exportReqVO) {
        return faultMapper.selectList(exportReqVO);
    }

}
