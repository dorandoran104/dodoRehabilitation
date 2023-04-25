/**
 * 
 */
function modify(index, hpid, id, body, page, type, location) {
	let locationUTF = decodeURIComponent(location);
	let modifyArea = document.getElementsByClassName('modifyArea');

	modifyArea[index].innerHTML = '<td colspan="5">'
		+ '<form action="/comm/domodify" class="d-flex" method="post">'
		+ '<input type="hidden" name="id" value="'
		+ id
		+ '"/>'
		+ '<input type="hidden" name="hpid" value="'
		+ hpid
		+ '"/>'
		+ '<input type="hidden" name="page" value="'
		+ page
		+ '"/>'
		+ '<input type="hidden" name="type" value="'
		+ type
		+ '"/>'
		+ '<input type="hidden" name="location" value="'
		+ locationUTF
		+ '"/>'
		+ '<textarea class="form-control" placeholder="comment" name="body"'
		+ 'id="floatingTextarea2" style="height: 100px"'
		+ 'onclick="login_Check()">'
		+ body
		+ '</textarea>'
		+ '<input type="submit" value="수정" class="btn btn-outline-secondary"/>'
		+ '<input type="button" onclick="closeModify('
		+ index
		+')" class="btn btn-outline-secondary" value="취소"'
		+ '</form>'
		+ '</td>';
}

function closeModify(index) {
	document.getElementsByClassName('modifyArea')[index].innerHTML = '';
}