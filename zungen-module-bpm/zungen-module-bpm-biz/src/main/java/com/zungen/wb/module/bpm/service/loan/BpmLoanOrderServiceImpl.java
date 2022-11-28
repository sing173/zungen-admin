package com.zungen.wb.module.bpm.service.loan;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.zungen.wb.module.bpm.api.task.BpmProcessInstanceApi;
import com.zungen.wb.module.bpm.api.task.dto.BpmProcessInstanceCreateReqDTO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.order.BpmLoanOrderCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.order.BpmLoanOrderPageReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.order.BpmLoanOrderUpdateReqVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;

import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanOrderDO;
import com.zungen.wb.framework.common.pojo.PageResult;

import com.zungen.wb.module.bpm.convert.loan.BpmLoanOrderConvert;
import com.zungen.wb.module.bpm.dal.mysql.loan.BpmLoanOrderMapper;

import static com.zungen.wb.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.zungen.wb.module.bpm.enums.ErrorCodeConstants.*;

/**
 * 贷款工单 Service 实现类
 *
 * @author minson
 */
@Service
@Validated
public class BpmLoanOrderServiceImpl implements BpmLoanOrderService {
    /**
     * 贷款流程对应的流程定义 KEY
     */
    public static final String PROCESS_KEY = "loan_ny";

    @Resource
    private BpmLoanOrderMapper loanOrderMapper;

    @Resource
    private BpmProcessInstanceApi processInstanceApi;

    @Override
    public Long createLoanOrder(Long userId, BpmLoanOrderCreateReqVO createReqVO) {
        // 插入贷款工单
        BpmLoanOrderDO loanOrder = BpmLoanOrderConvert.INSTANCE.convert(createReqVO);
        //TODO 生成合同编号、状态
        loanOrder.setOrderNo(DateUtil.now() + RandomUtil.randomStringUpper(2));
        loanOrder.setStatus(0);
        loanOrderMapper.insert(loanOrder);

        // 发起贷款 BPM 流程
        Map<String, Object> processInstanceVariables = new HashMap<>();
        //把产品编号放入流程变量中作为后续根据产品走不同分支的字段
        processInstanceVariables.put("productId", createReqVO.getProductId());
        String processInstanceId = processInstanceApi.createProcessInstance(userId,
                new BpmProcessInstanceCreateReqDTO().setProcessDefinitionKey(PROCESS_KEY)
                        .setVariables(processInstanceVariables).setBusinessKey(String.valueOf(loanOrder.getId())));

        // 将工作流的编号，更新到贷款工单中
        loanOrderMapper.updateById(new BpmLoanOrderDO().setId(loanOrder.getId()).setProcessInstanceId(processInstanceId));

        // 返回
        return loanOrder.getId();
    }

    @Override
    public void updateLoanOrder(BpmLoanOrderUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateLoanOrderExists(updateReqVO.getId());
        // 更新
        BpmLoanOrderDO updateObj = BpmLoanOrderConvert.INSTANCE.convert(updateReqVO);
        loanOrderMapper.updateById(updateObj);
    }

    @Override
    public void deleteLoanOrder(Long id) {
        // 校验存在
        this.validateLoanOrderExists(id);
        // 删除
        loanOrderMapper.deleteById(id);
    }

    private void validateLoanOrderExists(Long id) {
        if (loanOrderMapper.selectById(id) == null) {
            throw exception(LOAN_ORDER_NOT_EXISTS);
        }
    }

    @Override
    public BpmLoanOrderDO getLoanOrder(Long id) {
        return loanOrderMapper.selectById(id);
    }

    @Override
    public List<BpmLoanOrderDO> getLoanOrderList(Collection<Long> ids) {
        return loanOrderMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<BpmLoanOrderDO> getLoanOrderPage(BpmLoanOrderPageReqVO pageReqVO) {
        return loanOrderMapper.selectPage(pageReqVO);
    }

}
