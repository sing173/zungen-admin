package com.zungen.wb.module.bpm.service.loan;

import cn.hutool.core.io.IoUtil;
import com.zungen.wb.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.identity.BpmLoanIdentityCreateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.identity.BpmLoanIdentityPageReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.identity.BpmLoanIdentityUpdateReqVO;
import com.zungen.wb.module.bpm.controller.admin.loan.vo.identity.BpmLoanIdentityVO;
import com.zungen.wb.module.infra.api.file.FileApi;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.io.InputStream;
import java.util.*;

import com.zungen.wb.module.bpm.dal.dataobject.loan.BpmLoanIdentityDO;
import com.zungen.wb.framework.common.pojo.PageResult;

import com.zungen.wb.module.bpm.convert.loan.BpmLoanIdentityConvert;
import com.zungen.wb.module.bpm.dal.mysql.loan.BpmLoanIdentityMapper;

import static com.zungen.wb.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.zungen.wb.module.bpm.enums.ErrorCodeConstants.*;

/**
 * 贷款/担保人-身份要素认证 Service 实现类
 *
 * @author minson
 */
@Service
@Validated
public class BpmLoanIdentityServiceImpl implements BpmLoanIdentityService {

    @Resource
    private BpmLoanIdentityMapper loanIdentityMapper;

    @Resource
    private FileApi fileApi;

    @Override
    public String uploadIdCardFront(Long loginUserId, InputStream inputStream) {
        BpmLoanIdentityDO identityDO = this.checkUserIdentityExists(loginUserId);
        // 创建文件
        String idCardFront = fileApi.createFile(IoUtil.readBytes(inputStream));
        // 更新图片路径
        loanIdentityMapper.updateById(BpmLoanIdentityDO.builder().id(identityDO.getId()).identityCardFront(idCardFront).build());
        return idCardFront;
    }

    @Override
    public String uploadIdCardBack(Long loginUserId, InputStream inputStream) {
        BpmLoanIdentityDO identityDO = this.checkUserIdentityExists(loginUserId);
        // 创建文件
        String idCardBack = fileApi.createFile(IoUtil.readBytes(inputStream));
        // 更新图片路径
        loanIdentityMapper.updateById(BpmLoanIdentityDO.builder().id(identityDO.getId()).identityCardBack(idCardBack).build());
        return idCardBack;
    }

    @Override
    public Boolean validateLoanUser(BpmLoanIdentityVO loanIdentityVO) {
        return true;
    }

    @Override
    public Boolean validateGuarantor(BpmLoanIdentityVO loanIdentityVO) {
        return true;
    }


    private BpmLoanIdentityDO checkUserIdentityExists(Long loginUserId) {
        if (loginUserId == null) {
            return null;
        }
        //根据用户id查询认证状态为正常的最近一个身份认证信息
        BpmLoanIdentityDO identity = loanIdentityMapper.selectOne(new LambdaQueryWrapperX<BpmLoanIdentityDO>()
                .eqIfPresent(BpmLoanIdentityDO::getUserId, loginUserId)
                .eqIfPresent(BpmLoanIdentityDO::getStatus, 0)
                .orderByDesc(BpmLoanIdentityDO::getCreateTime));
        if (identity == null) {
            throw exception(LOAN_IDENTITY_NOT_EXISTS);
        }
        return identity;
    }

    @Override
    public Long createLoanIdentity(BpmLoanIdentityCreateReqVO createReqVO) {
        // 插入
        BpmLoanIdentityDO loanIdentity = BpmLoanIdentityConvert.INSTANCE.convert(createReqVO);
        loanIdentityMapper.insert(loanIdentity);
        // 返回
        return loanIdentity.getId();
    }

    @Override
    public void updateLoanIdentity(BpmLoanIdentityUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateLoanIdentityExists(updateReqVO.getId());
        // 更新
        BpmLoanIdentityDO updateObj = BpmLoanIdentityConvert.INSTANCE.convert(updateReqVO);
        loanIdentityMapper.updateById(updateObj);
    }

    @Override
    public void deleteLoanIdentity(Long id) {
        // 校验存在
        this.validateLoanIdentityExists(id);
        // 删除
        loanIdentityMapper.deleteById(id);
    }

    private void validateLoanIdentityExists(Long id) {
        if (loanIdentityMapper.selectById(id) == null) {
            throw exception(LOAN_IDENTITY_NOT_EXISTS);
        }
    }

    @Override
    public BpmLoanIdentityDO getLoanIdentity(Long id) {
        return loanIdentityMapper.selectById(id);
    }

    @Override
    public List<BpmLoanIdentityDO> getLoanIdentityList(Collection<Long> ids) {
        return loanIdentityMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<BpmLoanIdentityDO> getLoanIdentityPage(BpmLoanIdentityPageReqVO pageReqVO) {
        return loanIdentityMapper.selectPage(pageReqVO);
    }

}
