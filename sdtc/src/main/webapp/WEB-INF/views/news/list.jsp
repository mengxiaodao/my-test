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
<script type="text/javascript" src="<%=request.getContextPath()%>/js/message/news.js?version=20171221"></script>
</head>
<body >
	<div style="margin-top: 15px;" class="easyui-panel">
		
		<div>
			<div>
				<a href="javascript:openNewsAddDialog('')" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			</div>
			<div>
			   	&nbsp;&nbsp;&nbsp;<span>标题：</span><input type="text" id="title"  size="15" maxlength="15"/>
				&nbsp;&nbsp;&nbsp;<span>类型：</span>
				<select  id="type" >
					<option value="" >请选择</option >
					<option value="1" >头条</option >
					<option value="2" >百科</option >
					<option value="3" >行业</option >
				</select>
				<a href="javascript:doSearch()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
				<a href="javascript:resetSerchParam()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">置空</a>
				<a href="javascript:exportMsgExcel()" class="easyui-linkbutton" iconCls="icon-print" plain="true">导出</a>
			</div>
		</div> 
		
		<table id="newsListTb" title="用户列表"  >
			
		</table>
		
		<!-- 新增编辑弹出框 -->
		<div id="editDlg" class="easyui-dialog" style="width: 570px;height: 350px;padding: 10px 20px"
			closed="true" buttons="#dlg-buttons">
			<form id="editFm" method="post">
				<table cellspacing="5px;">
					<tr>
						<td>标题：</td>
						<td>
							<input type="text" name="title"  class="easyui-validatebox" required="true"/>
						</td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>				
					</tr>
					<tr>
						<td>副标题：</td>
						<td>
							<input type="text" name="subTitle"  class="easyui-validatebox" required="true"/>
						</td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td>缩略图：</td>
						<td>
					   		<input type="text" name="thumbnail"   class="easyui-validatebox"  required="true"/>
					   	</td>
						<td></td>
					</tr>
					<tr>
						<td>内容：</td>
						<td>
							<input type="text" name="content"   class="easyui-validatebox"  required="true"/>
						</td>
						<td></td>
					</tr>
					<tr>
						<td>类别：</td>
						<td>
							<select name="type" class="easyui-validatebox" required="true" >
								<option value="" >请选择</option >
								<option value="1" >头条</option >
								<option value="2" >百科</option >
								<option value="3" >行业</option >
							</select>
						</td>
						<td></td>
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

