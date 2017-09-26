/**
 * 时间戳转日期字符串,将日期类型转换成字符串型格式 yyyy-MM-dd 
 * @param nows
 * @returns {String}
 */
function ChangeDateToString(timeStamp) { 
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
//js字符串验证不为空
function isNotEmpty(str){
	if(str =='' || str == null && typeof(str)=="undefined"){
		return true;
	}
	return false;
}
