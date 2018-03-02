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
    $('#prodListTb').datagrid({
        loadMsg : "",
        url : ctx + '/buyerCartManage/getProdList.do',
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
            {field:'productCode',align : 'center',title:'商品编码',width:20},
            {field:'productName',align : 'center',title:'商品名称',width:40},
            {field:'qualityPeriod',align : 'center',title:'保质期',width:30},
            {field:'isDeleted',align : 'center',title:'是否删除',width:20,formatter:function (value, row, index) {
            	if (value == 0) { //0未删除，1已删除
                    return '未删除';
                } else {
                    return "已删除";
                }
            }},
            {field:'buyNum',align : 'center',title:'购买数量',width:20,formatter:function (value, row, index) {
                var str = '<input type="text" class="spinnerExample" id="goodsNo'+index+'" />';
                return str;
            }},
            {field:'operater',align:'center',title:'加入购物车1',width:30,formatter:function (value, row, index) {
               var str = '<a href="javascript:addCart(&quot;'+row.id+'&quot;,&quot;'+index+'&quot;)"' +
                                     ' class="easyui-linkbutton" iconCls="icon-edit" plain="true">添加</a>';
               return str;
            }}
        ]],
        onLoadSuccess:function(data){
        	//请求成功回调函数
            $('.spinnerExample').spinner({});
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


/**
 * 添加购物车
 * @param id skuID
 * @param index 第几行数据
 * @returns {boolean}
 */
function addCart(id,index){
    var num = parseInt($("#goodsNo"+index).val());
    //数量不可为0
    if(num == 0){
        $.messager.alert("警告","数量必须大于0","warning");
        return false;
    }

    $.ajax({
        url:"/buyerCartManage/addGoodsToCart.do",
        type:"post",
        data:{"skuId":id,"amount":num},
        dataType: "json",
        success:function(result){
            var data = eval('('+result+')');
            if(data.status){
                $.messager.alert("系统提示",data.message);
                return;
            }else{
                $.messager.alert("系统提示",data.errorMsg);
                return;
            }
        },
        error:function(){
            $.messager.alert('系统错误');
        }
    });
}


