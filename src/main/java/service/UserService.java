package service;

import bean.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public interface UserService {
	
	/**
	 * 根据账号Account查询当前用户
	 * @param account
	 * @return
	 */
	User findByAccount(String account);

	/**	
	 * 获取资源集合
	 * @param account
	 * @return
	 */
	Set<String> queryRolesByName(String account);
	
	/**
	 * 获取URL权限
	 * @param account
	 * @return
	 */
	List<String> findPermissionUrl(String account);
}
