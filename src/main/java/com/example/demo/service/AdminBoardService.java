package com.example.demo.service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.example.demo.apikey.Apikey;
import com.example.demo.dto.AdminBoardVO;
import com.example.demo.repository.AdminBoardRepository;

@Service
public class AdminBoardService {
	
	private AdminBoardRepository adminBoardRepository;

	AdminBoardService(AdminBoardRepository adminBoardRepository) {
		this.adminBoardRepository = adminBoardRepository;
	}

	// XML가져와서 출력/DB저장
	public int getHospitalList() throws SAXException, IOException, ParserConfigurationException {
		String apiKey = new Apikey().getApiKey();
		int page = 1;
		while(true) {
			StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncListInfoInqire"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + apiKey); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("Q0","UTF-8") + "=" + URLEncoder.encode("서울특별시", "UTF-8")); /*주소(시도)*/
	        //urlBuilder.append("&" + URLEncoder.encode("Q1","UTF-8") + "=" + URLEncoder.encode("강서구", "UTF-8")); /*주소(시군구)*/
	        //urlBuilder.append("&" + URLEncoder.encode("QZ","UTF-8") + "=" + URLEncoder.encode("B", "UTF-8")); /*CODE_MST의'H000' 참조(B:병원, C:의원)*/
	        urlBuilder.append("&" + URLEncoder.encode("QD","UTF-8") + "=" + URLEncoder.encode("D016", "UTF-8")); /*CODE_MST의'D000' 참조(D001~D029)*/
	        urlBuilder.append("&" + URLEncoder.encode("QT","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*월~일요일(1~7), 공휴일(8)*/
	        urlBuilder.append("&" + URLEncoder.encode("ORD","UTF-8") + "=" + URLEncoder.encode("NAME", "UTF-8")); /*순서*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(String.valueOf(page), "UTF-8")); /*페이지 번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*목록 건수*/
	        
	        System.out.println(urlBuilder.toString());
	        Document documentInfo = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(urlBuilder.toString());
	        documentInfo.getDocumentElement().normalize();
	        
	        NodeList nodeList = documentInfo.getElementsByTagName("item");
	        
	        for(int i = 0; i<nodeList.getLength(); i++) {
	        	Node node = nodeList.item(i);
	        	Element eElement = (Element) node;
	        	
	        	String hpid = getTagValue("hpid", eElement);
	        	String dutyName = getTagValue("dutyName", eElement);
	        	String dutyDivNam = getTagValue("dutyDivNam", eElement).equals("의원")?"1":"0";
	        	String dutyAddr = getTagValue("dutyAddr", eElement);
	        	String dutyTel1 = getTagValue("dutyTel1", eElement);
	  
	        	String dutyTime1s = getTagValue("dutyTime1s", eElement) + "~" +getTagValue("dutyTime1c", eElement);
	        	String dutyTime2s = getTagValue("dutyTime2s", eElement) + "~" +getTagValue("dutyTime2c", eElement);
	        	String dutyTime3s = getTagValue("dutyTime3s", eElement) + "~" +getTagValue("dutyTime3c", eElement);
	        	String dutyTime4s = getTagValue("dutyTime4s", eElement) + "~" +getTagValue("dutyTime4c", eElement);
	        	String dutyTime5s = getTagValue("dutyTime5s", eElement) + "~" +getTagValue("dutyTime5c", eElement);
	        	String dutyTime6s = getTagValue("dutyTime6s", eElement) + "~" +getTagValue("dutyTime6c", eElement);
	        	String dutyTime7s = getTagValue("dutyTime7s", eElement) + "~" +getTagValue("dutyTime7c", eElement);
	        	String dutyTime8s = getTagValue("dutyTime8s", eElement) + "~" +getTagValue("dutyTime8c", eElement);
	        
	        	String wgs84Lat = getTagValue("wgs84Lat", eElement);
	        	String wgs84Lon = getTagValue("wgs84Lon", eElement);
	        	
	        	
	        	
	        	adminBoardRepository.insertHospital(hpid,dutyName,dutyDivNam, dutyAddr, dutyTel1,dutyTime1s,dutyTime2s,dutyTime3s,dutyTime4s,dutyTime5s,dutyTime6s,dutyTime7s,dutyTime8s,wgs84Lat, wgs84Lon);
        	}
	        if(nodeList.getLength()<100) return 0;
	        page++;
		}//while끝
        
	}

	// xml태그 안 value를 가져오기
	public static String getTagValue(String tag, Element eElement) {
		NodeList nodeList;
		try{
			nodeList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		}catch(Exception e) {
			return null;
		}
		Node nValue = (Node) nodeList.item(0);
		if (nValue == null)
			return null;
		return nValue.getNodeValue();
	}

	
	public void writeAction(AdminBoardVO adminBoardDTO) {
		adminBoardRepository.writeAction(adminBoardDTO);
	}

	public List<AdminBoardVO> getBoardList() {
		List<AdminBoardVO> list = adminBoardRepository.getBoardList();
		return list;
	}
}
