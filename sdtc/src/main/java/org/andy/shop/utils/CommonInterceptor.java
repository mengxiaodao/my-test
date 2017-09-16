package org.andy.shop.utils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
public class CommonInterceptor  extends HandlerInterceptorAdapter{
	private final String ADMINSESSION = "adminsession";  
	  //拦截前处理  
	  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {  
	    Object sessionObj = request.getSession().getAttribute(ADMINSESSION);  
	    if(sessionObj!=null) {   
	      return true;  
	    }else{
	    	//不符合条件的，跳转到登录界面  
            response.sendRedirect(request.getContextPath() + "/accessLogin/login");
            return false;  
	    }  
	  }  
	  //拦截后处理  
	  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mav) throws Exception { }  
	  //全部完成后处理  
	  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e) throws Exception { }  
	}  

