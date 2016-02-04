/**
 * 
 */

var montherror = "해당 달을 지정해주세요.";
var selecterror = "일자의 시작과 끝을 모두 지정해주세요.";


function erroralert(msg) {
	alert(msg);
	history.back(); // 이전으로 돌아가라 
}

function accountMonCheck() {
	if(!document.accountForm.monlist.value) {
		alert(montherror);
		document.accountForm.monlist.focus();
		return false;
	}
}

function accountSelCheck() {
	if(!document.accountForm.startday) {
		alert(selecterror);
		document.accountForm.startday.focus();
		return false;
	} else if(!document.accountForm.endday) {
		alert(selecterror);
		document.accountForm.endday.focus();
		return false;
	}
}