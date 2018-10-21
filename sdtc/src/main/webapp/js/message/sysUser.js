$(function () {
	//初始化数据表格
	initDataGrid({});
	/**
	 * reload加载数据分页从当前页开始，load从第一页开始
	 * window.parent.$('#tabs').tabs('close','铜仁新闻信息管理'); //调用父窗口的关闭tab选显卡方法
	 *	window.parent.openTab("title","url"); //调用父窗口的openTab方法
	 */
});
function initDataGrid(param) {
    $('#userListTb').datagrid({
        loadMsg : "",
        url : ctx + '/sysUser/getUsersList.do',
        nowrap:true,
        fitColumns : true,
        striped : true,
        rownumbers : true,
        singleSelect : false,
        pagination : true,
        pageList: [5,10,15,20],
        pageSize:5,
        queryParams : param,
        columns:[[
            {field:'id',align : 'center',title:'用户id',width:20},
            {field:'userName',align : 'center',title:'用户名',width:40},
            {field:'name',align : 'center',title:'真实姓名',width:20},
            {field:'createTime',align:'center',title:'创建时间',width:40,formatter:function (value, row, index) {
                return changeDateToStringTime(value);
            }},
            {field:'operater',align:'center',title:'操作',width:30,formatter:function (value, row, index) {
               var str = '&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:deleteMsg('+row.id+')" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>';
               return str;
            }}
        ]],
        onLoadSuccess:function(data){
        	//请求成功回调函数
        }
    });
}

//搜索按钮，点击查询
function doSearch() {
    if(checkSearchParameter()) { //如果参数验证通过
        var params = getSearchValues();
        $("#userListTb").datagrid("load",params); //从第一页开始
    }
}
//重置查询参数
function resetSerchParam(){
	$("#userName").val("");
	$("#name").val("");
}
//参数验证，ture、false
function checkSearchParameter() {
    var params = getSearchValues();
    /*
    if (saleCommon.isNotEmpty(params.searchStartTime) && saleCommon.isNotEmpty(params.searchEndTime)
        && params.searchStartTime > params.searchEndTime) {
        $.messager.alert("警告","使用开始时间不能大于结束时间","warning");
        return false;
    }*/
    return true;
}
//获取查询参数
function getSearchValues() {
    var params = {
        userName:$.trim($("#userName").val()),//资源名称
        name:$.trim($("#name").val()),//资源类型
    };
    return params;
}

//新增弹出框
function openMsgAddDialog(id){
	//加个清空操作
	resetValue();
	if(!isEmpty(id)){
		//编辑
		$("#editDlg").dialog("open").dialog("setTitle","编辑用户信息");
	}else{
		//添加
		$("#editDlg").dialog("open").dialog("setTitle","新增用户信息");
	}
}
//关闭新增、编辑弹出框
function closeSysUserDialog(){
	$("#editDlg").dialog("close");
}
//保存资源
function saveSysUser(){
	$("#editFm").form("submit",{
		url:ctx + '/sysUser/insertSysUser.do',
		onSubmit:function(){
			return $(this).form("validate"); //验证是否通过
		},
		success:function(result){
			var data = eval('('+result+')');
			if(data.status){
				$.messager.alert("系统提示",data.message);
				$("#editDlg").dialog("close");
				$("#userListTb").datagrid("load");
			}else{
				$.messager.alert("系统提示",data.errorMsg);
				return;
			}
		}
	});
}
//清空编辑弹框内容
function resetValue(){
	$("#editFm").get(0).reset();
}
//删除用户信息,参数id
function deleteMsg(id){
	if(!isEmpty(id)){
		$.messager.confirm("系统提示","您确认要删掉这条数据吗？",function(r){
			if(r){
				$.get(ctx + '/sysUser/delete.do',{id:id},function(result){
					if(result.status){
						$.messager.alert("系统提示","您已成功删除这条数据！");
						$("#userListTb").datagrid("reload");
					}else{
						$.messager.alert('系统提示',result.message);
					}
				});
			}
		});
	}
}
