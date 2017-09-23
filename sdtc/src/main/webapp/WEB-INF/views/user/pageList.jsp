<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>铜仁新闻管理</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
	/* 我理解的应该是，由于是iframe的页面，所以需要在子页面调用父页面的close方法去关闭panel
	window.parent.$('#tt').tabs('close','修改日志1'); 
	*/
	var url;
	function deleteNews(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].news_id);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要删掉这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("news!delete",{delIds:ids},function(result){
					if(result.success){
						$.messager.alert("系统提示","您已成功删除<font color=red>"+result.delNums+"</font>条数据！");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert('系统提示',result.errorMsg);
					}
				},"json");
			}
		});
	}

	function searchNews(){
		
		//window.parent.$('#tabs').tabs('close','铜仁新闻信息管理'); //调用父窗口的关闭tab选显卡方法
		window.parent.openTab("qqqq","wwwww"); //调用父窗口的openTab方法
		
		$('#dg').datagrid('load',{
			s_title:$('#s_title').val()
		}); 
	}
	
	function openNewsAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","添加新闻信息");
		url="news!save";
	}
	
	function saveNews(){
		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
				
				return $(this).form("validate");
			},
			success:function(result){
				if(result.errorMsg){
					$.messager.alert("系统提示",result.errorMsg);
					return;
				}else{
					$.messager.alert("系统提示","保存成功");
					resetValue();
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
				}
			}
		});
	}
	
	function resetValue(){
		$("#role").val("");		
		$("#title").val("");
		$("#content").val("");
		$("#date").datebox("setValue","");
	}
	
	function closeNewsDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	function openNewsModifyDialog(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","编辑信件信息");
		$("#role").val(row.role);
		$("#title").val(row.title);
		$("#content").val(row.content);	
		$("#date").datebox("setValue",row.date);		
		url="news!save?news_id="+row.news_id;
	}
</script>
</head>
<body style="margin: 5px;">
	<table id="dg" title="新闻信息" class="easyui-datagrid" fitColumns="true"
	 pagination="true" rownumbers="true" url="" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th field="news_id" width="50" align="center">编号</th>
				<th field="role" width="100" align="center">新闻类别</th>
				
				<th field="title" width="250" align="center" >新闻标题</th>
				<th field="content"  width="250" align="center">新闻内容</th>
				<th field="date" width="100" align="center">发布日期</th>
				
			</tr>
		</thead>
	</table>
	
	<div id="tb">
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
	</div>
	
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
</body>
</html>

