let commnets = '';

$(document).ready(function() {

	let csrfHeader = document.querySelector("#csrfHeader").value;
	let csrfToken = document.querySelector("#csrfToken").value;
	let userName = document.querySelector("#userName").value;

	$.ajaxSetup({
		beforeSend: function(xhr, settings) {
			if (!/^(GET|HEAD|OPTIONS)$/i.test(settings.type) && !this.crossDomain) {
				xhr.setRequestHeader(csrfHeader, csrfToken)
			}
		}
	});

	let hpid = $("#hpid").val();
	console.log(hpid);

	//댓글 불러오기
	getList();

	$("#comment_submit").on("click", function(e) {
		e.preventDefault();
		writeComment();

	});

	//댓글 작성하기
	function writeComment() {
		let param = {
			hpid: hpid,
			body: $("#floatingTextarea2").val(),
			userid: userName
		}
		$.ajax({
			url: "/comments/new",
			type: "POST",
			data: JSON.stringify(param),
			contentType: "application/json; charset=utf-8",
			success: function(e) {
				getList();
				$("#floatingTextarea2").val("");

				if ($.isNumeric($("#comment_size").text())) {
					let num = parseInt($("#comment_size").text()) + 1;
					$("#comment_size").text(num);
				}
			},
			error: function(e) {
				alert('error');
			}
		});
	}

	//댓글 삭제하기
	$(document).on("click", ".comment_delete", function(e) {
		e.preventDefault();

		if (userName != $(this).data("us")) {
			alert("권한이 없습니다.");
			return false;
		}

		if (confirm('삭제하시겠습니까?')) {
			let id = $(this).attr("href");
			console.log(id);

			$.ajax({
				url: "/comments/" + id,
				type: 'delete',
				success: function() {
					getList();

					if ($.isNumeric($("#comment_size").text())) {
						let num = parseInt($("#comment_size").text()) - 1;
						$("#comment_size").text(num);
					}
				},
				error: function() {
					alert('오류 : 잠시후에 다시 시도해주세요');
				}
			});
		}
	});

	function getList() {
		$.ajax({
			url: "/comments/" + hpid,
			type: "GET",
			dataType: "json",
			success: function(data) {
				console.log(data);
				resultHTML(data)
			},
			error: function() {
				console.log("실패");
			}
		});
	}
	
	//수정하기 누를때
	$(document).on("click", ".comment_modify", function(e) {
		e.preventDefault();

		if (userName != $(this).data("us")) {
			alert("권한이 없습니다.");
			return false;
		}

		commnets = $(this).closest("tr").clone();
		let str = '';

		str += '<td colspan="3"><textarea style="background-color : white;" class="form-control"name="body" id="body" >';
		str += $(this).closest("tr").find("td[class='comment-body']").text() + '</textarea></td>';
		str += '<td><a href="' + $(this).attr("href") + '" class="btn btn-outline-secondary btn-sm comment-modify">수정</a></td>';
		str += '<td><a href="#" class="btn btn-outline-secondary btn-sm comment-reset">취소</a></td>';

		$(this).closest("tr").html(str);
	})
	//수정 창에서 수정 누를시
	$(document).on("click", ".comment-modify", function(e) {
		e.preventDefault();
		let body = $(this).parents("tr").find("textarea").val();

		$.ajax({
			url: "/comments/" + $(this).attr("href"),
			type: "put",
			data: body,
			contentType: "application/json; charset=utf-8",
			success: function() {
				getList();
			},
			error: function() {
				alert('오류 잠시 후에 다시 시도해주세요');
			}
		});
	});

	//수정 창에서 취소 누를시
	$(document).on("click", ".comment-reset", function(e) {
		e.preventDefault();
		$(this).closest("tr").html(commnets.html());
	});


});

//댓글 불러오기
function resultHTML(data) {
	$("#comment_table").empty();

	let html = '';

	$.each(data, function(key, value) {
		html += addComment(value);
	});

	$("#comment_table").append(html);
}

function addComment(value) {
	let html = "<tr>";
	html += "<td>" + value.nickname + "</td>";
	html += "<td class='comment-body'>" + value.body + "</td>";
	html += "<td>" + value.writeDate + "</td>";
	html += '<td style="width: 5%">'
		+ '<a href="'
		+ value.id
		+ '" class="btn btn-outline-secondary btn-sm comment_modify" data-us="' + value.userid + '">수정</a></td>'
		+ '<td style="width: 5%"><a href="'
		+ value.id + '"  data-us="' + value.userid + '" class="btn btn-outline-secondary btn-sm comment_delete">삭제</a></td>'
		+ "</tr>";

	return html;
}