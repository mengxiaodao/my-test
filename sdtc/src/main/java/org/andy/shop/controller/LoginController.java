package org.andy.shop.controller;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.andy.shop.model.User;
import org.andy.shop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
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
	* @Title: login 
	* @Description: 登录
	* @param @param session
	* @param @param username
	* @param @param password
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping(value="/login.do")
    public String login(HttpSession session,String userName,String password) throws Exception{        
		if(userName.equals("yuan")&&password.equals("123456")){  
	        //登陆成功  
			session.setAttribute("userName",userName);  
			//重定向  
    		return "redirect:index.do";     
	    }else{  
	        //登陆失败  
	        return "forward:login.jsp";  
	    }     
    }  
	/**
	* @Title: pageInit 
	* @Description: 登录成功，跳转主页
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("/index.do")
	public ModelAndView  pageInit(HttpSession session){
		String myName=(String) session.getAttribute("userName");
		ModelAndView mav = new ModelAndView();  
		mav.addObject("myName", myName);
		mav.setViewName("/index/index"); //返回的文件名 
		return mav;
	}
	
}
