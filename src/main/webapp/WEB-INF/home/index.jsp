<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String[] loc = { "강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구",
		"서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구" };
%>
<%@ include file="../common/header.jspf"%>
<!-- Navigation-->

<!-- Page Content-->

<div class="container index-container">
	
	<form action="/hospi/getlist" style="width : 70%">
		<input type="hidden" name="page" value="1" /> 
		<select name="type" id="type" class="form-select mt-3">
			<option value="0" selected="selected">병원</option>
			<option value="1">의원</option>
		</select>
		<select name="location" id="location" class="form-select mt-3">
			<c:forEach var="loc" items="<%=loc%>">
				<option value="${loc }">${loc }</option>
			</c:forEach>
		</select> <input type="submit" value="병원찾기" class="btn btn-dark mt-3 w-100"/>
	</form>
</div>
<!-- Bootstrap core JS-->

<!-- Core theme JS-->
<%@ include file="../common/footer.jspf"%>
