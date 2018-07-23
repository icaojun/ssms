package dao;

import bean.Module;
import java.util.List;

public interface ModuleDao {

	/**
	 * 获取该人的权限模块
	 * @param userId
	 * @return
	 */
	List<Module> findModuleByUserId(int userId);
}
