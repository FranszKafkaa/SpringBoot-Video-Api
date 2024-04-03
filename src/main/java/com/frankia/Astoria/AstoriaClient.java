package com.frankia.Astoria;

import org.springframework.web.client.RestTemplate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AstoriaClient {
    private String endpoint;

    public AstoriaClient(String endpoint) {
        this.endpoint = endpoint;
    }

    public String sayHello() { 
        return new RestTemplate().getForObject(this.endpoint, String.class);
    }

}
