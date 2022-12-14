package com.zungen.wb.module.system.controller.admin.oauth2;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.map.MapUtil;
import com.zungen.wb.framework.common.core.KeyValue;
import com.zungen.wb.framework.common.enums.UserTypeEnum;
import com.zungen.wb.framework.common.exception.ErrorCode;
import com.zungen.wb.framework.common.pojo.CommonResult;
import com.zungen.wb.framework.common.util.collection.SetUtils;
import com.zungen.wb.framework.test.core.ut.BaseMockitoUnitTest;
import com.zungen.wb.module.system.controller.admin.oauth2.vo.open.OAuth2OpenAccessTokenRespVO;
import com.zungen.wb.module.system.controller.admin.oauth2.vo.open.OAuth2OpenAuthorizeInfoRespVO;
import com.zungen.wb.module.system.controller.admin.oauth2.vo.open.OAuth2OpenCheckTokenRespVO;
import com.zungen.wb.module.system.dal.dataobject.oauth2.OAuth2AccessTokenDO;
import com.zungen.wb.module.system.dal.dataobject.oauth2.OAuth2ApproveDO;
import com.zungen.wb.module.system.dal.dataobject.oauth2.OAuth2ClientDO;
import com.zungen.wb.module.system.enums.oauth2.OAuth2GrantTypeEnum;
import com.zungen.wb.module.system.service.oauth2.OAuth2ApproveService;
import com.zungen.wb.module.system.service.oauth2.OAuth2ClientService;
import com.zungen.wb.module.system.service.oauth2.OAuth2GrantService;
import com.zungen.wb.module.system.service.oauth2.OAuth2TokenService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import static com.zungen.wb.framework.common.util.collection.SetUtils.asSet;
import static com.zungen.wb.framework.common.util.date.DateUtils.addTime;
import static com.zungen.wb.framework.test.core.util.AssertUtils.assertPojoEquals;
import static com.zungen.wb.framework.test.core.util.AssertUtils.assertServiceException;
import static com.zungen.wb.framework.test.core.util.RandomUtils.randomPojo;
import static com.zungen.wb.framework.test.core.util.RandomUtils.randomString;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link OAuth2OpenController} ???????????????
 *
 * @author admin
 */
public class OAuth2OpenControllerTest extends BaseMockitoUnitTest {

    @InjectMocks
    private OAuth2OpenController oauth2OpenController;

    @Mock
    private OAuth2GrantService oauth2GrantService;
    @Mock
    private OAuth2ClientService oauth2ClientService;
    @Mock
    private OAuth2ApproveService oauth2ApproveService;
    @Mock
    private OAuth2TokenService oauth2TokenService;

    @Test
    public void testPostAccessToken_authorizationCode() {
        // ????????????
        String granType = OAuth2GrantTypeEnum.AUTHORIZATION_CODE.getGrantType();
        String code = randomString();
        String redirectUri = randomString();
        String state = randomString();
        HttpServletRequest request = mockRequest("test_client_id", "test_client_secret");
        // mock ?????????client???
        OAuth2ClientDO client = randomPojo(OAuth2ClientDO.class).setClientId("test_client_id");
        when(oauth2ClientService.validOAuthClientFromCache(eq("test_client_id"), eq("test_client_secret"), eq(granType), eq(new ArrayList<>()), eq(redirectUri))).thenReturn(client);

        // mock ????????????????????????
        OAuth2AccessTokenDO accessTokenDO = randomPojo(OAuth2AccessTokenDO.class)
                .setExpiresTime(addTime(Duration.ofMillis(30050L))); // ?????? 10 ???????????????????????????
        when(oauth2GrantService.grantAuthorizationCodeForAccessToken(eq("test_client_id"),
                eq(code), eq(redirectUri), eq(state))).thenReturn(accessTokenDO);

        // ??????
        CommonResult<OAuth2OpenAccessTokenRespVO> result = oauth2OpenController.postAccessToken(request, granType,
                code, redirectUri, state, null, null, null, null);
        // ??????
        assertEquals(0, result.getCode());
        assertPojoEquals(accessTokenDO, result.getData());
        assertEquals(30L, result.getData().getExpiresIn()); // ??????????????????????????????
    }

