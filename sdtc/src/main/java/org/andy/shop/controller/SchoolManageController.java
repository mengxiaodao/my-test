package org.andy.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/schoolManage")
public class SchoolManageController {
	
	@RequestMapping("/schoolPageInit.do")
	public ModelAndView  pageInit(){
		String myName="备份";
		ModelAndView mav = new ModelAndView();  
		mav.addObject("myName", myName);
		mav.setViewName("/schoolManage/school"); //返回的文件名 
		return mav;
	}
}
