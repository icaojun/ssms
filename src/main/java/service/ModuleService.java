package service;

import bean.Module;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ModuleService {
	/**
	 * 获取角色模块
	 * @param userId
	 * @return
	 */
	List<Module> findModuleByUserId(int userId);
}
