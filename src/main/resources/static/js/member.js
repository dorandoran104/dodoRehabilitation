/**
 * 
 */
function check() {
	let userpwd = document.getElementById('userpwd');
	let check_pwd = document.getElementById('check_pwd');
	let pwd_temp = document.getElementById('pwd_temp');
	if (userpwd.value.length == 0 || check_pwd.value.length == 0) {
		pwd_temp.innerText = '비밀번호가 일치하지 않습니다.';
		pwd_temp.style.color = 'red';
		document.frm.hasCheck.value = '';
	} else if (userpwd.value != check_pwd.value) {
		pwd_temp.innerText = '비밀번호가 일치하지 않습니다.';
		pwd_temp.style.color = 'red';
		document.frm.hasCheck.value = '';
	} else if (userpwd.value == check_pwd.value) {
		pwd_temp.innerText = '비밀번호가 일치합니다.';
		pwd_temp.style.color = 'green';
		document.frm.hasCheck.value = '1';
	}
}

function doJoin(){
	if(document.frm.hasCheck.value != 1){
		return false;
	}
	if(document.frm.hasCheck.value.length == 0){
		return false;
	}
	return true;
}