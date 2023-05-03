$(document).ready(function() {
	let hpid = $("#hpid").val();
	let session = $("#loginUser").val();
	
	//댓글 불러오기
	getList();
	
	//댓글 작성
	/*
	$("#comment_submit").on("click",function(e){
		writeComment();
	});*/
	
	
	$("#floatingTextarea2").on("click",function(e){
		e.preventDefault();
		if(session == null || session == ''){
			alert('로그인이 필요합니다.');
			$('#comment_submit').attr("disabled",true);
		}
	});
	
	$("#comment_submit").on("click",function(e){
		e.preventDefault();
		if(session == null || session == ''){
			alert('로그인이 필요합니다.');
			$('#comment_submit').attr("disabled",true);
			return false;
		}else{
			writeComment();
		}
	});
});



$(document).on("click",".comment_delete",function(e){
	e.preventDefault();
	if($("#loginUser").val() != $(this).attr("href")){
		alert("권한이 없습니다.");
	}
});

$(document).on("click",".comment_modify",function(e){
	e.preventDefault();
	
	if($("#loginUser").val() != $(this).attr("href")){
		alert("권한이 없습니다.");
	}
})



//ajax

//댓글 불러오기(ajax)
function getList(){
	$.ajax({
		url: "/comments/" +  $("#hpid").val(),
		type: "GET",
		dataType: "json",
		success: function(data) {
			resultHTML(data)
		},
		error: function() {
			console.log("실패");
		}
	});
}

//댓글 작성하기
function writeComment(){
	let param = {
			hpid : $("#hpid").val(),
			body : $("#floatingTextarea2").val(),
			userid : $("#loginUser").val()
		}
		
		$.ajax({
			url : "/comments/new",
			type : "POST",
			data : JSON.stringify(param),
			dataType : "json",
			contentType : "application/json; charset=utf-8",
			success : function(result){
				$("#comment_table").append(addComment(result));
				$("#floatingTextarea2").val("");
				
				console.log($.isNumeric($("#comment_size").text()));
				console.log($("#comment_size").text());
				if( $.isNumeric($("#comment_size").text()) ){
					let num = parseInt($("#comment_size").text()) + 1;
					$("#comment_size").text(num);
				}
			},
			error : function(){
				alert('실패');
			}
		});	
}



//메소드 실행

//댓글 불러오기
function resultHTML(data) {
	$("#comment_table").empty();
	
	let html = '';
	
	$.each(data, function(key, value) {
		html += addComment(value);
	});

	$("#comment_table").append(html);
}

function addComment(value){
		let html = "<tr>";
		html += "<td>" + value.nickname + "</td>";
		html += "<td>" + value.body + "</td>";
		html += "<td>" + value.writeDate + "</td>";
		html += '<td style="width: 5%">' 
		+ '<a href="'
		+value.userid 
		+ '" class="btn btn-outline-secondary btn-sm comment_modify")">수정</a></td>'
		+ '<td style="width: 5%"><a href="'
		+ value.userid +'" class="btn btn-outline-secondary btn-sm comment_delete">삭제</a></td>'
		+ "</tr>";
		
		return html;
}