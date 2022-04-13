package com.mbaraujo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/***
 * This class is responsable to send the message to the topic
 */


@Service
public class Publisher {

    @Value(value = "${topic.baeldung}")
    public String topic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

//    public void sendMessage(String msg){
//        kafkaTemplate.send(topic, msg);
//    }

    public void sendMessage(String msg){

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, msg);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to sent message: "+ msg + "\ndue to: " + ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Sent message: "+ msg + "\nwith offset: " + result.getRecordMetadata().offset());
            }
        });

    }

}
