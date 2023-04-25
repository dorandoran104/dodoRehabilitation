<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:set var="pageTitle" value="회원가입"></c:set>
<%@ include file="../common/header.jspf"%>
<div class="container index-container">
	<form action="/mem/dojoin" method="post" name="frm" style="width : 70%">
		<div class="joinForm">
			<div class="mb-3">
				<label for="nickname" class="form-label">닉네임</label> <input
					type="text" class="form-control" name="nickname" id="nickname"
					placeholder="닉네임">
			</div>
			<div class="mb-3">
				<label for="userid" class="form-label">아이디</label> <input
					type="text" class="form-control" name="userid" id="userid"
					placeholder="아이디">
			</div>
			<div class="mb-3">
				<label for="userpwd" class="form-label">비밀번호</label> <input
					type="password" class="form-control" name="userpwd" id="userpwd"
					placeholder="비밀번호" onkeyup="check()">
			</div>
			<div class="mb-3">
				<label for="check_pwd" class="form-label">비밀번호확인</label> <input
					type="password" class="form-control" name="check_pwd" id="check_pwd"
					placeholder="비밀번호" onkeyup="check()">
				<div id="pwd_temp"></div>
				<input type="hidden" name="hasCheck"/>
			</div>
			<div class="mb-3">
				<label for="phone" class="form-label">전화번호</label> <input
					type="text" class="form-control" name="phone" id="phone"
					placeholder="전화번호">
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">이메일</label> <input type="text"
					class="form-control" name="email" id="email" placeholder="이메일">
			</div>
			<div>
				<input type="submit" value="회원가입" class="btn btn-outline-secondary" onclick="return doJoin()"/>
				<input type="reset" value="초기화" class="btn btn-outline-secondary"/>
				<input type="button" onclick="history.back()" value="뒤로가기" class="btn btn-outline-secondary"/>
			</div>
		</div>

	</form>
</div>
<script src="/js/member.js"></script>
<%@ include file="../common/footer.jspf"%>