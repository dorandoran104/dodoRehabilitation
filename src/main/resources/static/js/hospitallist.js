/**
 * 
 */
 function info_check(){
	alert('전송되었습니다. 감사합니다.');
	return true;
}

$(document).ready(function(){
	let hospital_list = $("#hospital_list");
	
	//페이지네이션 링크 구현
	$(".page-link").on("click",function(e){
		e.preventDefault();
		
		hospital_list.find("input[name='page']").val($(this).attr("href"));
		
		hospital_list.submit();
	});
	
	//병원 상세조회 링크
	$(".hpid").on("click",function(e){
		e.preventDefault();
		hospital_list.attr("action","/hospi/gethospital");
		hospital_list.append("<input type='hidden' name='hpid' value=" + $(this).attr("href")+">");
		hospital_list.submit();
	});
	
	
	//병원 검색 기능
	let searchForm = $("#searchForm");
	
	$("#keyword_search").on("click",function(e){
		e.preventDefault();
		let pageTag = searchForm.find("input[name='page']").clone();
		searchForm.empty();
		
		$("#keyword").val()
		
		searchForm.append(pageTag);
		searchForm.append("<input type='hidden' name='keyword' value='" + $("#keyword").val() + "'>");
		searchForm.attr("action","/hospi/getlist").submit();
	});
	
});