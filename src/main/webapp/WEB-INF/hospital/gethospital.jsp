<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="pageTitle" value="병원찾기"></c:set>

<script type="text/javascript" src="${api}"></script>

<%@ include file="../common/header.jspf"%>
<input type="hidden" name="session" value="${loginUser}" id="loginUser"/>
<div class="container pt-3">
	<div class="row">
		<div class="col-md-12">
			<table class="table table-light" style=" width : 100%; height : 450px;">
				<tr>
					<td style="width:10%">병원</td>
					<td id="hpName">${hospital.dutyName }</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>${hospital.dutyAddr }</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td>${hospital.dutyTel1 }</td>
				</tr>
				<tr>
					<td rowspan="8">진료시간</td>
					<td>월 : ${hospital.dutyTime1s }</td>
				</tr>
				<tr>
					<td>화 : ${hospital.dutyTime2s }</td>
				</tr>
				<tr>
					<td>수 : ${hospital.dutyTime3s }</td>
				</tr>
				<tr>
					<td>목 : ${hospital.dutyTime4s }</td>
				</tr>
				<tr>
					<td>금 : ${hospital.dutyTime5s }</td>
				</tr>
				<tr>
					<td>토 : ${hospital.dutyTime6s }</td>
				</tr>
				<tr>
					<td>일 : ${hospital.dutyTime7s}</td>
				</tr>
				<tr>
					<td>공휴일 : ${hospital.dutyTime8s }</td>
				</tr>
				<tr>
					<td colspan="2"><div id="map" style="margin:0 auto; width: 100%; height: 450px"></div></td>
				</tr>
				<tr>
					<td colspan="2">
						<button id="backList" class="btn btn-outline-secondary">병원목록</button>
						<button type="button" class="btn btn-outline-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo">정보 수정요청</button>
					</td>
				</tr>
			</table>
		</div>
		<input type="hidden" id="wgs84Lat" value="${hospital.wgs84Lat}" /> 
		<input type="hidden" id="wgs84Lon" value="${hospital.wgs84Lon }" />
	</div>
	
		<!-- 정보 수정 폼 -->
	<div class="mt-1">
		<div class="modal fade" id="exampleModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">정보수정요청</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<form id="hospitalForm" action="/admin/abWrite" method="post">
							<input type="hidden" name="hpid" value="${hospital.hpid}"/>
							
							<input type="hidden" name="page" value="${cri.page}" />
							<input type="hidden" name="type" value="${cri.type}" />
							<input type="hidden" name="location" value="${cri.location}" />
							<input type="hidden" name="keyword" value="${cri.keyword}" />
							
							<div class="mb-3">
								<label for="recipient-name" class="col-form-label">항목:</label>
								<select name="type_info" id="recipient-name" class="form-control">
									<option value="병원명">병원명</option>
									<option value="주소">주소</option>
									<option value="진료시간">진료시간</option>
									<option value="폐업/휴업">폐업/휴업</option>
									<option value="지도 수정">지도 수정</option>
									<option value="기타">기타</option>
								</select>
							</div>
							<div class="mb-3">
								<label for="message-text" class="col-form-label">메세지:</label>
								<textarea name="body" class="form-control" id="message-text"></textarea>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
								<button type="reset" class="btn btn-primary">초기화</button>
								<button type="submit" onclick="return info_check()" class="btn btn-primary">전송</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- 정보 수정 끝 -->
	</div>

	<!-- 코멘트 관련  -->
	<div class="mt-4 row">
		<div class="col-md-12">
			<div class="d-flex">
				<h4>병원 장터</h4>
				<h6>
					<span class="badge bg-secondary ms-2" id="comment_size">${comment.size()}</span>
				</h6>
			</div>
			
			<sec:authorize access="isAuthenticated()">
			<form id="commentForm" action="/comm/dowrite" method="post">
				<input id="hpid" type="hidden" name="hpid" value="${hospital.hpid}" /> 
				
				<input type="hidden" name="page" value="${page}" /> 
				<input type="hidden" name="type" value="${type}" />
				<input type="hidden" name="location" value="${location}" />
				
				<div class="form-floating d-flex">
					<textarea class="form-control" placeholder="comment" name="body" id="floatingTextarea2" style="height: 100px" maxlength="350"></textarea>
					<input type="submit" value="작성" id="comment_submit" class="btn btn-outline-secondary" />
				</div>
			</form>
			</sec:authorize>
		</div>
		
		<table class="table w-100 align-middle" id="comment_table">
			
		</table>
	</div>
</div>


<script src="/js/hospital.js"></script>
<script src="/js/comment.js"></script>
<script src="/js/map.js"></script>

<%@ include file="../common/footer.jspf"%>
