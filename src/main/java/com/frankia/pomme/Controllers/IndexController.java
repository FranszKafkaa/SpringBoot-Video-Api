package com.frankia.pomme.Controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/")
    public ResponseEntity<Map<String, String>> teste() {
        kafkaTemplate.send("message", "from api");
        return new ResponseEntity<>(new HashMap<String, String>() {
            {
                put("ola", "ain");
            }
        }, HttpStatus.ACCEPTED);
    }

}
