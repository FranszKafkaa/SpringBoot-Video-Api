package com.frankia.pomme.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.frankia.Astoria.AstoriaClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class AstoriaConfig {

    @Value("${spring.astoria.endpoint}")
    private String endpoint;

    @Bean
    public AstoriaClient astoriaClient(){
        log.info("connecting to Astoria Microsservice Client...");
        return new AstoriaClient(endpoint);
    }
}
