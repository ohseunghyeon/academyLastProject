/**
 * 
 */

var montherror = "확인할 달을 지정해주세요.";
var selecterror = "일자의 시작과 끝을 모두 지정해주세요.";


function erroralert(msg) {
	alert(msg);
	history.back(); // 이전으로 돌아가라 
}
/*
function accountMonCheck() {
	if(document.accountForm.monlist < 1 || document.accountForm.monlist > 12) {
		alert(montherror);
		return false;
	}
}

function accountSelCheck() {
	if(!document.accountForm.startday && !document.accountForm.endday) {
		alert(selecterror);
		return false;
	}
}*/