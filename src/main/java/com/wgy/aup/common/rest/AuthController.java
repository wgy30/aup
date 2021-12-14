package com.wgy.aup.common.rest;

import com.wgy.aup.common.annotation.CheckUserToken;
import com.wgy.aup.common.annotation.UserTokenIgnore;
import com.wgy.aup.common.user.AuthBiz;
import com.wgy.aup.common.utils.ObjectResponse;
import com.wgy.aup.exception.BasicServiceException;
import com.wgy.aup.model.dto.UserMenu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = "认证授权")
@RestController
@RequestMapping("auth")
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthBiz userBiz;

    @ApiOperation("认证")
    @PostMapping("/token")
    @UserTokenIgnore
    public ObjectResponse token(@RequestBody Map<String,Object> params) {
        try{
            String token = userBiz.token(params.get("account").toString(),params.get("password").toString());
            return new ObjectResponse<>().data(token);
        }catch (BasicServiceException ex) {
            log.error("获取token失败:{}",ex.getMessage());
            return new ObjectResponse<>().fail(ex.getMessage());
        }catch (Exception ex) {
            log.error("获取token异常",ex);
            return new ObjectResponse<>().fail(ex.getMessage());
        }
    }

    @ApiOperation("授权")
    @PostMapping("/authority")
    @CheckUserToken
    public ObjectResponse<UserMenu> authority() {
        try{
            UserMenu userMenu = userBiz.authority();
            return new ObjectResponse<UserMenu>().data(userMenu);
        }catch (BasicServiceException ex) {
            log.error("获取token失败:{}",ex.getMessage());
            return new ObjectResponse<UserMenu>().fail(ex.getMessage());
        }catch (Exception ex) {
            log.error("获取token异常",ex);
            return new ObjectResponse<UserMenu>().fail(ex.getMessage());
        }
    }

}
