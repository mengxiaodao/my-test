package org.andy.shop.controller;


import java.util.List;

import javax.annotation.Resource;

import org.andy.shop.model.User;
import org.andy.shop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/accessLogin")
public class LoginController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/login.do")
	public ModelAndView  login(){
		String myName="孟创ceshi";
		//获取所有用户
		List<User> users = userService.getAllUsers();
		
		ModelAndView mav = new ModelAndView();  
		mav.addObject("myName", myName);
		mav.addObject("user", users.get(0));
		mav.setViewName("/login"); //返回的文件名 
		return mav;
	}
	
}