    @Test
    public void testPostAccessToken_password() {
        // ????????????
        String granType = OAuth2GrantTypeEnum.PASSWORD.getGrantType();
        String username = randomString();
        String password = randomString();
        String scope = "write read";
        HttpServletRequest request = mockRequest("test_client_id", "test_client_secret");
        // mock ?????????client???
        OAuth2ClientDO client = randomPojo(OAuth2ClientDO.class).setClientId("test_client_id");
        when(oauth2ClientService.validOAuthClientFromCache(eq("test_client_id"), eq("test_client_secret"),
                eq(granType), eq(Lists.newArrayList("write", "read")), isNull())).thenReturn(client);

        // mock ????????????????????????
        OAuth2AccessTokenDO accessTokenDO = randomPojo(OAuth2AccessTokenDO.class)
                .setExpiresTime(addTime(Duration.ofMillis(30050L))); // ?????? 10 ???????????????????????????
        when(oauth2GrantService.grantPassword(eq(username), eq(password), eq("test_client_id"),
                eq(Lists.newArrayList("write", "read")))).thenReturn(accessTokenDO);

        // ??????
        CommonResult<OAuth2OpenAccessTokenRespVO> result = oauth2OpenController.postAccessToken(request, granType,
                null, null, null, username, password, scope, null);
        // ??????
        assertEquals(0, result.getCode());
        assertPojoEquals(accessTokenDO, result.getData());
        assertEquals(30L, result.getData().getExpiresIn()); // ??????????????????????????????
    }

    @Test
    public void testPostAccessToken_refreshToken() {
        // ????????????
        String granType = OAuth2GrantTypeEnum.REFRESH_TOKEN.getGrantType();
        String refreshToken = randomString();
        String password = randomString();
        HttpServletRequest request = mockRequest("test_client_id", "test_client_secret");
        // mock ?????????client???
        OAuth2ClientDO client = randomPojo(OAuth2ClientDO.class).setClientId("test_client_id");
        when(oauth2ClientService.validOAuthClientFromCache(eq("test_client_id"), eq("test_client_secret"),
                eq(granType), eq(Lists.newArrayList()), isNull())).thenReturn(client);

        // mock ????????????????????????
        OAuth2AccessTokenDO accessTokenDO = randomPojo(OAuth2AccessTokenDO.class)
                .setExpiresTime(addTime(Duration.ofMillis(30010L))); // ?????? 10 ???????????????????????????
        when(oauth2GrantService.grantRefreshToken(eq(refreshToken), eq("test_client_id"))).thenReturn(accessTokenDO);

        // ??????
        CommonResult<OAuth2OpenAccessTokenRespVO> result = oauth2OpenController.postAccessToken(request, granType,
                null, null, null, null, password, null, refreshToken);
        // ??????
        assertEquals(0, result.getCode());
        assertPojoEquals(accessTokenDO, result.getData());
        assertEquals(30L, result.getData().getExpiresIn()); // ??????????????????????????????
    }

    @Test
    public void testPostAccessToken_implicit() {
        // ??????????????????
        assertServiceException(() -> oauth2OpenController.postAccessToken(null,
                        OAuth2GrantTypeEnum.IMPLICIT.getGrantType(), null, null, null,
                        null, null, null, null),
                new ErrorCode(400, "Token ??????????????? implicit ????????????"));
    }

    @Test
    public void testRevokeToken() {
        // ????????????
        HttpServletRequest request = mockRequest("demo_client_id", "demo_client_secret");
        String token = randomString();
        // mock ?????????client???
        OAuth2ClientDO client = randomPojo(OAuth2ClientDO.class).setClientId("demo_client_id");
        when(oauth2ClientService.validOAuthClientFromCache(eq("demo_client_id"),
                eq("demo_client_secret"), isNull(), isNull(), isNull())).thenReturn(client);
        // mock ??????????????????
        when(oauth2GrantService.revokeToken(eq("demo_client_id"), eq(token))).thenReturn(true);

        // ??????
        CommonResult<Boolean> result = oauth2OpenController.revokeToken(request, token);
        // ??????
        assertEquals(0, result.getCode());
        assertTrue(result.getData());
    }

