package com.example.demo.handler;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandler extends TextWebSocketHandler{
	
	private static final ConcurrentHashMap<String, WebSocketSession> CLIENT = new ConcurrentHashMap<String, WebSocketSession>();
	
	@Override
	//소켓 서버에 사용자가 들어오면 실행되는 메서드
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//소켓 세션에 생성
		CLIENT.put(session.getId(),session);
	}
	
	@Override
	//소켓 서버에서 사용자가 나가면 실행되는 메서드
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		//소켓 세션에 제거
		CLIENT.remove(session.getId());
	}
	
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		String id = session.getId();
		System.out.print("socket session id : " +id);
		CLIENT.entrySet().forEach(args -> {
			if(!args.getKey().equals(id)) {//id가 같지 않다면 메세지 보내기
				try {
					args.getValue().sendMessage(message);
					System.out.println(message);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
