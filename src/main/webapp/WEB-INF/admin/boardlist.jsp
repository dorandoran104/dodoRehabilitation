<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="pageTitle" value="버그&건의"></c:set>

<%@ include file="../common/header.jspf"%>
<div class="d-flex justify-content-evenly pt-3 pb-3 bg-light">
	<a class="link-dark" href="#">정보 수정 요청</a>
	<a class="link-dark" href="/admin/updateForm">DB업데이트</a>
</div>

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
	<table class="table table-hover">
		<tr class="bg-light">
			<th>번호</th>
			<td>유형</td>
			<td>내용</td>
			<td>병원명</td>
			<td>작성자</td>
			
			
		</tr>
		<c:forEach var="list" items="${list}">
		<tr>
			<td>${list.id}</td>
			<td>${list.type}</td>
			<td>${list.body}</td>
			<td><a href="/hospi/gethospital?hpid=${list.hpid}">${list.dutyname}</a></td>
			<td>${list.writer}</td>
		</tr>
		</c:forEach>
	</table>
</div>
<script type="text/javascript" src="/js/bboard.js">

</script>
<%@ include file="../common/footer.jspf"%>