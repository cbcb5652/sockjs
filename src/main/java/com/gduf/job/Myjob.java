package com.gduf.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class Myjob {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Scheduled(fixedRate = 1000)
    public void sendMessage(){
        simpMessagingTemplate.convertAndSend("/server/sendMessageByServer",System.currentTimeMillis());
    }

    @Scheduled(fixedRate = 10000)
    public void sendMessageToUser(){
        System.out.println("来自于服务端给指定用户推送的消息的消息");
        simpMessagingTemplate.convertAndSendToUser("1","/sendMessageByServer",System.currentTimeMillis());
    }
}
