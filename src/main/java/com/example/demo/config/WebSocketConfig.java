package com.example.demo.config;

import java.util.UUID;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.example.demo.handler.WebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{

	private WebSocketHandler webSocketHandler;
	
	public WebSocketConfig(WebSocketHandler webSocketHandler) {
		this.webSocketHandler = webSocketHandler;
	}
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
	
	
		registry.addHandler(webSocketHandler, "/").setAllowedOrigins("*");
		
	}

}
