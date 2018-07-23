/**
 * FileName: CustomRealm
 * Author: 曹俊
 * Date: 2017/12/6 16:59
 * Description:
 */
package controller;

import bean.User;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import service.UserService;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("用户权限认证-----------");
        String account =principalCollection.getPrimaryPrincipal().toString();
        SimpleAuthorizationInfo simple = new SimpleAuthorizationInfo();
        Set<String> strings=userService.queryRolesByName(account);
        simple.setStringPermissions(strings);
        return simple;
    }

    /**
     * 登录
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("用户登录认证-----------");
        String account=authenticationToken.getPrincipal().toString();
        User user =userService.findByAccount(account);
        if(user!=null){
            AuthenticationInfo authenticationInfo= new SimpleAuthenticationInfo(user.getAccount(),
                    user.getPassword(),getName());
            return  authenticationInfo;
        }
        return  null;
    }
}
