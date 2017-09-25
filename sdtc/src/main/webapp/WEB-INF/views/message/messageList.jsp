<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>资源管理</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<!--操作js提取  -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/message/message.js"></script>
</head>
<body >
	<div style="margin-top: 15px;" class="easyui-panel">
		
		<!-- <div id="tb">
			<div>
				<a href="javascript:openNewsAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
				<a href="javascript:openNewsModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
				<a href="javascript:deleteNews()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
			</div>
			<div>
		   &nbsp;标题：&nbsp;<input type="text" name="s_title" id="s_title" size="10"/>
		
			<a href="javascript:searchNews()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
			<span>（注：新闻类别中，“1”代表“动态”，“2”代表“要闻”，“3”代表“资讯”，“4”代表“公告”。）</span>
			</div>
		</div> -->
		
		<table id="messageListTb" title="新闻信息"  >
			
		</table>
		
		<!-- 新增编辑弹出框 -->
		<div id="dlg" class="easyui-dialog" style="width: 570px;height: 350px;padding: 10px 20px"
			closed="true" buttons="#dlg-buttons">
			<form id="fm" method="post">
				<table cellspacing="5px;">
					<tr>
						<td>新闻类别：</td>
						<td><input type="text" name="role" id="role" class="easyui-validatebox" required="true"/></td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>				
					</tr>
					
					<tr>
						<td>标题：</td>
					   <td><input type="text" name="title" id="title" class="easyui-validatebox" required="true"/></td>
						<td></td>
					</tr>
					<tr>
						<td valign="top">内容：</td>
						<td colspan="4"><textarea rows="7" cols="50" name="content" id="content"></textarea></td>
					</tr>
					<tr>
						<td>发布日期：</td>
						<td><input class="easyui-datebox" name="date" id="date" required="true" editable="false" /></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="dlg-buttons">
			<a href="javascript:saveNews()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
			<a href="javascript:closeNewsDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
		</div>
		
	</div>
</body>
<script type="text/javascript">
	var ctx = '${pageContext.request.contextPath}';
</script>
</html>

