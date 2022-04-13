package com.mbaraujo.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @Value(value = "${topic.baeldung}")
    private String topic;

    @Value(value = "${spring.kafka.consumer.group-id}")
    private String groupId;

    @KafkaListener(topics = "${topic.baeldung}", groupId = "${spring.kafka.consumer.group-id}")
    public void listenGroup(String msg){
        System.out.println("Received message in group: "+ groupId + "\n message: " + msg);
    }

}
