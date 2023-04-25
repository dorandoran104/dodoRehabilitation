<%@page import="java.util.Arrays"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String[] loc = { "강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구","서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구" };
%>
<c:set var="pageTitle" value="병원찾기"></c:set>

<%@ include file="../common/header.jspf"%>

<div class="container custom_container">

	<div style="width: 90%; margin: 0 auto;">
		
		<form action="/hospi/getlist" class="pt-3 d-flex">
			<div class="d-flex w-50">
				<input type="hidden" name="page" value="1" /> 
				<select name="type" id="type" class="form-select">
					<c:choose>
						<c:when test="${type==0 }">
							<option value="0" selected="selected">병원</option>
							<option value="1">의원</option>
						</c:when>
						<c:otherwise>
							<option value="0">병원</option>
							<option value="1" selected="selected">의원</option>
						</c:otherwise>
					</c:choose>
				</select> 
				<select name="location" id="location" class="form-select">
					<c:forEach var="loc" items="<%=loc%>">
						<c:choose>
							<c:when test="${loc == location }">
								<option value="${loc}" selected="selected">${loc }</option>
							</c:when>
							<c:otherwise>
								<option value="${loc}">${loc }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			<input type="submit" value="병원찾기" class="btn btn-dark btn-sm" />
		</form>


		<!-- 병원 리스트 -->
		<table class="table mt-3 align-middle table-hover" style="width : 100%">
			<c:forEach var="list" items="${list}">
				<tr style="height : 80px;">
					<td>
						<div><a class="fs-4" href="/hospi/gethospital?hpid=${list.hpid}&page=${page}&type=${type}&location=${location}">${list.dutyName}</a></div>
						<div style="background-color: rgba(255,255,255,0.4)" >${list.dutyAddr}</div>
					</td>
					<!-- <td style="height : 50px;">
						<c:choose>
							<c:when test="${list.dutyDivNam == true}">의원</c:when>
							<c:otherwise>병원</c:otherwise>
						</c:choose></td>
					 -->
				</tr>
			</c:forEach>
		</table>
		
		<nav aria-label="Page navigation example" class="mt-4 pt-3">
			<ul class="pagination justify-content-center pagination-sm">
				<li class="page-item">
					<a class="page-link ${page == 1 ?'disabled':''}" href="#"
						onclick="location.replace('/hospi/getlist?page=1&type=${type}&location=${location}')">&lt;&lt;</a>
				</li>
				<li class="page-item">
					<a class="page-link ${page == 1 ?'disabled':''}" href="#"
						onclick="location.replace('/hospi/getlist?page=${page-1}&type=${type}&location=${location}')">Prev</a>
				</li>
					<!-- 
					<c:forEach var="count" begin="${(Math.ceil(page/10)-1)*10+1}" end="${Integer.valueOf(Math.floor(size/10)/10*100 )<= 10*(Math.ceil(page/10)-1)+1?size:Math.ceil(page/10)*10}">
						<li class="page-item ${page == count ?'active':''}">
						<a class="page-link" href="/hospi/getlist?page=${count}&type=${type}&location=${location}">${count}</a></li>
					</c:forEach>
					
				 -->
				 	<c:forEach var="count" begin="${ (Math.ceil(page/5)-1)*5+1 }" end="${Math.floor(size/5)*5+1 <=page?size: Math.ceil(page/5)*5}">
						<li class="page-item ${page == count ?'active':''}">
						<a class="page-link" href="/hospi/getlist?page=${count}&type=${type}&location=${location}">${count}</a></li>
					</c:forEach>
				<li class="page-item">
					<a class="page-link ${page == size ?'disabled':''}"
						href="#" onclick="location.replace('/hospi/getlist?page=${page+1}&type=${type}&location=${location}')">Next</a>
				</li>
				<li class="page-item">
					<a class="page-link ${page == size ?'disabled':''}"
						href="#" onclick="location.replace('/hospi/getlist?page=${size}&type=${type}&location=${location}')">&gt;&gt;</a>
				</li>
			</ul>
		</nav>
		
	</div>
</div>

<%@ include file="../common/footer.jspf"%>