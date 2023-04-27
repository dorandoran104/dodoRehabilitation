/**
 * 
 */

$(document).ready(function() {
	//댓글 삭제	
	let commentForm = $("#commentForm");

	$(".c_delete").on("click", function(e) {
		e.preventDefault();
		commentForm.attr("action", "/comm/dodelete").attr("method", "get");
		commentForm.empty();
		commentForm.append("<input type='hidden' name='id' value='" + $(this).attr("href") + "'>'");
		commentForm.submit();
	});
	
	
	//댓글 수정시 숨겨진 textarea창 불러오기
	$(".c_modify").on("click", function(e) {
		e.preventDefault();
		
		let index = $(this).attr("data-index");
		$(".modifyArea").eq(index).css("display", "table-row");

	});
	
	//댓글 수정 취소버튼 누를시 display none
	$(".modify_comm_end").on("click", function() {
		$(".modifyArea").eq(index).css("display", "none");

	});
	
	//수정 버튼 누를시 댓글 수정
	$(".modify_comm_submit").on("click",function(e){
		e.preventDefault();
		
		let index = $(this).attr('data-index');
		
		commentForm.attr("action","/comm/domodify");
		commentForm.empty();
		
		commentForm.append("<input type='hidden' name='body' value='"+  $(".modify_comm").eq(index).val() + "'>");
		commentForm.append("<input type='hidden' name='id' value='" + $(this).attr("href") + "'>");
		
		commentForm.submit();
	});
});

