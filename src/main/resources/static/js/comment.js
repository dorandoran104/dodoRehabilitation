$(document).ready(function() {
	let hpid = $("#hpid").val();
	console.log(hpid);

	$.ajax({
		url: "/comments/" + hpid,
		type: "GET",
		dataType: "json",
		success: function(data) {
			resultHTML(data)
		},
		error: function() {
			console.log("실패");
		}
	});
});

function resultHTML(data) {
	$("#comment_table").empty();


	let html = '<table class="table w-100 align-middle ">';

	$.each(data, function(key, value) {
		html += "<tr>";
		html += "<td>" + value.NICKNAME + "</td>";
		html += "<td>" + value.BODY + "</td>";
		html += "<td>" + value.WRITEDATE + "</td>";
		html += "<tr>";

	});
	html += '</table>';

	$("#comment_table").append(html);
}