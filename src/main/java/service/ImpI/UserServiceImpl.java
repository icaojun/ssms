package service.ImpI;

import bean.Module;
import bean.User;
import dao.ModuleDao;
import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private ModuleDao moduleDao;

	/**
	 * 根据账号Account查询当前用户
	 * @param account
	 * @return
	 */
	public User findByAccount(String account) {
		return userDao.findByAccount(account);
	}

	/**
	 * 获取资源集合
	 * @param account
	 * @return
	 */
	public Set<String> queryRolesByName(String account) {
		Set<String>modules = userDao.queryRolesByName(account);
		return modules;
	}

	/**
	 * 获取URL权限
	 * @param account
	 * @return
	 */
	public List<String> findPermissionUrl(String account) {
		List<String> list = new ArrayList<String>();
		User user = findByAccount(account);
		List<Module>modules = moduleDao.findModuleByUserId(user.getId());
		
		for(Module info: modules) {
			if(info.getModuleType() == info.URL_TYPE) {
				list.add(info.getModulePath());
			}
		}
		return list;
	}
}