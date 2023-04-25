/**
 * 
 */
 
 function login_check(session){
	if (session == null) {
		alert("로그인이 필요합니다.");
		return false;
	}

	return true;
}

function writer_check(usernum ,session){
	if(session == -1){
		return true;
	}
	if(session == null){
		alert('권한이 없습니다.');
		return false;
	}
	if(usernum != session){
		alert('권한이 없습니다.');
		return false;
	}
	
	return true;
}