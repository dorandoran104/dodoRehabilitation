<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="pageTitle" value="버그&건의"></c:set>

<%@ include file="../common/header.jspf"%>
<div class="container mt-3 ">
	<div class="row row-cols-1 row-cols-md-2 g-4">
		<div class="col">
			<div class="card border-dark mb-3">
				<div class="card-header bg-transparent border-dark">Header</div>
				<div class="card-body">
					<h5 class="card-title">Success card title</h5>
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>
				<div class="card-footer bg-transparent border-dark">Footer</div>
			</div>
		</div>
		<div class="col">
			<div class="card border-dark mb-3">
				<div class="card-header bg-transparent border-dark">Header</div>
				<div class="card-body">
					<h5 class="card-title">Success card title</h5>
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>
				<div class="card-footer bg-transparent border-dark">Footer</div>
			</div>
		</div>
	</div>
</div>


<div class="container bug_container">
	<table class="table">
		<tr>
			<th  class="bg-light w-25">제목</th>
			<td  class="bg-light">${board.title}</td>
		</tr>
		<tr>
			<th  class="bg-light">작성자</th>
			<td>${board.nickname}</td>
		</tr>
		<tr>
			<td colspan="2">${board.body}</td>
		</tr>
	</table>
	<a href="/bboard/getlist" class="btn btn-dark">목록</a>
	<a href="/bboard/modifyForm?id=${board.id}" class="btn btn-dark">수정</a>
	<a href="/bboard/deleteAction?id=${board.id}" onclick="return confirm('삭제하시겠습니까?')" class="btn btn-dark">삭제</a>


</div>
<script type="text/javascript" src="/js/bboard.js">

</script>
<%@ include file="../common/footer.jspf"%>