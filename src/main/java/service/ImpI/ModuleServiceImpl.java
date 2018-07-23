package service.ImpI;

import bean.Module;
import dao.ModuleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ModuleService;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService{
	@Autowired
	private ModuleDao moduleDao;

	/**
	 * 获取角色模块
	 * @param userId
	 * @return
	 */
	public List<Module> findModuleByUserId(int userId) {
		return moduleDao.findModuleByUserId(userId);
	}
}
