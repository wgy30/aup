package com.wgy.aup.common.user;

import com.auth0.jwt.interfaces.Claim;
import com.wgy.aup.common.core.BaseContextHandler;
import com.wgy.aup.common.core.context.Constants;
import com.wgy.aup.common.utils.DigestUtils;
import com.wgy.aup.common.utils.JwtTokenUtils;
import com.wgy.aup.exception.BasicServiceException;
import com.wgy.aup.mapper.BaseMenuMapper;
import com.wgy.aup.mapper.BaseRoleMapper;
import com.wgy.aup.mapper.BaseUserMapper;
import com.wgy.aup.model.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * @author wgy
 * @version 2021/11/20 22:46:06
 */
@Service
public class AuthBiz{

    @Autowired
    private BaseUserMapper userMapper;

    @Autowired
    private BaseRoleMapper roleMapper;

    @Autowired
    private BaseMenuMapper menuMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    /**
     * 认证
     * @param account
     * @param password
     * @return
     */
    public String token(String account,String password) throws Exception{
        if (account == null || "".equals(account) || password == null || "".equals(password)) {
            throw new BasicServiceException("账号或密码不能为空");
        }
        BaseUser user = userMapper.select(account);
        if (user == null) {
            throw new BasicServiceException("用户不存在");
        }
        String pass = DigestUtils.digest32(password);
        if (!user.getPassword().equals(DigestUtils.digest32(password))) {
            throw new BasicServiceException("密码不正确，请重新输入");
        }
        String token = JwtTokenUtils.createToken(String.valueOf(user.getCode()),user.getAccount(),user.getName());
        //token缓存,15分钟过期，用户账号为key，保证唯一性
        redisTemplate.opsForValue().set(String.valueOf(user.getCode()),token,30, TimeUnit.MINUTES);
        return token;
    }

    /**
     * 授权
     */
    public UserMenu authority() throws Exception{
        boolean flag = JwtTokenUtils.verifyToken(BaseContextHandler.getToken());
        if (!flag) {
            throw new BasicServiceException("token无效，授权失败");
        }
        Map<String, Claim> claimMap = JwtTokenUtils.parseToken(BaseContextHandler.getToken());
        //用户编码
        Long userCode = Long.parseLong(claimMap.get(Constants.KEY_CURRENT_CODE).asString());
        BaseUser user = userMapper.selectByCode(userCode);
        //角色集合
        UserRole roleCode = roleMapper.selectByCodes(userCode);
        if (roleCode == null)
            throw new BasicServiceException("该用户未分配角色");
        //获取角色菜单
        List<BaseMenu> menus = menuMapper.selectByCodes(roleCode.getRoleCode());
        UserMenu userMenu = new UserMenu();
        userMenu.setMenus(menus);
        userMenu.setAccount(user.getAccount());
        userMenu.setUsername(user.getName());
        userMenu.setUserCode(user.getCode());
        userMenu.setEmail(user.getEmail());
        userMenu.setId(user.getId());
        userMenu.setPhone(user.getPhone());
        userMenu.setRoleName(roleCode.getRoleName());
        return userMenu;
    }

}
