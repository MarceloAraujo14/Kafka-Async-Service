package com.mbaraujo.producer.resources;

import com.mbaraujo.avro.schema.Employee;
import com.mbaraujo.employee.EmployeeDetails;
import com.mbaraujo.producer.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/kafka-tut")
public class ProducerController {

    private final Publisher publisher;

    @Autowired
    public ProducerController(Publisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody EmployeeDetails employee){

        publisher.sendMessage(employee);
        return ResponseEntity.ok("Employee: " + employee + ", enviada com sucesso.");

    }
}
