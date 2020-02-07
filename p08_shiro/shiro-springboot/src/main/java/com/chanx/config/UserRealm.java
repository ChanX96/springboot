package com.chanx.config;

import com.chanx.pojo.AuthUser;
import com.chanx.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

// 自定义Realm
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行了=>授权 doGetAuthorizationInfo");

        // 创建权限信息对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 拿到当前登录的对象
        Subject subject = SecurityUtils.getSubject();
        AuthUser currentAuthUser = (AuthUser) subject.getPrincipal();
        // 设置当前用户的权限
        info.addStringPermission(currentAuthUser.getPerms());

        return info;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了=>认证 doGetAuthenticationInfo");

        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        // 连接真实数据库
        AuthUser authUser = userService.queryUserByName(userToken.getUsername());

        if (authUser == null) {
            return null; // 没有这个人
        }

        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        session.setAttribute("loginUser", authUser);

        // 可以加密：MD5加密，MD5md5盐值加密
        // 密码认证Shiro做，加密了
        return new SimpleAuthenticationInfo(authUser, authUser.getPwd(), ""); // 存入了当前登陆的AuthUser
    }
}