    @Test
    public void testCheckToken() {
        // ????????????
        HttpServletRequest request = mockRequest("demo_client_id", "demo_client_secret");
        String token = randomString();
        // mock ??????
        OAuth2AccessTokenDO accessTokenDO = randomPojo(OAuth2AccessTokenDO.class).setUserType(UserTypeEnum.ADMIN.getValue()).setExpiresTime(new Date(1653485731195L));
        when(oauth2TokenService.checkAccessToken(eq(token))).thenReturn(accessTokenDO);

        // ??????
        CommonResult<OAuth2OpenCheckTokenRespVO> result = oauth2OpenController.checkToken(request, token);
        // ??????
        assertEquals(0, result.getCode());
        assertPojoEquals(accessTokenDO, result.getData());
        assertEquals(1653485731L, result.getData().getExp()); // ??????????????????????????????
    }

    @Test
    public void testAuthorize() {
        // ????????????
        String clientId = randomString();
        // mock ?????????client???
        OAuth2ClientDO client = randomPojo(OAuth2ClientDO.class).setClientId("demo_client_id").setScopes(ListUtil.toList("read", "write", "all"));
        when(oauth2ClientService.validOAuthClientFromCache(eq(clientId))).thenReturn(client);
        // mock ?????????approve???
        List<OAuth2ApproveDO> approves = asList(
                randomPojo(OAuth2ApproveDO.class).setScope("read").setApproved(true),
                randomPojo(OAuth2ApproveDO.class).setScope("write").setApproved(false));
        when(oauth2ApproveService.getApproveList(isNull(), eq(UserTypeEnum.ADMIN.getValue()), eq(clientId))).thenReturn(approves);

        // ??????
        CommonResult<OAuth2OpenAuthorizeInfoRespVO> result = oauth2OpenController.authorize(clientId);
        // ??????
        assertEquals(0, result.getCode());
        assertPojoEquals(client, result.getData().getClient());
        assertEquals(new KeyValue<>("read", true), result.getData().getScopes().get(0));
        assertEquals(new KeyValue<>("write", false), result.getData().getScopes().get(1));
        assertEquals(new KeyValue<>("all", false), result.getData().getScopes().get(2));
    }

    @Test
    public void testApproveOrDeny_grantTypeError() {
        // ??????????????????
        assertServiceException(() -> oauth2OpenController.approveOrDeny(randomString(), null,
                        null, null, null, null),
                new ErrorCode(400, "response_type ?????????????????? code ??? token"));
    }

    @Test // autoApprove = true??????????????????
    public void testApproveOrDeny_autoApproveNo() {
        // ????????????
        String responseType = "code";
        String clientId = randomString();
        String scope = "{\"read\": true, \"write\": false}";
        String redirectUri = randomString();
        String state = randomString();
        // mock ??????
        OAuth2ClientDO client = randomPojo(OAuth2ClientDO.class);
        when(oauth2ClientService.validOAuthClientFromCache(eq(clientId), isNull(), eq("authorization_code"),
                eq(asSet("read", "write")), eq(redirectUri))).thenReturn(client);

        // ??????
        CommonResult<String> result = oauth2OpenController.approveOrDeny(responseType, clientId,
                scope, redirectUri, true, state);
        // ??????
        assertEquals(0, result.getCode());
        assertNull(result.getData());
    }

    @Test // autoApprove = false??????????????????
    public void testApproveOrDeny_ApproveNo() {
        // ????????????
        String responseType = "token";
        String clientId = randomString();
        String scope = "{\"read\": true, \"write\": false}";
        String redirectUri = "https://www.iocoder.cn";
        String state = "test";
        // mock ??????
        OAuth2ClientDO client = randomPojo(OAuth2ClientDO.class);
        when(oauth2ClientService.validOAuthClientFromCache(eq(clientId), isNull(), eq("implicit"),
                eq(asSet("read", "write")), eq(redirectUri))).thenReturn(client);

        // ??????
        CommonResult<String> result = oauth2OpenController.approveOrDeny(responseType, clientId,
                scope, redirectUri, false, state);
        // ??????
        assertEquals(0, result.getCode());
        assertEquals("https://www.iocoder.cn#error=access_denied&error_description=User%20denied%20access&state=test", result.getData());
    }

