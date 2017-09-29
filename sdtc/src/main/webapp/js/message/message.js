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
    $('#messageListTb').datagrid({
        loadMsg : "",
        url : ctx + '/msgManage/getMsgList.do',
        nowrap : false,
        fitColumns : true,
        striped : true,
        rownumbers : true,
        singleSelect : false,
        pagination : true,
        pageList: [5,10,15,20],
        pageSize:5,
        queryParams : param,
        columns:[[
            {field:'id',align : 'center',title:'资源id',width:20},
            {field:'msgName',align : 'center',title:'资源名称',width:40},
            {field:'publishTime',align : 'center',title:'资源发布日期',width:30,formatter:function (value, row, index) {
                return changeDateToString(value);
            }},
            {field:'msgType',align : 'center',title:'资源类型',width:20,formatter:function (value, row, index) {
            	if (value == 1) { //资源类别，1广告大牌，2电视多媒体，3LED显示屏	
                    return '广告大牌';
                } else if (value == 2) {
                    return "电视多媒体";
                } else if (value == 3) { 
                    return 'LED显示屏';
                }
            }},
            {field:'msgPrice',align : 'center',title:'资源售价',width:20},
            {field:'provinceId',align : 'center',title:'所属省份',width:20},
            {field:'cityId',align : 'center',title:'所属城市',width:20},
            {field:'createTime',align:'center',title:'创建时间',width:40,formatter:function (value, row, index) {
                return changeDateToStringTime(value);
            }},
            {field:'operater',align:'center',title:'操作',width:30,formatter:function (value, row, index) {
               var str = '<a href="javascript:openMsgAddDialog('+row.id+')" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>' +
                		'&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:deleteMsg('+row.id+')" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>';
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
        $("#messageListTb").datagrid("load",params); //从第一页开始
    }
}
//重置查询参数
function resetSerchParam(){
	$("#msgName").val("");		
	$("#msgType").val("");
	//$("#date").datebox("setValue","");
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
		msgName:$.trim($("#msgName").val()),//资源名称
		msgType:$.trim($("#msgType").val()),//资源类型
    };
    return params;
}

//新增弹出框
function openMsgAddDialog(id){
	//加个清空操作
	resetValue();
	if(!isEmpty(id)){
		//编辑
		alert(id);
		$("#editDlg").dialog("open").dialog("setTitle","编辑资源信息");
	}else{
		//添加
		$("#editDlg").dialog("open").dialog("setTitle","添加资源信息");
	}
}
//关闭新增、编辑弹出框
function closeMsgDialog(){
	$("#editDlg").dialog("close");
}
//保存资源
function saveMsg(){
	$("#editFm").form("submit",{
		url:ctx + '/msgManage/insertMsg.do',
		onSubmit:function(){
			return $(this).form("validate"); //验证是否通过
		},
		success:function(result){
			var data = eval('('+result+')');
			if(data.status){
				$.messager.alert("系统提示",data.message);
				$("#editDlg").dialog("close");
				$("#messageListTb").datagrid("load"); 
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
//删除资源信息,参数id
function deleteMsg(id){
	if(!isEmpty(id)){
		$.messager.confirm("系统提示","您确认要删掉这条数据吗？",function(r){
			if(r){
				$.get(ctx + '/msgManage/deleteMsgById.do',{id:id},function(result){
					if(result.status){
						$.messager.alert("系统提示","您已成功删除这条数据！");
						$("#messageListTb").datagrid("reload");
					}else{
						$.messager.alert('系统提示',result.message);
					}
				});
			}
		});
	}
}
/**
 * 导出excel
 */
function exportMsgExcel(){
	var obj={};
	var params = getSearchValues();//导出参数
	obj.params = params;
	obj.rows = 5;//多少条每个表
	obj.countUrl = ctx + '/msgManage/getMsgExportCount.do';//总共导出的条数接口
	
	//拼接导出excel参数
	var exParams = "&msgName="+params.msgName+"&msgType="+params.msgType;
	obj.exportUrl = ctx + '/msgManage/exportMsgList.do?rows='+obj.rows + exParams; //导出excel接口
	
	obj.spanId='exportSpan';	//填充span
	obj.divId='exportWin'; //弹出div
	//调用公用导出方法
	exportExcel(obj);
}

