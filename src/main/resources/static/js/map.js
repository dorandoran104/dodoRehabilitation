/**
 * 
 */
let wgs84Lat = document.getElementById("wgs84Lat").value;
let wgs84Lon = document.getElementById("wgs84Lon").value;
let hpName = document.getElementById("hpName").innerHTML;

var mapContainer = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스

var mapOption = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(wgs84Lat, wgs84Lon), //지도의 중심좌표.
	level: 3 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(mapContainer, mapOption);; //지도 생성 및 객체 리턴

var markerPosition = new kakao.maps.LatLng(wgs84Lat, wgs84Lon);

//마커를 생성합니다
var marker = new kakao.maps.Marker({
	position: markerPosition
});

//마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

var iwContent = '<div style="padding:5px; width:200px"><span style="font-size:0.9rem">'
	+ hpName
	+ '</span><br><a class="btn btn-sm btn-outline-primary" href="https://map.kakao.com/link/map/'
	+ hpName
	+ ','
	+ wgs84Lat
	+ ','
	+ wgs84Lon
	+ '" style="font-size:0.9rem" target="_blank">큰지도보기</a> <a class="btn btn-sm btn-outline-primary" href="https://map.kakao.com/link/to/'
	+ hpName
	+ ','
	+ wgs84Lat
	+ ','
	+ wgs84Lon
	+ '" style="font-size:0.9rem" target="_blank">길찾기</a></div>'; // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
var iwPosition = new kakao.maps.LatLng(wgs84Lat, wgs84Lon); //인포윈도우 표시 위치입니다

// 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({
	position: iwPosition,
	content: iwContent
});

// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
infowindow.open(map, marker); 




