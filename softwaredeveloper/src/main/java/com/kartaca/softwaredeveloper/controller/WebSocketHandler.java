package com.kartaca.softwaredeveloper.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandler extends TextWebSocketHandler {

      @Override
      public void afterConnectionEstablished(WebSocketSession session) throws Exception {
            System.out.println("> i'm here in after socket connection!");
      }

}
