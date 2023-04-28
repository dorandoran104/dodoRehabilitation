/**
 * 
 */
 
 $(document).ready(function(){
	let hospitalForm = $("#hospitalForm");
	
	$("#backList").on("click",function(e){
		e.preventDefault();
		let pageTag = hospitalForm.find("input[name='page']").clone();
		let locationTag = hospitalForm.find("input[name='location']").clone();
		let typeTag = hospitalForm.find("input[name='type']").clone();
		let keywordTag = hospitalForm.find("input[name='keyword']").clone();
		
		hospitalForm.empty();
		hospitalForm.append(pageTag).append(locationTag).append(typeTag).append(keywordTag);
	
		hospitalForm.attr("action","/hospi/getlist").attr("method","get").submit();
	});
});