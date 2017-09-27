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
