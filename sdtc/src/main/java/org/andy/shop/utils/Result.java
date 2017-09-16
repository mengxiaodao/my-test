package org.andy.shop.utils;

import java.io.Serializable;
/**
 * @author mengchuang
 * @time:2017年9月16日 下午6:30:50
 * @Description: 封装统一返回result数据格式
 */
public class Result implements Serializable{
	private static final long serialVersionUID = 8826949492568164044L;
	final String SUCCESS="success";  
	    final String ERROR="error";  
	    /** 响应数据 */  
	    private Object data;  
	    /** 响应分页 */  
	    /** 响应状态 */  
	    private Boolean status = true;  
	    /** 响应消息 */  
	    private String message;  
	  
	    public Result() {}  
	  
	    public Result(Object data) {  
	        this.data = data;  
	    }  
	  
	    public Result(String message, Boolean status) {  
	        this.set(message, status);  
	    }  
	  
	    public Result(String message, Boolean status, Object data) {  
	        this.set(message, status);  
	        this.data = data;  
	    }  
	  
	     
	  
	    public void set(String message, Boolean status) {  
	        this.status = status;  
	        this.message = message;  
	        this.data="";  
	    }  
	  
	    public void set(String message, Boolean status,String count, Object data) {  
	        this.status = status;  
	        this.message = message;  
	        this.data = data;  
	    }  
	  
	    public Boolean getStatus() {  
	        return status;  
	    }  
	  
	    public void setStatus(Boolean status) {  
	        this.status = status;  
	        this.message=this.status?"成功":"失败";  
	        this.data="";  
	    }  
	  
	    public String getMessage() {  
	        return message;  
	    }  
	  
	    public void setMessage(String message) {  
	        this.message = message;  
	    }  
	  
	    public Object getData() {  
	        return data;  
	    }  
	  
	    public void setData(Object data) {  
	        this.data = data;  
	    }    

}
