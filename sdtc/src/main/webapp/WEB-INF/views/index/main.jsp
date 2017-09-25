<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>信息管理系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<!-- basic styles -->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/jquery-easyui-1.3.3/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/jquery-easyui-1.3.3/themes/icon.css">
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/jquery-easyui-1.3.3/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

	<script type="text/javascript">
		$(function(){
			// 数据
			var treeData=[{
				text:"根",
				children:[
				{
					text:"资源管理",
					attributes:{
						url:"../msgManage/pageInit.do"
					}
				},
				{
					text:"铜仁旅游信息管理",
					attributes:{
						url:"tourism.jsp"
					}
				},
				{
					text:"互动交流信息管理",
					attributes:{
						url:"communication.jsp"
					}
				},{
					text:"城乡发展信息管理",
					attributes:{
						url:"develop.jsp"
					}
				}
				]
			}];
			// 实例化树菜单
			$("#tree").tree({
				data:treeData,
				lines:true,
				onClick:function(node){
					if(node.attributes){
						openTab(node.text,node.attributes.url);
					}
				}
			});
		});
		
		// 新增Tab方法
		function openTab(text,url){
			if($("#tabs").tabs('exists',text)){
				$("#tabs").tabs('select',text);
			}else{
				var content="<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src="+url+"></iframe>";
				$("#tabs").tabs('add',{
					title:text, //tab的title
					closable:true, //显示关闭控件
					content:content, //下面内容
				 	tools:[{
							iconCls:'icon-reload',
							handler:function(){  //刷新当前tab
								var current_tab = $('#tabs').tabs('getSelected'); //当前tab
								$('#tabs').tabs('update',{
								     tab:current_tab,
								     options : {
							       		href : ''
							       		//或者content : "<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src="+url+"></iframe>",
								     }
								});
							}
					    }]
				});
			}
		}
	</script>
</head>
<body class="easyui-layout">
	<div region="north" style="height: 80px;background-color: #E0EDFF">
		<div align="left" style="width: 80%;float: left"><img src="../images/tongren_main.png"></div>
		<div style="padding-top: 50px;padding-right: 20px;">当前用户：&nbsp;<font color="red" >${currentUser.userName }</font></div>
		
	</div>
	
	<!--新增tab页面  -->
	<div region="center">
		<div class="easyui-tabs" fit="true" border="false" id="tabs">
			<div title="首页" >
				<div align="center" style="padding-top: 100px;"><font color="red" size="10">欢迎使用</font></div>
			</div>
		</div>
	</div>
	
	<!-- 树形菜单 -->
	<div region="west" style="width: 150px;" title="导航菜单" split="true">
		<ul id="tree"></ul>
	</div>
	<div region="south" style="height: 25px;" align="center">铜仁欢迎您<a href="http://www.tongren.gov.cn/index.html">www.tongren.gov.cn</a></div>
</body>
</html>

