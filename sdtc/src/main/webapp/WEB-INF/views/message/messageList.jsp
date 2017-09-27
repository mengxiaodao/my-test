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
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/common-sale.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<!--操作js提取  -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/message/message.js"></script>
</head>
<body >
	<div style="margin-top: 15px;" class="easyui-panel">
		
		<div>
			<div>
				<a href="javascript:openMsgAddDialog('')" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			</div>
			<div>
			   	&nbsp;&nbsp;&nbsp;<span>资源名称：</span><input type="text" id="msgName"  size="15" maxlength="15"/>
				&nbsp;&nbsp;&nbsp;<span>类别：</span>
				<select  id="msgType" >
					<option value="" >请选择</option >
					<option value="1" >广告大牌</option >
				    <option value="2" >电视多媒体</option >
				    <option value="3" >LED显示屏</option >
				</select>
				<a href="javascript:doSearch()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
				<a href="javascript:resetSerchParam()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">置空</a>
				<a href="javascript:exportExcel()" class="easyui-linkbutton" iconCls="icon-print" plain="true">导出</a>
			</div>
		</div> 
		
		<table id="messageListTb" title="资源信息"  >
			
		</table>
		
		<!-- 新增编辑弹出框 -->
		<div id="editDlg" class="easyui-dialog" style="width: 570px;height: 350px;padding: 10px 20px"
			closed="true" buttons="#dlg-buttons">
			<form id="editFm" method="post">
				<table cellspacing="5px;">
					<tr>
						<td>资源名称：</td>
						<td>
							<input type="text" name="msgName"  class="easyui-validatebox" required="true"/>
						</td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>				
					</tr>
					<tr>
						<td>资源价格：</td>
						<td>
					   		<input type="text" name="msgPrice"  class="easyui-numberbox" data-options="min:0,precision:2" required="true"/>
					   	</td>
						<td></td>
					</tr>
					<tr>
						<td>类别：</td>
					   	<td>
					   		<select name="msgType" class="easyui-validatebox" required="true" >
								<option value="" >请选择</option >
								<option value="1" >广告大牌</option >
							    <option value="2" >电视多媒体</option >
							    <option value="3" >LED显示屏</option >
							</select>
					   	</td>
						<td></td>
					</tr>
					<tr>
						<td>发布日期：</td>
						<td>
							<input class="easyui-datebox" name="publishTime"  required="true" editable="false" />
						</td>
					</tr> 
				</table>
			</form>
		</div>
		<div id="dlg-buttons">
			<a href="javascript:saveMsg()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
			<a href="javascript:closeMsgDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
		</div>
		
	</div>
</body>
<script type="text/javascript">
	var ctx = '${pageContext.request.contextPath}';
</script>
</html>

