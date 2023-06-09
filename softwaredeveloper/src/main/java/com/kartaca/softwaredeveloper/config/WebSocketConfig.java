package com.kartaca.softwaredeveloper.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.kartaca.softwaredeveloper.controller.WebSocketHandler;

/*
 * WEBSOCKET
 */

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
      
      @Autowired
      private WebSocketHandler webSocketHandler;

      @Override
      public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
            registry.addHandler(webSocketHandler, "/api/v1/auction/get");
      }

}
