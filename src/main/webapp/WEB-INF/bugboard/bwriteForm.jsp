<%@page import="java.util.Arrays"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:set var="pageTitle" value="버그&건의"></c:set>

<%@ include file="../common/header.jspf"%>

<div class="container mt-3">

	<form action="/bboard/writeAction" method="post">
		<input type="hidden" name="userNum" value="${sessionScope.loginUser}" />
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">제목</label> <input
				type="text" name="title" class="form-control"
				id="exampleFormControlInput1" placeholder="제목" name="title">
		</div>
		<div class="mb-3">
			<label for="exampleFormControlTextarea1" class="form-label">내용</label>
			<textarea class="form-control" id="exampleFormControlTextarea1"
				rows="3" name="body"></textarea>
		</div>
		<div class="form-check">
			<input class="form-check-input" name="secret" value="0" checked="checked" type="radio" id="flexRadioDefault1"> 
			<label class="form-check-label" for="flexRadioDefault1"> 전체 공개 </label>
		</div>
		<div class="form-check">
			<input class="form-check-input" type="radio" name="secret" value="1"
				id="flexRadioDefault2"> <label
				class="form-check-label" for="flexRadioDefault2"> 운영자만 공개 </label>
		</div>

		<input type="submit" value="작성" class="btn btn-dark" /> <input
			type="reset" value="초기화" class="btn btn-dark" />
	</form>
</div>
<script type="text/javascript" src="/js/bboard.js">
	
</script>
<%@ include file="../common/footer.jspf"%>