package org.andy.shop.controller;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.andy.shop.model.User;
import org.andy.shop.service.UserService;
import org.andy.shop.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
/**
 * @author mengchuang
 * @time:2017年9月16日 下午4:38:21
 * @Description:登录认证处理类
 */
@Controller
@RequestMapping("/clientLogin")
public class LoginController {
	@Resource
	private UserService userService;
	/**
	*@autho mc
	*@date 2017年9月16日 下午9:07:58 
	*@Description: 登录
	 */
	@RequestMapping(value="/login.do")
	@ResponseBody
	public Result login(HttpSession session,String userName,String password,User u) throws Exception{
		Result result = new Result();
		if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
			result.set("用户名或密码不能为空", false);
			return result;
		}
		//userName查询对像
		User user = userService.getUserByUserName(userName);
		if (user != null) {
			//密码不匹配，返回密码错误
			if (!password.equals(user.getPassword())) {
				result.set("密码错误", false);
				return result;
			}else {
				result.setStatus(true);
				//登录成功，将用户存入会话中
				session.setAttribute("user", user);
			}
		}else {
			result.set("用户不存在", false);
			return result;
		}
		return result;
	}
	/**
	*@autho mc
	*@date 2017年9月16日 下午9:08:23 
	*@Description: 登录成功，跳转主页
	 */
	@RequestMapping("/main.do")
	public ModelAndView  pageInit(HttpSession session){
		Map<String, Object> map = new HashMap<>();
		map.put("name", "11");
		return new ModelAndView("/index/main",map);
	}
	/**
	*@autho mc
	*@date 2017年9月16日 下午9:09:19 
	*@Description: 退出登录，重定向到主页
	 */
    @RequestMapping("/logout.do")  
    public String logout(HttpSession session) throws Exception{  
        //清除Session  
        session.invalidate();  
        return "redirect:index.do";  
    }  
	
}
