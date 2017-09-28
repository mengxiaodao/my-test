/**
 * 时间戳转日期字符串,将日期类型转换成字符串型格式 yyyy-MM-dd 
 * @param nows
 * @returns {String}
 */
function changeDateToString(timeStamp) { 
	var paramDate=new Date(timeStamp); 
	var year=paramDate.getFullYear(); 
	var month=paramDate.getMonth()+1; 
	if(month < 10){
		month = "0"+month;
	}
	var date=paramDate.getDate(); 
	if(date < 10){
		date = "0"+date;
	}
	return year+"-"+month+"-"+date; 
}
/**
 * 时间戳转日期时间字符串,将日期类型转换成字符串型格式 yyyy-MM-dd hh:mm:ss
 * @param nows
 * @returns {String}
 */
function changeDateToStringTime(timeStamp) { 
	var paramDate=new Date(timeStamp); 
	var year=paramDate.getFullYear(); //年
	var month=paramDate.getMonth()+1; //月
	var date=paramDate.getDate(); //日
	var hh = paramDate.getHours();  //时
	var mm = paramDate.getMinutes(); //分
	var ss = paramDate.getSeconds(); //秒
	if(month < 10){
		month = "0"+month;
	}
	if(date < 10){
		date = "0"+date;
	}
	if(hh < 10){
		hh = "0"+hh;
	}
	if(mm < 10){
		mm = "0"+mm;	
	}
	if(ss < 10){
		ss = "0"+ss;
	}
	return year+"-"+month+"-"+date+" "+hh+":"+mm+":"+ss; 
}
//js字符串验证不为空
function isEmpty(str){
	if(str =='' || str == null && typeof(str)=="undefined"){
		return true;
	}
	return false;
}

/*
 var obj={}; 导出公共js方法
 obj.rows=5000;
 obj.params=getParams();
 obj.countUrl="/groupSaleReports/getReportCount.action";
 obj.exportUrl=getUrl();
 obj.spanId='exportGroupSaleSpan';
 obj.divId='exportGroupSaleDiv';
 saleCommon.exportExcel(obj);
*/
function exportExcel(obj){
    $.post(obj.countUrl,obj.params,function(rs){
        if(rs.status){
            var  count = rs.data;
            var inm = 0;
            var rows = parseInt(obj.rows);
            if(count != 0){
                inm = count / rows;
            }else{
                $.messager.alert("提示", " 抱歉，当前没有数据可供导出!", "info");
                return;
            }
            if (inm <= 1) {
                window.location.href = obj.exportUrl + "&page=1"; //少于3000条直接导出
                return;
            } else {
                var index = parseInt(inm);
                if (inm > index) {
                    index += 1;
                }
                var temp = '';
                for (var i = 0; i < index; i++) {
                    temp += '<span style="font-size:15px;text-align:center;">' + (i * rows + 1) + '-' + ((i + 1) * rows) + '条&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=' + obj.exportUrl + "&page=" + (i + 1) + '>导出</a></span><br/><hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />';
                }
                $('#'+obj.spanId).text("").append(temp);
                $("#"+obj.divId).window('open'); //打开窗口
                //backendCommon.openeWin(""+obj.divId);
            }
        }
    });
}