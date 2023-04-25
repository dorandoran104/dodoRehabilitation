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
		<tr class="bg-light">
			<th>번호</th>
			<td style="width : 70%">제목</td>
			<td>작성자</td>
			<td>작성일</td>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.id}</td>
				<c:if test="${list.secret != 1}">
					<td><a href="/bboard/getboard?id=${list.id}">${list.title}</a></td>
				</c:if>
				<c:if test="${list.secret == 1 }">
					<td><a href="/bboard/getboard?id=${list.id}"
						onclick="return writer_check(${list.userNum},${sessionScope.loginUser})">비밀글
							입니다.</a> <svg xmlns="http://www.w3.org/2000/svg" width="16"
							height="16" fill="currentColor" class="bi bi-lock-fill"
							viewBox="0 0 16 16">
  <path
								d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2z" />
</svg></td>
				</c:if>
				<td>${list.nickname}</td>
				<td><fmt:formatDate value="${list.updateDate}" type="both"
						dateStyle="short" timeStyle="short" /></td>
			</tr>
		</c:forEach>
	</table>
	<a href="/bboard/writeForm" class="btn btn-dark"
		onclick="return login_check(${sessionScope.loginUser})">작성</a>

</div>
<script type="text/javascript" src="/js/bboard.js">

</script>
<%@ include file="../common/footer.jspf"%>