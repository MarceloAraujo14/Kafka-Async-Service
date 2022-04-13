package com.mbaraujo.producer;

import com.mbaraujo.avro.schema.Employee;
import com.mbaraujo.employee.EmployeeDetails;
import org.apache.kafka.clients.producer.ProducerRecord;
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
    private KafkaTemplate<String, Employee> kafkaTemplate;


    public void sendMessage(EmployeeDetails details){

        Employee employee = Employee.newBuilder()
                .setId(details.getId())
                .setFirstName(details.getFirstName())
                .setLastName(details.getLastName())
                .build();

        String key = employee.getId().toString();

        ListenableFuture<SendResult<String, Employee>> future = kafkaTemplate.send(new ProducerRecord(topic, key, employee));

        future.addCallback(new ListenableFutureCallback<SendResult<String, Employee>>() {

            @Override
            public void onSuccess(SendResult<String, Employee> result) {
                System.out.println("Sent message: "+ employee + "\nwith offset: " + result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to sent message: "+ employee + "\ndue to: " + ex.getMessage());
            }

        });

    }


}
