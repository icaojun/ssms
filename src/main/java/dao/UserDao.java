/**
 * FileName: UserDao
 * Author: 曹俊
 * Date: 2017/12/6 18:06
 * Description:
 */
package dao;

import bean.User;

import java.util.Set;

public interface UserDao {
    User findByAccount(String account);
    Set<String> queryRolesByName(String account);
}
