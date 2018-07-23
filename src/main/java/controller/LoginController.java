package controller;

import bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	/**
	 * Go login.jsp
	 * @return
	 */
	@RequestMapping(value="login", method= RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	/**
	 * Go login
	 * @param
	 * @return
	 */
	@RequestMapping(value="login", method= RequestMethod.POST)
	public String login(@RequestParam("account")String account,@RequestParam("password") String password) {
//		User u =userService.findByAccount(account);
//		if(u!=null&&password.equals(u.getPassword())){
//			return "index";
//		}else{
//			return "unauthor";
//		}
		Subject subject =SecurityUtils.getSubject();
		UsernamePasswordToken username=new UsernamePasswordToken(account,password);
		try{
			subject.login(username);
			return "index";
		}catch (Exception e){
			return  "unauthor";
		}

	}
	
	/**
	 * Exit
	 * @return
	 */
	@RequestMapping(value = "logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/login";
	}
}
