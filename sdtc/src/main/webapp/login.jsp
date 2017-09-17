<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息管理系统登录</title>
<!-- <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.9.0.min.js"></script> -->
<script type="text/javascript" src="../js/jquery-1.9.0.min.js"></script> <!-- 当前目录 -->
</head>
<body>
	<div align="center" style="padding-top: 50px;">
			<table  width="740" height="500" background="../images/tongren_login.jpg" >
				<tr height="180">
					<td colspan="4"></td>
				</tr>
				<tr height="10">
					<td width="40%"></td>
					<td width="10%">用户名：</td>
					<td>
						<input type="text" value="" name="userName" id="userName"/>
					</td>
					<td width="30%"></td>
				</tr>
				<tr height="10">
					<td width="40%"></td>
					<td width="10%">密  码：</td>
					<td><input type="password" value="" name="password" id="password"/></td>
					<td width="30%"></td>
				</tr>
				<tr height="10">
					<td width="40%"></td>
					<td width="10%">
						<input type="button" value="登录" onclick="loginUser()"/>
					</td>
					<td><input type="button" value="重置" onclick="resetValue()"/>&nbsp;&nbsp;&nbsp;
						<span style="color:red"  id="errorMsg"></span>
					</td>
					<td width="30%"></td>
				</tr>
				<tr height="10">
					<td width="40%"></td>
					<td colspan="3">
						<font color="red">${error }</font>
					</td>
				</tr>
				<tr >
					<td></td>
				</tr>
			</table>
	</div>
</body>
<script type="text/javascript">
	var ctx = '${pageContext.request.contextPath}';
	function loginUser(){
		var userName = $.trim($("#userName").val());
		var password = $.trim($("#password").val());
		 $.ajax({
	            type:"POST",
	            url: ctx + "/clientLogin/login.do",
	            data:{userName:userName,password:password},
	            //成功返回之后调用的函数             
	            success:function(data){
	          		 var result = data;
	          		 console.log(result);
	          		 if(result.status){
	          			 //登录成功，跳转主页
	          			 window.location.href = ctx + "/clientLogin/index.do";
	          		 }else{
	          			 $('#errorMsg').text(result.message); 
	          		 }
	            },
	            //调用出错执行的函数
	            error: function(){
	                alert("登录出错");
	            }         
	         });
	}
</script>
</html>