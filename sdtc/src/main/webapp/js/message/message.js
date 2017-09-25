$(function () {
	//初始化数据表格
	initDataGrid({});
});
function initDataGrid(param) {
    $('#messageListTb').datagrid({
        loadMsg : "",
        url : ctx + '/msgManage/getMsgList.do',
        nowrap : false,
        fitColumns : true,
        striped : true,
        rownumbers : true,
        singleSelect : false,
        pagination : true,
        pageSize : 10,
        queryParams : param,
        columns:[[
            {field:'id',align : 'center',title:'券编号',width:20},
            {field:'msgName',align : 'center',title:'资源名称',width:50},
            {field:'publishTime',align : 'center',title:'资源发布时间',width:60},
            {field:'msgType',align : 'center',title:'资源类型',width:20},
            {field:'provinceId',align : 'center',title:'所属省份',width:20},
            {field:'cityId',align : 'center',title:'所属城市',width:60},
            {field:'createTime',align : 'center',title:'创建时间',width:60}
            
           /* {field:'status',align : 'center',title:'使用状态',width:$(this).width() * 0.06,formatter:function (value, row, index){
                if (value == 0) {
                    return '<span style="color: blue;">未使用</span>';
                } else if (value == 1) {
                    return "已使用";
                } else if (value == 2) { //未使用 & 有效期已过
                    return '<span style="color: red;">已过期</span>';
                }
            }}*/
        ]],
        onLoadSuccess:function(data){
        	//请求成功回调函数
        }
    });
}




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