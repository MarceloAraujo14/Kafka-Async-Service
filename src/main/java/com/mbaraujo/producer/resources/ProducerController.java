package com.mbaraujo.producer.resources;

import com.mbaraujo.producer.Publisher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/kafka-tut")
public class ProducerController {

    private final Publisher publisher;

    public ProducerController(Publisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody String msg){
        publisher.sendMessage(msg);
        return ResponseEntity.ok("Mensagem: " + msg + ", enviada com sucesso.");

    }
}
