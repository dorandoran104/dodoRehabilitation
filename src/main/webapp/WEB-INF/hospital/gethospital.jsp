<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="pageTitle" value="병원찾기"></c:set>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9f2d8a1e6980a20e6e4c0db8cd11ba3e"></script>

<%@ include file="../common/header.jspf"%>

<div class="container pt-3">
	<div class=" d-flex">
		<table class="table table-light" style="height : 450px; margin : 0;">
			<tr>
				<td width="90">병원</td>
				<td style="width:50%" id="hpName">${hospital.dutyName }</td>
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
				<td colspan="2" style="height:450px"><div id="map" style="margin:0 auto; width: 90%; height: 100%"></div></td>
			</tr>
		</table>
		
		<input type="hidden" id="wgs84Lat" value="${hospital.wgs84Lat}" /> <input
			type="hidden" id="wgs84Lon" value="${hospital.wgs84Lon }" />
	</div>
	<div class="mt-1">
		<button class="btn btn-outline-secondary"
			onclick="location.href = '/hospi/getlist?page=${page}&type=${type}&location=${location}'">병원목록</button>
		<button type="button" class="btn btn-outline-secondary" data-bs-toggle="modal"
			data-bs-target="#exampleModal" data-bs-whatever="@mdo">정보 수정요청</button>
		<!-- 정보 수정 폼 -->
		<div class="modal fade" id="exampleModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">정보수정요청</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<form action="/admin/abWrite" method="post">
							<input type="hidden" name="hpid" value="${hospital.hpid}"/>
							<div class="mb-3">
								<label for="recipient-name" class="col-form-label">항목:</label>
								<select name="type" id="recipient-name" class="form-control">
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
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">닫기</button>
								<button type="reset" class="btn btn-primary">초기화</button>
								<button type="submit" onclick="return info_check()" class="btn btn-primary">전송</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		
	</div>

	<div class="mt-4">
		<div>
			<div class="d-flex">
				<h4>병원 장터</h4>
				<h6>
					<span class="badge bg-secondary ms-2">${comment.size()}</span>
				</h6>
			</div>
			<form action="/comm/dowrite" method="post">
				<input type="hidden" name="hpid" value="${hospital.hpid}" /> <input
					type="hidden" name="page" value="${page}" /> <input type="hidden"
					name="type" value="${type}" /> <input type="hidden"
					name="location" value="${location}" />
				<div class="form-floating d-flex">
					<textarea class="form-control" placeholder="comment" name="body"
						id="floatingTextarea2" style="height: 100px"
						onclick="login_Check()" maxlength="350"></textarea>
					<input type="submit" onclick="login_Check()" value="작성"
						id="comment_submit" class="btn btn-outline-secondary" />
				</div>
			</form>
		</div>
		<div>
			<table class="table w-100 align-middle">
				<c:forEach var="comments" items="${comment}" varStatus="status">
					<tr
						style="background-color: ${status.index % 2 ==0 ? 'rgba(255,255,255,0.7)':''}">
						<td style="width: 10%;">${comments.NICKNAME}</td>
						<td style="width: 60%;">${comments.BODY}</td>

						<c:choose>
							<c:when test="${comments.USERID == sessionScope.loginUser}">
								<td style="width: 20%;"><fmt:formatDate
										value="${comments.UPDATEDATE}" type="both" /></td>
								<td style="width: 5%"><button
										class="btn btn-outline-secondary btn-sm"
										onclick="modify(${status.index},'${hospital.hpid}',${comments.ID},'${comments.BODY}',${page},${type},'${location}')">수정</button></td>
								<td style="width: 5%"><a
									href="/comm/dodelete?hpid=${hospital.hpid}&id=${comments.ID}&page=${page}&type=${type}&location=${location}"
									class="btn btn-outline-secondary btn-sm"
									onclick="return confirm('삭제하시겠습니까?')">삭제</a></td>
							</c:when>
							<c:otherwise>
								<td colspan="3" style="width: 20%;"><fmt:formatDate
										value="${comments.UPDATEDATE}" type="both" /></td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr class="modifyArea">
					</tr>

				</c:forEach>
			</table>
		</div>
	</div>
</div>





<script>
	function login_Check() {
		if (
<%=session.getAttribute("loginUser")%>
	== null) {
			alert('로그인이 필요합니다.');
			document.getElementById('comment_submit').disabled = true;
		}
	}
</script>
<script src="/js/hospital.js"></script>
<script src="/js/comment.js"></script>
<script src="/js/map.js"></script>

<%@ include file="../common/footer.jspf"%>