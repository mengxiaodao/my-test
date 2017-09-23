package org.andy.shop.controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/userManage")
public class UserController {
	
	/**
	*@autho mc
	*@date 2017年9月17日 下午6:41:25 
	*@Description: 展示用户管理列表
	 */
	@RequestMapping("/pageInit.do")
	public ModelAndView  pageInit(HttpServletRequest request){
		String menuName = request.getParameter("menuName");
		String parentMenuName = request.getParameter("parentMenuName");
		ModelAndView mav = new ModelAndView();  
		mav.addObject("menuName", menuName);
		mav.addObject("parentMenuName", parentMenuName);
		mav.setViewName("/user/pageList"); //返回的文件名 
		return mav;
	}
}
