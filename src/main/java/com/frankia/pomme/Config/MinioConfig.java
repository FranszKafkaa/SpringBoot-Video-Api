package com.frankia.pomme.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.minio.MinioClient;
import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "minio")
public class MinioConfig {

    @Value("${spring.minio.url}")
    private String endpoint;
    @Value("${spring.minio.access-key}")
    private String accessKey;
    @Value("${spring.minio.secret-key}")
    private String secretKey;
    @Value("${spring.minio.bucket}")
    private String bucketName;

    @Bean
    public MinioClient minioClient() {
        System.out.println("Conectando no minio no endereco " + endpoint);
        return MinioClient.builder().endpoint(endpoint).credentials(accessKey, secretKey).build();
    }
}
