package com.mbaraujo.consumer;

import com.mbaraujo.avro.schema.Employee;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = "${topic.baeldung}", groupId = "${spring.kafka.consumer.group-id}")
    public void listenGroup(@Payload Employee employee){

        System.out.println("Processing employee: " + employee);
    }

}
