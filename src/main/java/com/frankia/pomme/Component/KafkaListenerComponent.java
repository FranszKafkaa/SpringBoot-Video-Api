package com.frankia.pomme.Component;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerComponent {
    @KafkaListener(topics = "message", groupId = "groupId")
    void listner(ConsumerRecord<String, String> data) {
        System.out.println("listned in message " + data.value() + " key " + data.key());
    }

    @KafkaListener(topics = "send_video", groupId = "groupid")
    void videoCompresser(ConsumerRecord<String, String> data){
        System.out.println("ai que delicia o verao ain");
    }

    @KafkaListener(topics = "recieved_video", groupId = "group_id")
    void videoDone(){
        System.out.println("ola mundo");
    }
}
