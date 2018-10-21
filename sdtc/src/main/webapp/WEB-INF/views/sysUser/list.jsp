<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户管理</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/common-sale.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<!--操作js提取  -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/message/sysUser.js?version=20171221"></script>
</head>
<body >
	<div style="margin-top: 15px;" class="easyui-panel">
		
		<div>
			<div>
				<a href="javascript:openMsgAddDialog('')" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			</div>
			<div>
			   	&nbsp;&nbsp;&nbsp;<span>用户名：</span><input type="text" id="userName"  size="15" maxlength="15"/>
				&nbsp;&nbsp;&nbsp;<span>姓名：</span><input type="text" id="name"  size="15" maxlength="15"/>
				<a href="javascript:doSearch()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
				<a href="javascript:resetSerchParam()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">置空</a>
				<a href="javascript:exportMsgExcel()" class="easyui-linkbutton" iconCls="icon-print" plain="true">导出</a>
			</div>
		</div> 
		
		<table id="userListTb" title="用户列表"  >
			
		</table>
		
		<!-- 新增编辑弹出框 -->
		<div id="editDlg" class="easyui-dialog" style="width: 570px;height: 350px;padding: 10px 20px"
			closed="true" buttons="#dlg-buttons">
			<form id="editFm" method="post">
				<table cellspacing="5px;">
					<tr>
						<td>用户名：</td>
						<td>
							<input type="text" name="userName"  class="easyui-validatebox" required="true"/>
						</td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>				
					</tr>
					<tr>
						<td>用户密码：</td>
						<td>
							<input type="text" name="passWord"  class="easyui-validatebox" required="true"/>
						</td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td>用户姓名：</td>
						<td>
					   		<input type="text" name="name"   class="easyui-validatebox"  required="true"/>
					   	</td>
						<td></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="dlg-buttons">
			<a href="javascript:saveSysUser()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
			<a href="javascript:closeSysUserDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
		</div>

		
	</div>
</body>
<script type="text/javascript">
	var ctx = '${pageContext.request.contextPath}';
</script>
</html>

