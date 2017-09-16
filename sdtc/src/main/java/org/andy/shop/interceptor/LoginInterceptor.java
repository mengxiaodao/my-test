package org.andy.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * @author mengchuang
 * @time:2017年9月16日 下午4:06:41
 * @Description:登录认证的拦截器类
 */
public class LoginInterceptor implements HandlerInterceptor{
	/**
	 * Handler（HandlerMapping）执行完成之后调用这个方法 
	 * 使用于统一的异常处理，统一的日志处理等
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}
	/** 
     * 进入Handler（HandlerMapping）方法之后，ModelAndView返回之前调用这个方法 
     */ 
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}
	 /** 
     * Handler（HandlerMapping）执行之前，通过拦截器进行拦截，调用这个方法 
     */  
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		//获取请求的URL  
        String url = request.getRequestURI();  
        
        //URL:login.jsp是公开的，这个demo是除了login提交url是可以公开访问的，其它的URL都进行拦截控制  
        if(url.indexOf("login.do")>=0){  
            return true;  
        }  
        //获取Session，当前会话
        HttpSession session = request.getSession();  
        String userName = (String)session.getAttribute("userName");  
        //当前用户登录，返回true
        if(userName != null){  
            return true;  
        }  
        //不符合条件的，跳转到登录界面  ，进行登录
        request.getRequestDispatcher("/login.jsp").forward(request, response);  
          
        return false;  
	}

}