    @Test // autoApprove = true????????? + token
    public void testApproveOrDeny_autoApproveWithToken() {
        // ????????????
        String responseType = "token";
        String clientId = randomString();
        String scope = "{\"read\": true, \"write\": false}";
        String redirectUri = "https://www.iocoder.cn";
        String state = "test";
        // mock ?????????client)
        OAuth2ClientDO client = randomPojo(OAuth2ClientDO.class).setClientId(clientId).setAdditionalInformation(null);
        when(oauth2ClientService.validOAuthClientFromCache(eq(clientId), isNull(), eq("implicit"),
                eq(asSet("read", "write")), eq(redirectUri))).thenReturn(client);
        // mock ?????????????????????
        when(oauth2ApproveService.checkForPreApproval(isNull(), eq(UserTypeEnum.ADMIN.getValue()),
                eq(clientId), eq(SetUtils.asSet("read", "write")))).thenReturn(true);
        // mock ????????????????????????
        OAuth2AccessTokenDO accessTokenDO = randomPojo(OAuth2AccessTokenDO.class)
                .setAccessToken("test_access_token").setExpiresTime(addTime(Duration.ofMillis(30010L)));
        when(oauth2GrantService.grantImplicit(isNull(), eq(UserTypeEnum.ADMIN.getValue()),
                eq(clientId), eq(ListUtil.toList("read")))).thenReturn(accessTokenDO);

        // ??????
        CommonResult<String> result = oauth2OpenController.approveOrDeny(responseType, clientId,
                scope, redirectUri, true, state);
        // ??????
        assertEquals(0, result.getCode());
        assertEquals("https://www.iocoder.cn#access_token=test_access_token&token_type=bearer&state=test&expires_in=30&scope=read", result.getData());
    }

    @Test // autoApprove = false????????? + code
    public void testApproveOrDeny_approveWithCode() {
        // ????????????
        String responseType = "code";
        String clientId = randomString();
        String scope = "{\"read\": true, \"write\": false}";
        String redirectUri = "https://www.iocoder.cn";
        String state = "test";
        // mock ?????????client)
        OAuth2ClientDO client = randomPojo(OAuth2ClientDO.class).setClientId(clientId).setAdditionalInformation(null);
        when(oauth2ClientService.validOAuthClientFromCache(eq(clientId), isNull(), eq("authorization_code"),
                eq(asSet("read", "write")), eq(redirectUri))).thenReturn(client);
        // mock ?????????????????????
        when(oauth2ApproveService.updateAfterApproval(isNull(), eq(UserTypeEnum.ADMIN.getValue()), eq(clientId),
                eq(MapUtil.builder(new LinkedHashMap<String, Boolean>()).put("read", true).put("write", false).build())))
                .thenReturn(true);
        // mock ????????????????????????
        String authorizationCode = "test_code";
        when(oauth2GrantService.grantAuthorizationCodeForCode(isNull(), eq(UserTypeEnum.ADMIN.getValue()),
                eq(clientId), eq(ListUtil.toList("read")), eq(redirectUri), eq(state))).thenReturn(authorizationCode);

        // ??????
        CommonResult<String> result = oauth2OpenController.approveOrDeny(responseType, clientId,
                scope, redirectUri, false, state);
        // ??????
        assertEquals(0, result.getCode());
        assertEquals("https://www.iocoder.cn?code=test_code&state=test", result.getData());
    }

    private HttpServletRequest mockRequest(String clientId, String secret) {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter(eq("client_id"))).thenReturn(clientId);
        when(request.getParameter(eq("client_secret"))).thenReturn(secret);
        return request;
    }

}
