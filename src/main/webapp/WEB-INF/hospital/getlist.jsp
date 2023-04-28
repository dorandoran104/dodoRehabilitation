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
	
		<form id="searchForm" action="/hospi/getlist" class="pt-3 d-flex">
			<div class="d-flex w-50">
				<input type="hidden" name="page" value="1" /> 
				<select name="type" id="type" class="form-select">
					<c:choose>
						<c:when test="${pageCri.cri.type == 0 }">
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
							<c:when test="${loc == pageCri.cri.location }">
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
		
		<!--  검색 창 시작 -->
		<div class="mt-3 d-flex">
		  <input id="keyword" type="text" class="form-control" style="width:40%">
		  <a id="keyword_search" href="button" class="btn btn-dark">검색</a>
		</div>

		<!-- 병원 리스트 -->
		<table class="table mt-3 align-middle table-hover" style="width : 100%">
			<c:forEach var="list" items="${list}">
				<tr style="height : 80px;">
					<td>
						<div>
							<a class="fs-4 hpid" href="${list.hpid}">${list.dutyName}</a>
						</div>
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
					<a class="page-link ${pageCri.cri.page == 1 ?'disabled':''}" href="1" >&lt;&lt;</a>
				</li>
				<li class="page-item">
					<a class="page-link ${pageCri.cri.page == 1 ?'disabled':''}" href="${pageCri.cri.page-1}" >Prev</a>
				</li>
				
			 		<c:forEach var="count" begin="${pageCri.startPage}" end="${pageCri.endPage}">
						<li class="page-item">
							<a class="page-link ${pageCri.cri.page == count ? 'active':'' }" href="${count}"> ${count}</a>
						</li>
					</c:forEach>
					
				<li class="page-item">
					<a class="page-link ${pageCri.cri.page == Math.ceil(pageCri.total/15) ?'disabled':''}"
						href="${pageCri.cri.page+1}">Next</a>
				</li>
				<li class="page-item">
					<a class="page-link ${pageCri.cri.page == Math.ceil(pageCri.total/15) ?'disabled':''}"
						href="${Integer.valueOf(Math.ceil(pageCri.total/15))}">&gt;&gt;</a>
				</li>
			
			</ul>
		</nav>
		<form id="hospital_list" action="/hospi/getlist" method="get">
			<input type="hidden" name="page" value="${pageCri.cri.page}"/>
			<input type="hidden" name="location" value="${pageCri.cri.location }" />
			<input type="hidden" name="type" value="${pageCri.cri.type}" />
			<input type="hidden" name="keyword" value="${pageCri.cri.keyword}" />
		</form>
	</div>
</div>

<script src="/js/hospitallist.js"></script>

<%@ include file="../common/footer.jspf"%>