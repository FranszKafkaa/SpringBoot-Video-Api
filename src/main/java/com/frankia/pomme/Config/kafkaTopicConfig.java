package com.frankia.pomme.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class kafkaTopicConfig {
    @Bean
    public NewTopic messageTopic(){
        return TopicBuilder.name("message").build();
    }

    @Bean
    public NewTopic videoCompresserTopic(){
        log.info("creating a video topic");
        return TopicBuilder.name("video").build();
    }
}
