package com.zungen.wb.framework.sms.core.client.impl.debug;

import com.zungen.wb.framework.common.exception.ErrorCode;
import com.zungen.wb.framework.common.exception.enums.GlobalErrorCodeConstants;
import com.zungen.wb.framework.sms.core.client.SmsCodeMapping;
import com.zungen.wb.framework.sms.core.enums.SmsFrameworkErrorCodeConstants;

import java.util.Objects;

/**
 * 钉钉的 SmsCodeMapping 实现类
 *
 * @author admin
 */
public class DebugDingTalkCodeMapping implements SmsCodeMapping {

    @Override
    public ErrorCode apply(String apiCode) {
        return Objects.equals(apiCode, "0") ? GlobalErrorCodeConstants.SUCCESS : SmsFrameworkErrorCodeConstants.SMS_UNKNOWN;
    }

}
