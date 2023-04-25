<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:set var="pageTitle" value="회원가입"></c:set>
<%@ include file="../common/header.jspf"%>

<div class="container index-container">
	<form action="/mem/dologin" method="post" style="width : 70%">
		<div class="loginForm">
			<input type="hidden" name="url" value="${url}"/>
			<div class="mb-3">
				<label for="userid" class="form-label">아이디</label> <input
					type="text" class="form-control" name="userid" id="userid"
					placeholder="아이디">
			</div>
			<div class="mb-3">
				<label for="userpwd" class="form-label">비밀번호</label> <input
					type="password" class="form-control" id="userpwd" name="userpwd"
					placeholder="비밀번호">
			</div>
			<div>${message}</div>
			<input type="submit" class="btn btn-outline-secondary w-100"
				value="로그인" /> <br /> <input type="button"
				class="btn btn-outline-secondary mt-3 w-100" value="회원가입"
				onclick="location.href='/mem/joinForm'" />
		</div>
	</form>
</div>
<%@ include file="../common/footer.jspf"%>